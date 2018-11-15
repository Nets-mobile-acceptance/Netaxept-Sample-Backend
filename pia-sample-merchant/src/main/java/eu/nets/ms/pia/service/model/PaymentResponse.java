package eu.nets.ms.pia.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Payment response")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = PaymentResponse.Builder.class)
public class PaymentResponse {
	
	@NotNull(message = "Transaction Id must be provided")
	@Size(min=1, max=32, message = "TransactionId must be between 1-32 characters long")
	@ApiModelProperty(value = "TransactionId", required = true)
	private final String transactionId;
	
	@NotNull(message = "Authorization id must be provided")
	@ApiModelProperty(value = "Authorization id", required = true)
	private final String authorizationId;
	
	@NotNull(message = "ResponseCode must be provided")
	@ApiModelProperty(value = "Response code", required = true)
	private final ResponseCode responseCode;
	
	@ApiModelProperty(value = "Error", required = false)
	private final ProcessingError error;
	
		
	private PaymentResponse(Builder builder) {
		this.transactionId = builder.transactionId;
		this.authorizationId = builder.authorizationId;
		this.responseCode = builder.responseCode;
		this.error = builder.error;
		
	}
	
	
	public String getTransactionId() {
		return transactionId;
	}


	public String getAuthorizationId() {
		return authorizationId;
	}


	public ResponseCode getResponseCode() {
		return responseCode;
	}


	public ProcessingError getError() {
		return error;
	}


	public static Builder newBuilder(){
    	return new Builder();
    }
	
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private String transactionId;
		private String  authorizationId;
		private ResponseCode  responseCode;
		private ProcessingError  error;
		
		
		public Builder transactionId(String transactionId) {
			this.transactionId = transactionId;
			return this;
		}

		public Builder authorizationId(String authorizationId) {
			this.authorizationId = authorizationId;
			return this;
		}
		public Builder responseCode(ResponseCode responseCode) {
			this.responseCode = responseCode;
			return this;
		}
		public Builder error(ProcessingError error) {
			this.error = error;
			return this;
		}

		public PaymentResponse build() {
			return new PaymentResponse(this);
		}

	}

}

