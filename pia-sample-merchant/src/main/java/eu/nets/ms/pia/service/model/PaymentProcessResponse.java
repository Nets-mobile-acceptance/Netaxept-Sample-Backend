package eu.nets.ms.pia.service.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.exception.SystemException;
import eu.nets.ms.pia.service.model.validation.ValidProcessResponse;
import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ValidProcessResponse(message = "AuthID must be provided for Authorization responses")
@ApiModel(description = "Payment process response")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = PaymentProcessResponse.Builder.class)
public class PaymentProcessResponse {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProcessResponse.class);
	
	@NotNull(message = "Transaction Id must be provided")
	@Size(min=1, max=32, message = "TransactionId must be between 1-32 characters long")
	@ApiModelProperty(value = "Transaction id", required = true)
	private final String transactionId;
	
	@NotNull(message = "Response code must be provided")
	@Pattern(regexp = "^([a-zA-Z0-9]{1,})$", message="Response code must be alfa numeric")
	@ApiModelProperty(value = "Response code", required = true)
	private final String responseCode;
	
	@Pattern(regexp = "^([a-zA-Z0-9]{1,})$", message="Response source must be alfa numeric")
	@ApiModelProperty(value = "Response source", required = false)
	private final String responseSource;
	
	@ApiModelProperty(value = "Response text", required = false)
	private final String responseText;
	
	@ApiModelProperty(value = "Authorization ID", notes= "Not required for Paypal, but required for card payment", required = false)
	private final String authorizationId;
	
	@NotNull(message = "Execution timestamp must be provided")
	@ApiModelProperty(value = "Execution timestamp", required = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime executionTimestamp;
	
	@NotNull(message = "Operation must be provided")
	@JsonIgnore
	private final Operation operation;
	
	@JsonIgnore
	private final String batch;
	
	private PaymentProcessResponse(Builder builder) {
		this.operation = builder.operation;
		this.transactionId = builder.transactionId;
		this.responseCode = builder.responseCode;
		this.responseSource = builder.responseSource;
		this.responseText = builder.responseText;
		this.authorizationId = builder.authorizationId;
		this.executionTimestamp = builder.executionTimestamp;
		this.batch = builder.batch;
	}
	
	public String getResponseCode() {
		return responseCode;
	}


	public String getResponseSource() {
		return responseSource;
	}


	public String getResponseText() {
		return responseText;
	}


	public String getAuthorizationId() {
		return authorizationId;
	}


	public LocalDateTime getExecutionTimestamp() {
		return executionTimestamp;
	}


	public String getBatch() {
		return batch;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	

	public Operation getOperation() {
		return operation;
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
		private String transactionId;
		private String responseCode;
		private String responseSource;
		private String responseText;
		private String authorizationId;
		private Operation operation;
		private LocalDateTime executionTimestamp;
		private String batch;
		
		public Builder operation(Operation operation){
			this.operation = operation;
			return this;
		}
		public Builder transactionId(String transactionId){
			this.transactionId = transactionId;
			return this;
		}
		public Builder responseCode(String responseCode){
			this.responseCode = responseCode;
			return this;
		}
		public Builder responseSource(String responseSource){
			this.responseSource = responseSource;
			return this;
		}
		public Builder responseText(String responseText){
			this.responseText = responseText;
			return this;
		}
		public Builder authorizationId(String authorizationId){
			this.authorizationId = authorizationId;
			return this;
		}
		public Builder executionTimestamp(LocalDateTime executionTimestamp){
			this.executionTimestamp = executionTimestamp;
			return this;
		}
		public Builder executionTimestamp(XMLGregorianCalendar calendar){
			if (calendar == null) {
			      return this;
			    }
			int year = calendar.getYear() > 0 ? calendar.getYear() : 0;
			int hour = calendar.getHour() > 0 ? calendar.getHour() : 0;
			int minute = calendar.getMinute() > 0 ? calendar.getMinute() : 0;
			int second = calendar.getSecond() > 0 ? calendar.getSecond() : 0;
			int millisecond = calendar.getMillisecond() > 0 ? calendar.getMillisecond() : 0;
			this.executionTimestamp = LocalDateTime.of(year, calendar.getMonth(), calendar.getDay(), hour, minute, second, millisecond);
			return this;
		}
				
		public Builder batch(String batch){
				this.batch = batch;
			return this;
		}
		
		public PaymentProcessResponse build() {
			PaymentProcessResponse dto = new PaymentProcessResponse(this);
            Set<ConstraintViolation<PaymentProcessResponse>> violations = validator.validate(dto);

            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations.iterator().next().getMessage(),
                    new HashSet<ConstraintViolation<?>>(violations));
            }

            return dto;
		}
		
	}
}
