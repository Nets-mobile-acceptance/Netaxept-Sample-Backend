package eu.nets.ms.pia.service.model;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Represents an amount")
@JsonIgnoreProperties(ignoreUnknown = true) 
@JsonDeserialize(builder = Amount.Builder.class) 
public class Amount implements Serializable {
    private static final long serialVersionUID = 2450357811553130720L;

    @NotNull(message = "Curency code cannot be null")
    @Pattern(regexp = "^([A-Z]{3})$", message="currency must be ISO-4217 format")
    @ApiModelProperty(value = "ISO-4217 Currency code", required = true)
    private final String currencyCode;

    @NotNull(message = "Vat amount cannot be null")
    @DecimalMin(value = "0", message = "Vat amount must be >= 0")
    @DecimalMax(value = "999999999999", message="Vat amount must be <= 999999999999")
    @ApiModelProperty(value = "Vat Amount [Hundredth of denomination]", required = true)
    private final Long vatAmount;

    @NotNull(message = "Total amount cannot be null")
    @DecimalMin(value = "0", message = "Total amount must be >= 0")
    @DecimalMax(value = "999999999999", message="Total amount must be <= 999999999999")
    @ApiModelProperty(value = "Amount includeing vat. [Hundredth of denomination]", required = true)
    private final Long totalAmount;


    private Amount(Builder builder) {
        this.currencyCode = builder.currencyCode;
        this.vatAmount = builder.vatAmount;
        this.totalAmount = builder.totalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Long getVatAmount() {
        return vatAmount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }
    
    @Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}
    
    public static Builder newBuilder(){
    	return new Builder();
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((vatAmount == null) ? 0 : vatAmount.hashCode());
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
		Amount other = (Amount) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null){
				return false;
			}
		} else if (!currencyCode.equals(other.currencyCode)){
			return false;
		}
		if (totalAmount == null) {
			if (other.totalAmount != null){
				return false;
			}
		} else if (!totalAmount.equals(other.totalAmount)){
			return false;
		}
		if (vatAmount == null) {
			if (other.vatAmount != null){
				return false;
			}
		} else if (!vatAmount.equals(other.vatAmount)){
			return false;
		}
		return true;
	}



	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder {
    	private String currencyCode=null;
    	private Long vatAmount=null;
    	private Long totalAmount=null;
    	
    	public Builder currencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
			return this;
		}

		public Builder vatAmount(Long vatAmount) {
			this.vatAmount = vatAmount;
			return this;
		}

		public Builder totalAmount(Long totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}

		public Amount build() {
			return new Amount(this);
		}

	}
    
    
}
