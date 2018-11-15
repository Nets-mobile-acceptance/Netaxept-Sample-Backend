package eu.nets.ms.pia.business.logic.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.nets.ms.pia.business.domain.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, String> {

}
