package eu.nets.ms.pia.integration;

import java.util.Map;
import java.util.Optional;

import eu.nets.ms.pia.business.domain.PaymentQueryResponse;
import eu.nets.ms.pia.service.model.PaymentProcessRequest;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;

public interface PspConnector {
	
	PaymentRegisterResponse registerTransaction(PaymentRegisterRequest request, Map<String, String> additionalData);
	PaymentProcessResponse  authorizeTransaction(PaymentProcessRequest request);
	PaymentProcessResponse  finalizeTransaction(PaymentProcessRequest request);
	PaymentProcessResponse  verifyTransaction(PaymentProcessRequest request);
	PaymentQueryResponse    queryTransaction(String request, Optional<String> merchantId);

}
