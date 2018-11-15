package eu.nets.ms.pia.service.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import eu.nets.ms.pia.utils.JsonUtil;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Payment response")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = ProcessingError.Builder.class)
public class ProcessingError {
    private static final String MESSAGE_KEY = "message";
	private final String explanationText;
    private final Map<String, String> params;
    
    private ProcessingError(Builder builder) {
        this.explanationText = builder.explanationText;
        if (builder.params != null) {
			this.params = Collections.unmodifiableMap(builder.params);
		} else {
			this.params = null;
		}
    }
    
    public ProcessingError addParam(String key, String value){
        params.put(key, value);
        return this;
    }

    public String getExplanationText() {
        return explanationText;
    }

    public Map<String, String> getParams() {
        return params;
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
		private String explanationText;
	    private Map<String, String> params;
		
	    public Builder explanationText(String explanationText){
	    	this.explanationText = explanationText;
	    	return this;
	    }
	    
	    public Builder params(Map<String, String> params){
	    	this.params = params;
	    	return this;
	    }
	    public Builder addMessage(String value){
	    	return addParam(MESSAGE_KEY, value);
	    }
	    
	    public Builder addParam(String key, String value){
	    	if(this.params == null){
	    		params = new HashMap<>();
	    	}
	    	params.put(key, value);
	    	return this;
	    }
		
		public ProcessingError build() {
			return new ProcessingError(this);
		}

	}

}