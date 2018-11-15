package eu.nets.ms.pia.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Payment registration response")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = PaymentRegisterResponse.Builder.class)
public class PaymentRegisterResponse {
	
	@NotNull(message = "Transaction Id must be provided")
	@Size(min=1, max=32, message = "TransactionId must be between 1-32 characters long")
	@ApiModelProperty(value = "TransactionId", required = true)
	private final String transactionId;
	
	@NotNull(message = "Redirect URL OK must be provided")
	@ApiModelProperty(value = "Redirect URL for sucessful payemnt", required = true)
	private final String redirectOK;
	
	@NotNull(message = "Redirect URL Cancel must be provided")
	@ApiModelProperty(value = "Redirect URL for cancelled payemnt", required = true)
	private final String redirectCancel;
		
	private PaymentRegisterResponse(Builder builder) {
		this.transactionId = builder.transactionId;
		this.redirectOK = builder.redirectOK;
		this.redirectCancel = builder.redirectCancel;
		
	}
	
	
	public String getTransactionId() {
		return transactionId;
	}
	

	public String getRedirectOK() {
		return redirectOK;
	}


	public String getRedirectCancel() {
		return redirectCancel;
	}


	public static Builder newBuilder(){
		return new Builder();
	}
	
	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}
	
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private String transactionId;
		private String redirectOK;
		private String redirectCancel;
		
		public Builder transactionId(String transactionId) {
			this.transactionId = transactionId;
			return this;
		}
		public Builder redirectOK(String redirectOK) {
			this.redirectOK = redirectOK;
			return this;
		}
		public Builder redirectCancel(String redirectCancel) {
			this.redirectCancel = redirectCancel;
			return this;
		}


		public PaymentRegisterResponse build() {
			return new PaymentRegisterResponse(this);
		}

	}

}
