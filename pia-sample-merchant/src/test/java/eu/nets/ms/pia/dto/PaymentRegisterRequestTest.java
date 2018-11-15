package eu.nets.ms.pia.dto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import eu.nets.ms.pia.business.logic.PaymentServiceImpl;
import eu.nets.ms.pia.service.model.Amount;
import eu.nets.ms.pia.service.model.LineItem;
import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.MethodEnum;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.utils.JsonUtil;


public class PaymentRegisterRequestTest {

	private static final String CURRENCY = "SEK";

	private static final String ART_NO_SWEATER = "ART_NO_SWEATER";
	private static final String ART_NO_SHORTS = "ART_NO_SHORTS";
	private static Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	private LineItem sweater = LineItem.newBuilder()
			.articleNumber(ART_NO_SWEATER)
			.quantity(2)
			.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(20000L).vatAmount(5000L).build())
			.build();

	private LineItem shorts = LineItem.newBuilder()
			.articleNumber(ART_NO_SHORTS)
			.quantity(2)
			.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(10000L).vatAmount(2500L).build())
			.build();

	@Test
	public void shouldDeserialize() throws IOException {
		String serializedDto = "{\"amount\":{\"currencyCode\":\"SEK\",\"vatAmount\":7500,\"totalAmount\":30000},\"storeCard\":false,\"items\":[{\"articleNumber\":\"ART_NO_SWEATER\",\"amount\":{\"currencyCode\":\"SEK\",\"vatAmount\":5000,\"totalAmount\":20000},\"quantity\":2},{\"articleNumber\":\"ART_NO_SHORTS\",\"amount\":{\"currencyCode\":\"SEK\",\"vatAmount\":2500,\"totalAmount\":10000},\"quantity\":2}]}";
		String serializedDto1 = "{\"amount\":{\"currencyCode\":\"SEK\",\"vatAmount\":7500,\"totalAmount\":30000},\"method\":{\"id\":\"EasyPayment\",\"displayName\":\"Easy Payment\",\"fee\":0},\"storeCard\":false,\"items\":[{\"articleNumber\":\"ART_NO_SWEATER\",\"amount\":{\"currencyCode\":\"SEK\",\"vatAmount\":5000,\"totalAmount\":20000},\"quantity\":2},{\"articleNumber\":\"ART_NO_SHORTS\",\"amount\":{\"currencyCode\":\"SEK\",\"vatAmount\":2500,\"totalAmount\":10000},\"quantity\":2}]}";
		PaymentRegisterRequest rq = JsonUtil.getJsonMapper().readValue(serializedDto, PaymentRegisterRequest.class);
		PaymentRegisterRequest rq1 = JsonUtil.getJsonMapper().readValue(serializedDto1, PaymentRegisterRequest.class);
		assertThat(rq.getMethod().isPresent(), equalTo(false));
		assertThat(rq1.getMethod().get(), equalTo(new Method(MethodEnum.EASY_PAY)));
	}
	
	
	@Test
	public void orderNumberShouldNotValidate() throws IOException {
		PaymentRegisterRequest rq = PaymentRegisterRequest.newBuilder()
										.orderNumber("\041\177")
										.newItemList()
											.addItem(sweater)
											.addItem(shorts)
										.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(30000L).vatAmount(7500L).build())
										.build();
		Set<ConstraintViolation<PaymentRegisterRequest>> violations = VALIDATOR.validate(rq);
		assertThat(violations.isEmpty(), is(not(true)));
		
		
	}
	@Test
	public void missingApplePayTokenShouldNotValidate() throws IOException {
		PaymentRegisterRequest rq = PaymentRegisterRequest.newBuilder()
										.orderNumber("177")
										.customerId("MyUnitTest")
										.method(PaymentServiceImpl.APPLE_PAY)
										.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(30000L).vatAmount(7500L).build())
										.build();
		Set<ConstraintViolation<PaymentRegisterRequest>> violations = VALIDATOR.validate(rq);
		assertThat(violations.isEmpty(), is(not(true)));
		assertThat(violations.toString(), containsString("Payment data is required when using ApplePay"));
	}
	@Test
	public void availableApplePayTokenShouldValidateOK() throws IOException {
		PaymentRegisterRequest rq = PaymentRegisterRequest.newBuilder()
										.orderNumber("177")
										.customerId("MyUnitTest")
										.method(PaymentServiceImpl.APPLE_PAY)
										.paymentData("DummyData")
										.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(30000L).vatAmount(7500L).build())
										.build();
		Set<ConstraintViolation<PaymentRegisterRequest>> violations = VALIDATOR.validate(rq);
		assertThat(violations.isEmpty(), is(true));
	}
	@Test
	public void missingEasyPayTokenIdShouldNotValidate() throws IOException {
		PaymentRegisterRequest rq = PaymentRegisterRequest.newBuilder()
										.orderNumber("177")
										.customerId("MyUnitTest")
										.method(PaymentServiceImpl.EASY_PAY)
										.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(30000L).vatAmount(7500L).build())
										.build();
		Set<ConstraintViolation<PaymentRegisterRequest>> violations = VALIDATOR.validate(rq);
		assertThat(violations.isEmpty(), is(not(true)));
		assertThat(violations.toString(), containsString("A card ID is required when using EasyPay"));
	}
	@Test
	public void availableEasyPayTokenIdShouldValidateOK() throws IOException {
		PaymentRegisterRequest rq = PaymentRegisterRequest.newBuilder()
										.orderNumber("177")
										.customerId("MyUnitTest")
										.method(PaymentServiceImpl.EASY_PAY)
										.cardId("123456")
										.amount(Amount.newBuilder().currencyCode(CURRENCY).totalAmount(30000L).vatAmount(7500L).build())
										.build();
		Set<ConstraintViolation<PaymentRegisterRequest>> violations = VALIDATOR.validate(rq);
		assertThat(violations.isEmpty(), is(true));
	}

}
