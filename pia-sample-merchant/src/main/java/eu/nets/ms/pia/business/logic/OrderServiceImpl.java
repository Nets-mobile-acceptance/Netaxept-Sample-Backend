package eu.nets.ms.pia.business.logic;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import eu.nets.ms.pia.business.domain.Order;
import eu.nets.ms.pia.business.domain.PaymentState;
import eu.nets.ms.pia.business.logic.persistence.PaymentPersistenceService;

/**
 * The Class OrderServiceImpl.
 * 
 * <pre>
 * This is a dummy implementation of an order service which does no more than persisting and retrieving an order. 
 * 
 * </pre>
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${pia.testing.forceOrderAnnul:false}")
	private boolean forceAnnul;
	
	@Inject
	PaymentPersistenceService persistenceService;
	
	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.OrderService#prepareOrder(eu.nets.ms.pia.business.domain.Order)
	 */
	@Override
	public boolean prepareOrder(Order order) {
		persistenceService.createOrder(order);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.OrderService#placeOrder(java.lang.String)
	 */
	@Override
	public boolean placeOrder(String transactionId) {
		if(forceAnnul){
			return false;
		}
		Order order = persistenceService.findOrderByTransactionId(transactionId);
		if( order != null ) {
			order.setPaymentState(PaymentState.AUTHORIZED);
			persistenceService.save(order);
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.OrderService#finalizeOrder(java.lang.String, eu.nets.ms.pia.business.domain.PaymentState)
	 */
	@Override
	public boolean finalizeOrder(String transactionId, PaymentState endState) {
		Order order = persistenceService.findOrderByTransactionId(transactionId);
		if( order != null ) {
			order.setPaymentState(endState);
			persistenceService.save(order);
			return true;
		}
		return false;
	}
	
	
}
