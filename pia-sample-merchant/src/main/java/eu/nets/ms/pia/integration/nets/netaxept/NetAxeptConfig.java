package eu.nets.ms.pia.integration.nets.netaxept;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import eu.nets.ms.pia.config.SecretsStore;

@Service
public class NetAxeptConfig {
	private static final String NETAXEPT_TOKEN_KEY = "netaxeptToken";
	private static final String NETAXEPT_PASSWORD_KEY = "netaxeptPassword";
	private static final String NETAXEPT_USER_KEY = "netaxeptUser";
	private static final String NETAXEPT_CALLBACK_SECRET_KEY = "jwtSecret";
	private static final Logger LOGGER = LoggerFactory.getLogger(NetAxeptConfig.class);
	private static final String SECRETS_FILE_NAME = "/secrets.properties";
		
	@Value("${netaxept.connection.timeout:2000}")
	private int timeout=10000;
	
	@Value("${netaxept.force3Dsecure:false}")
    private boolean force3Dsecure;
	
	@Value("${netaxept.subsequent3Dsecure:false}")
    private boolean subsequent3Dsecure;
	
	@Value("${netaxept.redirectUrl:http://localhost/redirect.php}")
    private String redirectUrl;
    
    @Value("${netaxept.cancelUrl:http://localhost/cancel.php}")
    private String cancelUrl;
    
    @Value("${netaxept.terminalUrl:http://localhost/terminal.php}")
    private String terminalUrl;
    
    @Value("${netaxept.terminalPaymentMethods}")
    private String terminalPaymentMethods;
    
    @Value("${secrets.path}")
    private String secretsPath;
    
    //Properties take from secrets file
    SecretsStore secrets;
    
    @PostConstruct
	public void init(){
		secrets = new SecretsStore(secretsPath+SECRETS_FILE_NAME);
		LOGGER.info("Config:{}", this.toString());
	}

	public int getTimeout() {
		return timeout;
	}

	public boolean isForce3Dsecure() {
		return force3Dsecure;
	}
	
	public boolean isSubsequent3Dsecure() {
		return subsequent3Dsecure;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	public void setRedirectUrl() {
		setRedirectUrl(null);
	}
	
	public void setRedirectUrl(String redirectUrl) {
		if (redirectUrl != null) {
			this.redirectUrl = redirectUrl;			
		} else {
			this.redirectUrl = "http://localhost/redirect.php";
		}
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public String getTerminalUrl() {
		return terminalUrl;
	}

	public String getTerminalPaymentMethods() {
		return terminalPaymentMethods;
	}

	public String getUserName(){
    	return getUserName(null);
    }
	
	public String getUserName(String section){
		return getSecretOrDefault(section, NETAXEPT_USER_KEY);
	}
	
	public String getPassword(){
    	return getPassword(null);
    }
	public String getPassword(String section){
		return getSecretOrDefault(section, NETAXEPT_PASSWORD_KEY);
	}
	public String getToken(){
    	return getToken(null);
    }
	public String getToken(String section){
		return getSecretOrDefault(section, NETAXEPT_TOKEN_KEY);
	}

	public String getJwtSecret() {
		return getSecretOrDefault(null, NETAXEPT_CALLBACK_SECRET_KEY);
	}
		
	private String getSecretOrDefault(String section, String key) {
		if(section == null){
			return secrets.getSecret(key);
		}else{
			String value = secrets.getSecret(section+"."+key);
			if(value == null){
				return secrets.getSecret(key);
			}
			return value;
		}
	}
	
	@Override
	public String toString() {
		return "NetAxeptConfig [timeout=" + timeout + ", force3Dsecure=" + force3Dsecure + ", redirectUrl="
				+ redirectUrl + ", cancelUrl=" + cancelUrl + ", terminalUrl=" + terminalUrl
				+ ", terminalPaymentMethods=" + terminalPaymentMethods + ", secretsPath=" + secretsPath + "]";
	}
	
	
}
