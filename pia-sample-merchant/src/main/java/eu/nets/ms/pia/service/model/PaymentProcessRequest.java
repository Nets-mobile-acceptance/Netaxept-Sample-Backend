package eu.nets.ms.pia.service.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.service.model.PaymentRegisterRequest.Builder;
import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Payment process request")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = PaymentProcessRequest.Builder.class)
public class PaymentProcessRequest {

	@NotNull(message ="Payment operation must be specified")
	@JsonIgnore
	private final Operation operation;
	
	@NotNull(message = "Transaction Id must be provided")
	@Size(min=1, max=32, message = "TransactionId must be between 1-32 characters long")
	@ApiModelProperty(value = "TransactionId", required = true)
	private final String transactionId;
	
	@JsonIgnore
	private final Optional<String> merchantId;
	
	
	@Size(min=1, max=4000, message = "Description must be between 1-4000 characters long")
	@ApiModelProperty(value = "Description", required = false)
	private final String description;
	
	/** 
	 * The transaction reconciliation reference is a reference number allocated to the transaction by the merchant. 
	 * The transaction reference number will be returned to the merchant with the 
	 * settlement if the chosen acquirer supports the return of the transaction-specific reference number. 
	 * The transaction reference number can also be seen in the merchant's bank statement when direct bank payments are in question.
	 * 
	 * This parameter is not set by the merchant app, hence the JsonIgnore. It will be decorated by the backend.
	 * */
	@JsonIgnore
	@Size(min=1, max=32, message = "Reference can be max 32 bytes")
	private final String transactionReference;
	
	@JsonIgnore
	private boolean authRequired;


	
	private PaymentProcessRequest(Builder builder) {
		this.transactionReference = builder.transactionReference;
		this.operation = builder.operation;
		this.transactionId = builder.transactionId;
		this.description = builder.description;
		this.merchantId = Optional.ofNullable(builder.merchantId);
		this.authRequired = builder.authRequired;
	}
	
	
	public String getTransactionReference() {
		return transactionReference;
	}

	public String getTransactionId() {
		return transactionId;
	}
	
	public Optional<String> getMerchantId() {
		return merchantId;
	}


	public String getDescription() {
		return description;
	}
	
	
	
	public Operation getOperation() {
		return operation;
	}

	public boolean getAuthRequired() {
		return authRequired;
	}

	public void setAuthRequired(boolean authRequired) {
		this.authRequired = authRequired;
	}

	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}

	public static Builder newBuilder() {
		return new Builder();
	}
	
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		private Operation operation;
		private String transactionId;
		private String description;
		private String transactionReference;
		private String merchantId;
		private boolean authRequired = true;
		
		public Builder operation(Operation operation){
			this.operation = operation;
			return this;
		}
		
		public Builder transactionId(String transactionId){
			this.transactionId = transactionId;
			return this;
		}
		public Builder merchantId(String merchantId){
			this.merchantId = merchantId;
			return this;
		}
		
		public Builder transactionReference(String transactionReference){
			this.transactionReference = transactionReference;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder authRequired(boolean authRequired){
			this.authRequired = authRequired;
			return this;
		}

		public PaymentProcessRequest build() {
			PaymentProcessRequest dto = new PaymentProcessRequest(this);
            Set<ConstraintViolation<PaymentProcessRequest>> violations = validator.validate(dto);

            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations.iterator().next().getMessage(),
                    new HashSet<ConstraintViolation<?>>(violations));
            }

            return dto;
		}

	}

	
	
}
