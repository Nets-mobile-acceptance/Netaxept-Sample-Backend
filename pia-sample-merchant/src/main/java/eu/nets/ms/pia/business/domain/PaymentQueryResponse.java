package eu.nets.ms.pia.business.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import eu.nets.ms.pia.utils.JsonUtil;

public class PaymentQueryResponse {
	
	@NotNull(message = "Transaction Id must be provided")
	@Size(min=1, max=32, message = "TransactionId must be between 1-32 characters long")
	private final String transactionId;

	@NotNull(message = "Response code must be provided")
	@Pattern(regexp = "^([a-zA-Z0-9]{1,})$", message="Response code must be alfa numeric")
	private final String responseCode;

	private final CardToken token;
	
	private PaymentQueryResponse(Builder builder) {
		this.transactionId = builder.transactionId;
		this.token = builder.token;
		this.responseCode = builder.responseCode;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	
	
	public String getResponseCode() {
		return responseCode;
	}

	public CardToken getToken() {
		return token;
	}

	public static Builder newBuilder(){
		return new Builder();
	}
	
	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}
	
	public static class Builder {
		private String transactionId;
		private CardToken token;
		private String responseCode;

		public Builder transactionId(String transactionId) {
			this.transactionId = transactionId;
			return this;
		}

		public Builder withToken(CardToken token) {
			this.token = token;
			return this;
		}
		
		public Builder responseCode(String responseCode) {
			this.responseCode = responseCode;
			return this;
		}
		
		public PaymentQueryResponse build() {
			return new PaymentQueryResponse(this);
		}

	}

}
