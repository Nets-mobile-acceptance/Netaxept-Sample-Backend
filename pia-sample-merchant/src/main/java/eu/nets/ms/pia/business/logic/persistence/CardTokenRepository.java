package eu.nets.ms.pia.business.logic.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.nets.ms.pia.business.domain.CardToken;

public interface CardTokenRepository extends JpaRepository<CardToken, String> {

}
