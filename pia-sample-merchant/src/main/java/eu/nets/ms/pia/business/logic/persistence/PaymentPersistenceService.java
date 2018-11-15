package eu.nets.ms.pia.business.logic.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.nets.ms.pia.business.domain.CardToken;
import eu.nets.ms.pia.business.domain.Consumer;
import eu.nets.ms.pia.business.domain.Order;

@Service("PaymentPersistenceService")
@Transactional(readOnly = true)
public class PaymentPersistenceService {

	@Resource
	ConsumerRepository consumerRepo;

	@Resource
	OrderRepository orderRepo;
	
	@Resource
	CardTokenRepository tokenRepo;

	@Transactional
	public Order createOrder(Order order) {
		order.setTimeStampNow();

		if (order.getConsumer() != null) {
			save(order.getConsumer());
		}
		save(order);
		return order;
	}

	public Consumer findConsumer(String consumerId) {
		return consumerRepo.findOne(consumerId);
	}
	public Order findOrder(Long orderId) {
		return orderRepo.findOne(orderId);
	}

	public Order findOrderByTransactionId(String orderId) {
		return orderRepo.findOrderByTransactionId(orderId);
	}
	
	public List<Order> findOrdersForConsumer(String consumerId) {
		return orderRepo.findOrdersForConsumer(consumerId);
	}
	
	@Transactional
	public void deleteToken(String consumerId, String tokenId) {
		if(tokenId == null || consumerId == null){
			return;
		}
		Consumer consumer = findConsumer(consumerId);
		if(consumer != null){
			for(CardToken token : consumer.getCardTokens()){
				consumer.getCardTokens().remove(token);
				tokenRepo.delete(token);
				consumerRepo.save(consumer);
				return;
			}
		}
	}

	@Transactional
	public void addToken(String consumerId, String tokenName, String cardName) {
		
		if(tokenName == null || consumerId == null){
			return;
		}
		Consumer consumer = findConsumer(consumerId);
		if(consumer != null){
			for(CardToken token : consumer.getCardTokens()){
				if( token.getName().equals(tokenName) ) {
					// token already added, no need to add
					return;
				}
				
				CardToken addToken = new CardToken();
				addToken.setValue(tokenName);
				addToken.setName(cardName);
				addToken.setConsumer(consumer);
				
				tokenRepo.save(addToken);
				consumer.addCardToken(addToken);
				consumerRepo.save(consumer);
				return;
			}
		}
	}
	
	@Transactional
	public Consumer save(Consumer consumer) {
		return consumerRepo.save(consumer);
	}

	@Transactional
	public Order save(Order order) {
		return orderRepo.save(order);
	}

}
