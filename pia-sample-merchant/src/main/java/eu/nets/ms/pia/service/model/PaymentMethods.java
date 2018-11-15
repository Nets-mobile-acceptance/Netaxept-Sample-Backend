package eu.nets.ms.pia.service.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Supported payment methods")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethods {
	
	@ApiModelProperty(value = "List of supported payment methods", required = false)
	private final List<Method> methods;
	
	@ApiModelProperty(value = "List of available card tokens", required = false)
	private final List<CardTokenDto> tokens;
	
	@ApiModelProperty(value = "Require card verification when using card token payment", required = false)
	private final boolean requireCardVerification;
	
	public PaymentMethods(boolean requireCvv){
		requireCardVerification = requireCvv;
		tokens= new ArrayList<>();
		methods = new ArrayList<>();
		for(MethodEnum method: EnumSet.allOf( MethodEnum.class )){
			//Conditional excludes
			if(!MethodEnum.EASY_PAY.equals(method)){
				methods.add(new Method(method));
			}
		}
	}
	public PaymentMethods(List<CardTokenDto> tokens, boolean requireCvv){
		this(requireCvv);
		this.methods.add(new Method(MethodEnum.EASY_PAY));
		this.tokens.addAll(tokens);
		
	}
	
	public List<Method> getMethods() {
		return methods;
	}
	
	public List<CardTokenDto> getTokens() {
		return tokens;
	}
	
	public boolean isCardVerificationRequired() {
		return requireCardVerification;
	}
	@Override
	public String toString() {
		return JsonUtil.writeObjAsString(this);
	}
}
