package eu.nets.ms.pia.service.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Processing option")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = ProcessingOption.Builder.class)
public class ProcessingOption {
	@ApiModelProperty(value = "Operation", required = true)
	private final Operation operation;
	
	private ProcessingOption(Builder builder){
		operation = builder.operation;
	}
	
	public Operation getOperation() {
		return operation;
	}


	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private  Operation operation;
			
		public Builder operation(Operation operation){
			this.operation = operation;
			return this;
		}
		public ProcessingOption build(){
			return new ProcessingOption(this);
		}
	}
	
}
