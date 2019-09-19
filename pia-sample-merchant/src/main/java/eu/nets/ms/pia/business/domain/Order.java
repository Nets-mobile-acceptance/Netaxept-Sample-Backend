package eu.nets.ms.pia.business.domain;

import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDERS")
@NamedQueries({
    @NamedQuery(name = "Order.findOrdersForConsumer", query = "SELECT c FROM Order c WHERE c.consumer.consumerId= :consumerId ORDER BY c.orderId"),    
    @NamedQuery(name = "Order.findOrderByTransactionId", query = "SELECT o FROM Order o WHERE o.psptransactionid= :transactionId"),
})

public class Order {
	public static final String TIMEZONE_ID = "UTC";
	
	@Id
    @GeneratedValue(generator = "orders.seq.name")
    @SequenceGenerator(name = "orders.seq.name", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @Column(name = "ORDER_ID_PK", unique = true, nullable = false)
    private Long orderId;
	
	@Column(name = "PAYMENT_STATE")
	private PaymentState paymentState;
	
	@Embedded
    @Valid
    @NotNull
    private Amount amount;

    @Valid
    @NotNull
    @Column(name = "PSP_TRANSACTION_ID", nullable = false)
    private String psptransactionid;
    
    @Column(name = "METHOD", nullable = true)
    private String method;
	
	@Column(name = "TIMESTAMP_CREATED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar timeStamp;
	
	@ManyToOne
    @JoinColumn(name = "CONSUMER_ID_FK")
    private Consumer consumer;
	
	public void setTimeStampNow() {
        this.timeStamp = Calendar.getInstance(TimeZone.getTimeZone(TIMEZONE_ID));
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public PaymentState getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(PaymentState paymentState) {
		this.paymentState = paymentState;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Calendar getTimeStamp() {
		return timeStamp;
	}

	public String getPspTransactionid() {
		return psptransactionid;
	}

	public void setPspTransactionid(String pspTransactionid) {
		this.psptransactionid = pspTransactionid;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}
