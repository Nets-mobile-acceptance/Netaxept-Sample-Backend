package eu.nets.ms.pia.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Payment method")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Method.Builder.class)
public class Method {
	@ApiModelProperty(value = "Payment ID", required = true)
	private final String id;
	@ApiModelProperty(value = "Payment display name", required = false)
	private final String displayName;
	@ApiModelProperty(value = "Fee for this payment method", required = false)
	private final long fee;
	
	private Method(Builder builder){
		this(MethodEnum.create(builder.id));
	}
	
	public Method(MethodEnum methodEnum){
		this.id = methodEnum.getId();
		this.displayName = methodEnum.getDisplayName();
		this.fee = methodEnum.getFee();
	}

	public String getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public long getFee() {
		return fee;
	}
	
	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Method other = (Method) obj;
		if (id == null) {
			if (other.id != null){
				return false;
			}
		} else if (!id.equals(other.id)){
			return false;
		}
		return true;
	}
	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private  String id;
			
		public Builder id(String id){
			this.id = id;
			return this;
		}
		public Method build(){
			return new Method(this);
		}
	}
	
}
