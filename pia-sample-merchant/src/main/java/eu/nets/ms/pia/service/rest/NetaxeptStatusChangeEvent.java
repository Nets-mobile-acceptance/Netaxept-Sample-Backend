package eu.nets.ms.pia.service.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Status change event")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = NetaxeptStatusChangeEvent.Builder.class)
public class NetaxeptStatusChangeEvent {
	@ApiModelProperty(value = "TransactionId", required = true)
	private final String transactionId;
	
	private NetaxeptStatusChangeEvent(Builder builder){
		transactionId = builder.TransactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private  String TransactionId;
		
		@JsonProperty("TransactionId")
		public Builder transactionId(String transactionId){
			this.TransactionId = transactionId;
			return this;
		}
		public NetaxeptStatusChangeEvent build(){
			return new NetaxeptStatusChangeEvent(this);
		}
	}
	
}