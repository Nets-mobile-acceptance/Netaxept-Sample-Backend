package eu.nets.ms.pia.business.logic;

import eu.nets.ms.pia.business.domain.Order;
import eu.nets.ms.pia.business.domain.PaymentState;

public interface OrderService {
	
	/**
	 * Prepare order.
	 *
	 * Prepares an order
	 * @param order the order
	 * @return true, if successful
	 */
	boolean prepareOrder(Order order);
	
	/**
	 * Place order.
	 * This method should be called when the purchase has been authorized and the amount has been reserved
	 *
	 * @param transactionId the transaction id
	 * @return true, if successful
	 */
	boolean placeOrder(String transactionId);
	
	/**
	 * Finalize order.
	 * This method is call after the purchase has been captured. The amount has been paid.
	 *
	 * @param transactionId the transaction id
	 * @param endState the end state
	 * @return true, if successful
	 */
	boolean finalizeOrder(String transactionId, PaymentState endState);
}
