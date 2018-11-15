package eu.nets.ms.pia.service.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 
@JsonDeserialize(builder = LineItem.Builder.class)
public class LineItem {
	
	@ApiModelProperty(value = "Article number of item", required = true)
	@NotNull
	@Size(min=1, message="Article number cannot be empty")
	private final String articleNumber;
	
	@ApiModelProperty(value = "Price of article", required = true)
	@Valid
	private final Amount amount;
	
	@ApiModelProperty(value = "Number of articles", required = true)
	@NotNull
	@Min(1)
	private final Integer quantity;
	
	private LineItem(Builder builder){
		this.articleNumber=builder.articleNumber;
		this.amount=builder.amount;
		this.quantity=builder.quantity;
	}
	
	public String getArticleNumber() {
		return articleNumber;
	}

	public Amount getAmount() {
		return amount;
	}

	public Integer getQuantity() {
		return quantity;
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
    	private String articleNumber=null;
    	private Amount amount=null;
    	private Integer quantity=null;
    	
    	public Builder articleNumber(String articleNumber) {
			this.articleNumber = articleNumber;
			return this;
		}

		public Builder amount(Amount amount) {
			this.amount = amount;
			return this;
		}

		public Builder quantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public LineItem build() {
			return new LineItem(this);
		}

	}

}
