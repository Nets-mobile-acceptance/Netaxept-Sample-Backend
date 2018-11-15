package eu.nets.ms.pia.business.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * The Class Amount.
 */
@Embeddable
@Access(AccessType.FIELD)
public class Amount implements Serializable {
    private static final long serialVersionUID = 2450357811553130720L;

    @NotNull(message = "Curency code cannot be null")
    @Pattern(regexp = "^([A-Z]{3})$", message="currency must be format: XXX")
    @Column(name = "CURRENCY")
    private String currencyCode;

    @NotNull(message = "Vat amount cannot be null")
    @DecimalMin(value = "0", message = "Vat amount must be >= 0")
    @DecimalMax(value = "999999999999", message="Vat amount must be <= 999999999999")
    @Column(name = "VAT_AMOUNT")
    private Long vatAmount;

    @NotNull(message = "Total amount cannot be null")
    @DecimalMin(value = "0", message = "Total amount must be >= 0")
    @DecimalMax(value = "999999999999", message="Total amount must be <= 999999999999")
    @Column(name = "TOTAL_AMOUNT")
    private Long totalAmount;

    public Amount() {
        super();
    }

    public Amount(String currencyCode, Long vatAmount, Long totalAmount) {
        this.currencyCode = currencyCode;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
    	this.currencyCode = currencyCode.toUpperCase();
    }

    public Long getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Long vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Amount other = (Amount) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null){
				return false;
			}
		} else if (!currencyCode.equals(other.currencyCode)){
			return false;
		}
		if (totalAmount == null) {
			if (other.totalAmount != null){
				return false;
			}
		} else if (!totalAmount.equals(other.totalAmount)){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Amount [currencyCode=" + currencyCode + ", vatAmount=" + vatAmount + ", totalAmount=" + totalAmount
				+ "]";
	}

	
    
    
}
