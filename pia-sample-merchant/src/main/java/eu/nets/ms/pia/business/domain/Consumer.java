package eu.nets.ms.pia.business.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CONSUMERS")
public class Consumer {
	

	@Id
    @NotNull
    @Column(name = "CONSUMER_ID_PK")
    private String consumerId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CARD_VERIFICATION_SUBSEQUENT")
    private Boolean requireCardVerificationSubsequent=true;
    
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "consumer")
    private Set<CardToken> cardTokens = new HashSet<>();

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addCardToken(CardToken token) {
		token.setConsumer(this);
		cardTokens.add(token);
	}

	public Set<CardToken> getCardTokens() {
		return cardTokens;
	}

	public void setCardTokens(Set<CardToken> cardTokens) {
		this.cardTokens = cardTokens;
	}

	public boolean isRequiredCardVerificationSubsequent() {
		return requireCardVerificationSubsequent;
	}

	public void setRequireCardVerificationSubsequent(boolean requireCardVerificationSubsequent) {
		this.requireCardVerificationSubsequent = requireCardVerificationSubsequent;
	}
	
	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", name=" + name + ", requireCardVerificationSubsequent="
				+ requireCardVerificationSubsequent + ", numOfcardTokens=" + cardTokens.size() + "]";
	}

}
