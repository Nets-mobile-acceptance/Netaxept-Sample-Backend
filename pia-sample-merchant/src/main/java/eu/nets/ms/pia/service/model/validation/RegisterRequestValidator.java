package eu.nets.ms.pia.service.model.validation;

import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.EASY_PAY;
import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.APPLE_PAY;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.MethodEnum;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;

public class RegisterRequestValidator implements ConstraintValidator<ValidRegisterRequest, PaymentRegisterRequest>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterRequestValidator.class);
	private static final String EASYPAY_CARDID_REQUIRED = "A card ID is required when using EasyPay";
	private static final String APPLEPAY_DATA_REQUIRED = "Payment data is required when using ApplePay";
	
	@Override
	public void initialize(ValidRegisterRequest constraintAnnotation) {
		//Nothing needed
		
	}

	@Override
	public boolean isValid(PaymentRegisterRequest request, ConstraintValidatorContext context) {
		if(request.getMethod().isPresent()){

			//EasyPay requires a cardId
			if(request.getMethod().get().equals(EASY_PAY)){
				if(!request.getCardId().isPresent()){
					LOGGER.error("EasyPay requires a cardId");
					setConstraintMessage(context, EASYPAY_CARDID_REQUIRED);
					return false;
				}
			}
			//ApplePay requires paymentData
			else if(request.getMethod().get().equals(APPLE_PAY)){
				if(!request.getPaymentData().isPresent()){
					LOGGER.error("ApplePay requires paymentData");
					setConstraintMessage(context, APPLEPAY_DATA_REQUIRED);
					return false;
				}
			}
		}
		return true;
	}
	
	private static void setConstraintMessage(ConstraintValidatorContext context, String messageTemplate) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(messageTemplate)
				.addConstraintViolation();
	}

}
