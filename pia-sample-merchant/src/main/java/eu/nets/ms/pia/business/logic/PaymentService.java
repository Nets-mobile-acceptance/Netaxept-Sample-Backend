package eu.nets.ms.pia.business.logic;

import eu.nets.ms.pia.exception.BusinessServiceException;
import eu.nets.ms.pia.service.model.PaymentMethods;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;

public interface PaymentService {
	
	/**
	 * <pre>
	 * Register.
	 * Two main flows can be started by a call to register.
	 * 
	 * 1) Register card for future use. 
	 *    This is defined by the amount being zero.
	 *    
	 * 2) Payment
	 *    For payments three subflows are defined
	 *    a) Payment via card. Here you can also select to store this card for future use, 
	 *       The store option is available for non-anonymous consumers.
	 *    
	 *    b) Payment via a previously stored card.
	 *       This requires for the consumer to be identified so that the a card token for that consumer
	 *       can be retrieved.
	 *       
	 *    c) Same as b above with the difference that no security code or 3DS will be required.
	 *       This is the fastest payment option with the least amount of consumer interaction.
	 *       The flagging of this option is defined on a per consumer basis and is not something
	 *       the consumer can decide at register time. The enabling of this option should be done
	 *       based on on a risk assessment.  
	 * 
	 * 3) Apple Pay
	 *	Pre-requisite:
	 *		a)	You have integrated towards Apple Pay for web or app (https://developer.apple.com/library/content/ApplePay_Guide/)
	 * 
	 *		b)	You have integrated towards Netaxept via API (https://shop.nets.eu/partners)
	 *
	 *		c)	You have an agreement with an acquirer to accept card payments and use the Apple Pay service
	 *
	 *  For Apple Pay – Netaxept works as a payment processor. The card data (token) is provided to the merchant
	 *  from Apple, and then passed by the Merchant to Netaxept. This enables server-to-server communication
	 *  towards Netaxept – no redirect of consumer to Netaxept is required, providing a seamless experience on
	 *  for example mobile devices.
	 * 
	 * 	Apple Pay is available in both our production (https://epayment.nets.eu) and test environment
	 * 	(https://test.epayment.nets.eu). Apple Pay is not available in any of our terminals – which is why you need
	 * 	to create the payment request towards Apple and add the Apple Pay-button on your own site or mobile app.
	 * 
	 * 	Register Call:
	 * 	The paymentMethodActionList-parameter should specify ApplePay
	 * 		The parameter service type should be to 'M'
	 *		The parameter PaymentData should be added and contain the encrypted Payment Data from Apple Pay in Json, 
	 *		{"paymentData":{"version":"EC_v1","data":"4………….}
	 * 
	 * 4) Paypal
	 *	a) 	You need to enter your PayPal credentials in the agreements tab under the Options menu. 
	 *	You can also set up an account if needed from the same place, through a guide which will help you set up a new account 
	 *	in a few minutes and accepting payments almost instantly. Also note that you need to set up PayPal with the correct currency or currencies.
	 *
	 *	b)	Make sure to complete the register API call with the necessary customerCountry parameter. This parameter should follow the Alpha 2 part of
	 *	the ISO 3166-1 standard. For instance, the Nets countries are NO, SE, FI and DK.
	 *
	 *	c)	If you set Paypal as value in the REGISTER's payment method list and set service type to 'B', the customer will automatically be forwarded to Paypal's own payment page. 
	 *	If payment method list has no value, Paypal will be listed among other payment alternatives in the Netaxept terminal webpage.
	 *
	 *	d)	After the end user returns from the PayPal page, you can use financial process calls (AUTH, ANULL, CAPTURE, SALE, CREDIT) as 
	 *	you would for a regular card-based transaction.
	 *       
	 * Important:
	 * The redirect URLs.
	 * They are used by the mobile SDK during the terminal phase to identify the success of that.
	 * If the terminal gets redirected to a different URL than the two provided by this response, this
	 * indicated a 3DS redirection to the card issuer.      
	 * </pre>      
	 *
	 * @param request the request
	 * @param remoteHost the remote host
	 * @return the payment register response
	 * @throws BusinessServiceException the business service exception
	 */
	PaymentRegisterResponse register(PaymentRegisterRequest request, String remoteHost) throws BusinessServiceException;
	
	/**
	 * Process.
	 * <pre>
	 * Issues an Authorization request toward the payment service provider.
	 * If this succeeds:
	 *      1) Store the card token, if that option was available and selected during Init.
	 *      2) Place the Order to the mocked order service.
	 *      
	 * If the order is successfully processed:
	 *      1) Capture the reserved amount by calling the payment service provider capture
	 *      
	 * If the order processing fails:
	 *      2) Reverse the authorization to free the reserved amount
	 * 
	 * To be noticed, Authorization ID is NOT required for Paypal, but required for card payment.
	 * 
	 * </pre>
	 * @param paymentId the payment id
	 * @param merchantId Id of the Netaxept account to use if this demo application is connected to several test accounts
	 * @return the payment process response
	 * @throws BusinessServiceException the business service exception
	 */
	PaymentProcessResponse process(String paymentId, String merchantId) throws BusinessServiceException;
	
	/**
	 * Delete payment.
	 * <pre>
	 * Nothing implemented yet
	 * </pre>
	 * @param paymentId the payment id
	 * @param merchantId Id of the Netaxept account to use if this demo application is connected to several test accounts
	 * @throws BusinessServiceException the business service exception
	 */
	void deletePayment(String paymentId, String merchantId) throws BusinessServiceException;
	
	/**
	 * Verify.
	 * <pre>
	 * This method will be used in the case where a consumer wishes to register a card for future purchases
	 * without performing a purchase.
	 * 
	 * During initialization of a transaction using "register", the amount will be set to zero.
	 * The purpose of this method is to verify that a card that has been tokenized is actually 
	 * Usable.
	 * 
	 * An authorization request with VERIFY will be issued to the payment service provider.
	 * 
	 * Upon successful verification the card  token is stored to the consumer thereby
	 * enabling future payments using this token.
	 * </pre>
	 * @param paymentId the payment id
	 * @param merchantId Id of the Netaxept account to use if this demo application is connected to several test accounts
	 * @return the payment process response
	 * @throws BusinessServiceException the business service exception
	 */
	PaymentProcessResponse verify(String paymentId, String merchantId) throws BusinessServiceException;
	
	/**
	 * Gets the payment methods.
	 * <pre>
	 * This method lists the supported payment methods. This is a subset of the methods supported by the payment service provider
	 * If the payment is initiated by a registered consumer, this list can also contain payments via 
	 * a previously stored card token. 
	 * </pre>
	 * @param consumerId the consumer id
	 * @return the payment methods
	 * @throws BusinessServiceException the business service exception
	 */
	PaymentMethods getPaymentMethods(String consumerId) throws BusinessServiceException;
	
	
}