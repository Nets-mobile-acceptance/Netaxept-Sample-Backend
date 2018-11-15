package eu.nets.ms.pia.service.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eu.nets.ms.pia.service.model.Operation;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;

public class ValidProcessResponseValidator implements ConstraintValidator<ValidProcessResponse, PaymentProcessResponse>{
	
	@Override
	public void initialize(ValidProcessResponse constraintAnnotation) {
		//Nothing needed
	}

	@Override
	public boolean isValid(PaymentProcessResponse value, ConstraintValidatorContext context) {
		// We don't check AUTHID, because of exceptional cases like Paypal
		return true;
	}

}
