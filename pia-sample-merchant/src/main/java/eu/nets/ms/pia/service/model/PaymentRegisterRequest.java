package eu.nets.ms.pia.service.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.service.model.validation.ValidRegisterRequest;
import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Payment registration request")
@ValidRegisterRequest
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = PaymentRegisterRequest.Builder.class)
public class PaymentRegisterRequest {
	
	@NotNull(message = "CustomerId be provided")
	@ApiModelProperty(value = "CustomerId", required = true)
	private final String customerId;
	
	@NotNull(message = "Order number must be provided")
	@Pattern(regexp = "^([\\x21-\\x7E]{1,32})$", message="Illegal order number")
	@ApiModelProperty(value = "Order number", required = true)
	private final String orderNumber;
	
	@NotNull(message = "Amount cannot be null")
	@Valid
	@ApiModelProperty(value = "The amount to pay", required = true)
	private final Amount amount;
	
	@Valid
	@ApiModelProperty(value = "Payment method", required = false)
	private final Optional<Method>method;
	
	@ApiModelProperty(value = "Card ID to use for easyPay (Use of tokenized card)", required = false)
	private final Optional<String> cardId;
	
	@ApiModelProperty(value = "Payment data. Any data that may be needed for the payment method used.", required = false)
	private final Optional<String> paymentData;
	
	@ApiModelProperty(value = "Phone number to be used for alternative payment wallets", required = false)
	private final Optional<String> phoneNumber;
	
	@ApiModelProperty(value = "Client defined redirectUrl. Used for wallet payments", required = false)
	private final Optional<String> redirectUrl;
	
	@ApiModelProperty(value = "Store card for future use", required = false)
	private final boolean storeCard;
		
	/** This parameter is for facilitating testing.
	 *  The scenario is when you set up different Netaxept test accounts for different test purposes.
	 *  This parameter gives control as to which account to use. It is used as key for selecting correct set of Netaxept credentials.
	 *  If not present default parameters are used.
	 *  */
	@JsonIgnore
	private Optional<String> merchantId;
	
	
	@Valid
	@ApiModelProperty(value = "List of items in sale", required = false)
	private final Optional<List<LineItem>> items;

	private PaymentRegisterRequest(Builder builder) {
		this.customerId = builder.customerId;
		this.cardId = Optional.ofNullable(builder.cardId);
		this.storeCard = builder.storeCard;
		this.amount = builder.amount;
		this.orderNumber = builder.orderNumber;
		this.method = Optional.ofNullable(builder.method);
		this.paymentData = Optional.ofNullable(builder.paymentData);
		this.merchantId = Optional.ofNullable(builder.merchantId);
		this.phoneNumber = Optional.ofNullable(builder.phoneNumber);
		this.redirectUrl = Optional.ofNullable(builder.redirectUrl);
		if (builder.items != null) {
			this.items = Optional.of(Collections.unmodifiableList(builder.items));
		} else {
			this.items = Optional.empty();
		}
	}
	

	public String getCustomerId() {
		return customerId;
	}
	

	//These two methods are for facilitating testing
	public Optional<String> getMerchantId() {
		return merchantId;
	}
	
	public Optional<String> getPhoneNumber() {
		return phoneNumber;
	}


	public Optional<String> getRedirectUrl() {
		return redirectUrl;
	}

	public void setMerchantId(Optional<String> merchantId) {
		this.merchantId = merchantId;
	}
	// End of testing 

	public Amount getAmount() {
		return amount;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}


	public Optional<Method> getMethod() {
		return method;
	}


	public Optional<String> getCardId() {
		return cardId;
	}


	public boolean getStoreCard() {
		return storeCard;
	}


	public Optional<String> getPaymentData() {
		return paymentData;
	}
	
	public Optional<List<LineItem>> getItems() {
		return items;
	}


	public static Builder newBuilder() {
		return new Builder();
	}
	

	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}


	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
	public static class Builder {
		private String customerId;
		private String redirectUrl;
		private String phoneNumber;
		private String merchantId;
		private String cardId;
		private boolean storeCard = false;
		private String orderNumber;
		private Amount amount;
		private Method method;
		private String paymentData;
		private List<LineItem> items;
		
		public Builder customerId(String customerId){
			this.customerId = customerId;
			return this;
		}
		public Builder phoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
			return this;
		}
		public Builder redirectUrl(String redirectUrl){
			this.redirectUrl = redirectUrl;
			return this;
		}
		
		public Builder merchantId(String merchatId){
			this.merchantId = merchatId;
			return this;
		}
		
		public Builder orderNumber(String orderNumber){
			this.orderNumber = orderNumber;
			return this;
		}
		
		public Builder amount(Amount amount) {
			this.amount = amount;
			return this;
		}
		
		public Builder method(Method method) {
			this.method = method;
			return this;
		}
		
		public Builder cardId(String cardId){
			this.cardId = cardId;
			return this;
		}
		public Builder storeCard(boolean storeCard){
			this.storeCard = storeCard;
			return this;
		}
		public Builder paymentData(String paymentData){
			this.paymentData = paymentData;
			return this;
		}
		
		public Builder items(List<LineItem> items) {
			this.items = items;
			return this;
		}

		public Builder newItemList() {
			items = new ArrayList<>();
			return this;
		}
		
		public Builder addItem(LineItem item){
			items.add(item);
			return this;
		}

		public PaymentRegisterRequest build() {
			return new PaymentRegisterRequest(this);
		}
	}
}
