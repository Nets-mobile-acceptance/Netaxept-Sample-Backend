package eu.nets.ms.pia.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 
@JsonDeserialize(builder = CardTokenDto.Builder.class)
public class CardTokenDto {
	@ApiModelProperty(value = "Token ID", required = true)
	@NotNull
	@Size(min=1, message="Token can not be empty")
	private final String tokenId;
	
	@ApiModelProperty(value = "Issuer", required = false)
	private final String issuer;
	
	@ApiModelProperty(value = "Expiry date (MM/YY)", required = false)
	private final String expiryDate;
	
	
	private CardTokenDto(Builder builder){
		this.tokenId=builder.tokenId;
		this.issuer=builder.issuer;
		this.expiryDate=builder.expiryDate;
	}
		
	public String getTokenId() {
		return tokenId;
	}

	public String getIssuer() {
		return issuer;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}
	
	public static Builder newBuilder(){
		return new Builder();
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder {
    	private String tokenId=null;
    	private String issuer=null;
    	private String expiryDate=null;
    	
    	public Builder tokenId(String tokenId) {
			this.tokenId = tokenId;
			return this;
		}

		public Builder issuer(String issuer) {
			this.issuer = issuer;
			return this;
		}

		public Builder expiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
			return this;
		}

		public CardTokenDto build() {
			return new CardTokenDto(this);
		}

	}

}

