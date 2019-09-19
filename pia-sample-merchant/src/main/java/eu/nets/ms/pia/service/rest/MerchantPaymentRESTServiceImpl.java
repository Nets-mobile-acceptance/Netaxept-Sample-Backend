package eu.nets.ms.pia.service.rest;

import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import eu.nets.ms.pia.business.logic.PaymentService;
import eu.nets.ms.pia.exception.BusinessServiceException;
import eu.nets.ms.pia.exception.PspException;

import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;
import eu.nets.ms.pia.service.model.ProcessingError;

@Component
public class MerchantPaymentRESTServiceImpl implements MerchantPaymentRESTService {
	private static final String SERVER_ERROR = "Server error";

	private static final Logger LOGGER = LoggerFactory.getLogger(MerchantPaymentRESTServiceImpl.class);

	@Inject
	private PaymentService service;

	@Inject
	private Validator rqValidator;

	@Override
	public Response register(PaymentRegisterRequest request, String merchantId, HttpServletRequest httpServletRequest) {
		try {
			if(merchantId != null && !merchantId.isEmpty()){
				merchantId = merchantId.replaceAll("\\/", "");
				request.setMerchantId(Optional.of(merchantId));
			}
			Set<ConstraintViolation<PaymentRegisterRequest>> violations = rqValidator.validate(request);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
			
			String remoteHost = httpServletRequest.getRemoteHost();
			PaymentRegisterResponse response = service.register(request, remoteHost);
			return ResponseUtils.createResponse(HttpStatus.CREATED.value(), response);
		} catch (Exception ex) {
			return interpretException(ex); 
		}
	}

	@Override
	public Response processPayment(String paymentId, String merchantId, ProcessingOption processingOption,	HttpServletRequest httpServletRequest) {
		try {
			if(merchantId != null && !merchantId.isEmpty()){
				merchantId = merchantId.replaceAll("\\/", "");
			}else{
				merchantId=null;
			}
			PaymentProcessResponse response = null;
			if(Operation.COMMIT.equals(processingOption.getOperation())){
				response = service.process(paymentId, merchantId);
			}else if(Operation.VERIFY.equals(processingOption.getOperation())){
				response = service.verify(paymentId, merchantId);
			}
			
			return ResponseUtils.createResponse(HttpStatus.ACCEPTED.value(), response);
		} catch (Exception ex) {
			return interpretException(ex); 
		}
	}
	
	@Override
	public Response rollbackPayment(String paymentId, String merchantId, HttpServletRequest httpServletRequest) {
		try {
			if(merchantId != null && !merchantId.isEmpty()){
				merchantId = merchantId.replaceAll("\\/", "");
			}else{
				merchantId=null;
			}
			
			service.deletePayment(paymentId, merchantId);
			return ResponseUtils.createResponse(HttpStatus.NO_CONTENT.value());
		} catch (Exception ex) {
			LOGGER.error(SERVER_ERROR, ex);
			return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		}
	}

	
	
	@Override
	public Response getPaymentMethods(String consumerId, HttpServletRequest httpServletRequest) {
		try {
			return Response.ok(service.getPaymentMethods(consumerId)).build();

		} catch (Exception ex) {
			LOGGER.error(SERVER_ERROR, ex);
			return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		}
	}
	
	private static Response interpretException(Exception ex) {
		if (ex instanceof ConstraintViolationException) {
			@SuppressWarnings("rawtypes")
			ConstraintViolation firstViolation = ((ConstraintViolationException) ex).getConstraintViolations().iterator().next();
			LOGGER.info("Constraint violation. message = {}", firstViolation.getMessage());
			ProcessingError error = ProcessingError.newBuilder()
					.explanationText("Constraint violation")
					.addMessage(firstViolation.getMessage())
					.build();
			return ResponseUtils.createResponse(HttpStatus.BAD_REQUEST.value(), error);
		} else if (ex instanceof BusinessServiceException) {
			LOGGER.error("Processing error", ex);
			ProcessingError error = ProcessingError.newBuilder()
					.explanationText("Processing error")
					.addMessage(ex.getMessage())
					.build();
			return ResponseUtils.createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		} else if (ex instanceof PspException) {
			LOGGER.error("Payment service provider error", ex);
			ProcessingError error = ProcessingError.newBuilder()
					.explanationText("Payment service provider error")
					.addMessage(ex.getMessage())
					.build();
			return ResponseUtils.createResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), error);
		} else{
			LOGGER.error(SERVER_ERROR, ex);
			ProcessingError error = ProcessingError.newBuilder()
					.explanationText(SERVER_ERROR)
					.addMessage(ex.getMessage())
					.build();
			return ResponseUtils.createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), error);
		}
	}
}
