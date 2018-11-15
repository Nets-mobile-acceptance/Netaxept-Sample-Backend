package eu.nets.ms.pia.business.logic.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import eu.nets.ms.pia.business.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findOrdersForConsumer(@Param("consumerId") String consumerId);
	Order findOrderByTransactionId(@Param("transactionId") String transactionId);

}
