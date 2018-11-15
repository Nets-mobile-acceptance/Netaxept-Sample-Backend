package eu.nets.ms.pia.business.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CARDTOKENS")
public class CardToken {

	@Id
	@GeneratedValue(generator = "tokens.seq.name")
	@SequenceGenerator(name = "tokens.seq.name", sequenceName = "TOKEN_SEQ", allocationSize = 1)
	@Column(name = "TOKEN_ID_PK", unique = true, nullable = false)
	private Long tokenId;
	
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "EXPIRY_DATE")
	private String expiryDate;
	
	@Column(name = "ISSUER")
	private String issuer;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSUMER_ID_FK", nullable = false)
	private Consumer consumer;


	public Long getTokenId() {
		return tokenId;
	}


	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public Consumer getConsumer() {
		return consumer;
	}


	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getIssuer() {
		return issuer;
	}


	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

}
