package eu.nets.ms.pia.integration.nets.netaxept;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import epayment.bbs.Register;
import eu.nets.ms.pia.business.domain.AdditionalData;
import eu.nets.ms.pia.service.model.Amount;
import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;

@RunWith(MockitoJUnitRunner.class)
public class NetAxeptRequestMapperTest {

	@Mock
	private PaymentRegisterRequest request;
	@Mock
	private Amount amount;
	@Mock
	private NetAxeptConfig cfg;
	@Mock
	private Method method;
	
	private static final String TEST_MOCK_ORDER_NUMBER = "123";
	private static final String TEST_MOCK_CFG_TOKEN = "TestToken";
	private static final String TEST_MOCK_MERCHANT_NAME = "TestMerchantName";
	private static final Long TEST_AMOUNT = 1L;
	private static final String TEST_MOCK_CURRENCY_CODE = "EUR";
	
	@Before
	public void setup(){
		when(cfg.isForce3Dsecure()).thenReturn(false);
		when(cfg.getToken(null)).thenReturn(TEST_MOCK_CFG_TOKEN);
		when(cfg.getUserName(null)).thenReturn(TEST_MOCK_MERCHANT_NAME);
		when(request.getOrderNumber()).thenReturn(TEST_MOCK_ORDER_NUMBER);
		when(request.getAmount()).thenReturn(amount);
		when(amount.getTotalAmount()).thenReturn(TEST_AMOUNT);
		when(amount.getCurrencyCode()).thenReturn(TEST_MOCK_CURRENCY_CODE);
		when(request.getMethod()).thenReturn(Optional.of(method));
		when(request.getMerchantId()).thenReturn(Optional.ofNullable(null));
	}
	
	@Test
	public void shouldConvertCardExpirydate() {
		assertThat(NetAxeptRequestMapper.convertToRecuringExpiryDate("01/18"), equalTo("20180201"));
		assertThat(NetAxeptRequestMapper.convertToRecuringExpiryDate("12/18"), equalTo("20190101"));
		assertThat(NetAxeptRequestMapper.convertToRecuringExpiryDate("11/18"), equalTo("20181201"));
		assertThat(NetAxeptRequestMapper.convertToRecuringExpiryDate("JUNK"), equalTo("19700101"));
		assertThat(NetAxeptRequestMapper.convertToRecuringExpiryDate("-1/18"), equalTo("19700101"));
		assertThat(NetAxeptRequestMapper.convertToRecuringExpiryDate(null), equalTo("19700101"));
	}

	@Test
	public void mapNormalPurchaseRequest() {
		when(request.getStoreCard()).thenReturn(false);

		Register reg = NetAxeptRequestMapper.mapRegisterRequest(request, null, cfg);
		
		assertThat(reg.getToken(), equalTo(TEST_MOCK_CFG_TOKEN));
		assertThat(reg.getMerchantId(), equalTo(TEST_MOCK_MERCHANT_NAME));
		assertThat(reg.getRequest().getRecurring(), equalTo(null));
		assertThat(reg.getRequest().getServiceType(), equalTo("M"));
		assertThat(reg.getRequest().getTransactionReconRef(), equalTo(TEST_MOCK_ORDER_NUMBER));
		assertThat(reg.getRequest().getOrder().getAmount(), equalTo(TEST_AMOUNT.toString()));
		assertThat(reg.getRequest().getOrder().getForce3DSecure(), equalTo(Boolean.toString(false)));
		assertThat(reg.getRequest().getOrder().getCurrencyCode(), equalTo(TEST_MOCK_CURRENCY_CODE));
		assertThat(reg.getRequest().getOrder().getOrderNumber(), equalTo(TEST_MOCK_ORDER_NUMBER));
	}

	@Test
	public void mapNormalPurchaseRequestWithTokenizationWithCVV() {
		when(request.getStoreCard()).thenReturn(true);
		
		
		Map<String, String> addData = new HashMap<>();
		addData.put(AdditionalData.REQUIRE_CVV_FROM_CONSUMER, "true");
		
		Register reg = NetAxeptRequestMapper.mapRegisterRequest(request, addData, cfg);
		
		assertThat(reg.getToken(), equalTo(TEST_MOCK_CFG_TOKEN));
		assertThat(reg.getMerchantId(), equalTo(TEST_MOCK_MERCHANT_NAME));
		assertThat(reg.getRequest().getRecurring().getType(), equalTo("S"));
		assertThat(reg.getRequest().getServiceType(), equalTo("M"));
		assertThat(reg.getRequest().getTransactionReconRef(), equalTo(TEST_MOCK_ORDER_NUMBER));
		assertThat(reg.getRequest().getOrder().getAmount(), equalTo(TEST_AMOUNT.toString()));
		assertThat(reg.getRequest().getOrder().getForce3DSecure(), equalTo(Boolean.toString(false)));
		assertThat(reg.getRequest().getOrder().getCurrencyCode(), equalTo(TEST_MOCK_CURRENCY_CODE));
		assertThat(reg.getRequest().getOrder().getOrderNumber(), equalTo(TEST_MOCK_ORDER_NUMBER));
	}
	

	@Test
	public void mapNormalPurchaseRequestWithTokenizationWithoutCVV() {
		when(request.getStoreCard()).thenReturn(true);
		
		Map<String, String> addData = new HashMap<>();
		addData.put(AdditionalData.REQUIRE_CVV_FROM_CONSUMER, "false");
		
		Register reg = NetAxeptRequestMapper.mapRegisterRequest(request, addData, cfg);
		
		assertThat(reg.getToken(), equalTo(TEST_MOCK_CFG_TOKEN));
		assertThat(reg.getMerchantId(), equalTo(TEST_MOCK_MERCHANT_NAME));
		assertThat(reg.getRequest().getRecurring().getType(), equalTo("R"));
		assertThat(reg.getRequest().getRecurring().getFrequency(), equalTo("0"));
		// expirydate covered with other tests
		assertThat(reg.getRequest().getServiceType(), equalTo("M"));
		assertThat(reg.getRequest().getTransactionReconRef(), equalTo(TEST_MOCK_ORDER_NUMBER));
		assertThat(reg.getRequest().getOrder().getAmount(), equalTo(TEST_AMOUNT.toString()));
		assertThat(reg.getRequest().getOrder().getForce3DSecure(), equalTo(Boolean.toString(false)));
		assertThat(reg.getRequest().getOrder().getCurrencyCode(), equalTo(TEST_MOCK_CURRENCY_CODE));
		assertThat(reg.getRequest().getOrder().getOrderNumber(), equalTo(TEST_MOCK_ORDER_NUMBER));
	}
}
