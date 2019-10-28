
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.bbs_epayment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "RegisterRequest");
    private final static QName _AvtaleGiro_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "AvtaleGiro");
    private final static QName _CardInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "CardInfo");
    private final static QName _Customer_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Customer");
    private final static QName _DnBNorDirectPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "DnBNorDirectPayment");
    private final static QName _Environment_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Environment");
    private final static QName _Fraud_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Fraud");
    private final static QName _LoyaltyInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "LoyaltyInformation");
    private final static QName _MicroPayment_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "MicroPayment");
    private final static QName _Order_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Order");
    private final static QName _ArrayOfItem_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfItem");
    private final static QName _Item_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Item");
    private final static QName _PaymentFacilitatorInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "PaymentFacilitatorInformation");
    private final static QName _Recurring_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Recurring");
    private final static QName _Terminal_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Terminal");
    private final static QName _ArrayOfPaymentMethodAction_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfPaymentMethodAction");
    private final static QName _PaymentMethodAction_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "PaymentMethodAction");
    private final static QName _ArrayOfKeyValuePair_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfKeyValuePair");
    private final static QName _KeyValuePair_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "KeyValuePair");
    private final static QName _Token_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Token");
    private final static QName _RegisterResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "RegisterResponse");
    private final static QName _BBSException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "BBSException");
    private final static QName _Result_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "Result");
    private final static QName _AuthenticationException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "AuthenticationException");
    private final static QName _MerchantTranslationException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "MerchantTranslationException");
    private final static QName _UniqueTransactionIdException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "UniqueTransactionIdException");
    private final static QName _GenericError_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "GenericError");
    private final static QName _ValidationException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ValidationException");
    private final static QName _SecurityException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "SecurityException");
    private final static QName _PaymentInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "PaymentInfo");
    private final static QName _QueryResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "QueryResponse");
    private final static QName _AuthenticationInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "AuthenticationInformation");
    private final static QName _AvtaleGiroInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "AvtaleGiroInformation");
    private final static QName _CardInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "CardInformation");
    private final static QName _CustomerInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "CustomerInformation");
    private final static QName _DnBNorDirectPaymentInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "DnBNorDirectPaymentInformation");
    private final static QName _PaymentError_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "PaymentError");
    private final static QName _ArrayOfPaymentError_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfPaymentError");
    private final static QName _ArrayOfTransactionLogLine_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfTransactionLogLine");
    private final static QName _TransactionLogLine_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "TransactionLogLine");
    private final static QName _InvoiceInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "InvoiceInformation");
    private final static QName _OrderInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "OrderInformation");
    private final static QName _SecurityInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "SecurityInformation");
    private final static QName _FinancialSummary_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "FinancialSummary");
    private final static QName _TerminalInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "TerminalInformation");
    private final static QName _FraudAnalysis_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "FraudAnalysis");
    private final static QName _MobileInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "MobileInformation");
    private final static QName _WalletInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "WalletInformation");
    private final static QName _QueryRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "QueryRequest");
    private final static QName _QueryException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "QueryException");
    private final static QName _ProcessRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ProcessRequest");
    private final static QName _ProcessResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ProcessResponse");
    private final static QName _NotSupportedException_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "NotSupportedException");
    private final static QName _ArrayOfProcessRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfProcessRequest");
    private final static QName _ArrayOfProcessResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ArrayOfProcessResponse");
    private final static QName _ReconRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ReconRequest");
    private final static QName _ReconResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", "ReconResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.bbs_epayment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterRequest }
     * 
     */
    public RegisterRequest createRegisterRequest() {
        return new RegisterRequest();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link QueryRequest }
     * 
     */
    public QueryRequest createQueryRequest() {
        return new QueryRequest();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link ProcessRequest }
     * 
     */
    public ProcessRequest createProcessRequest() {
        return new ProcessRequest();
    }

    /**
     * Create an instance of {@link ProcessResponse }
     * 
     */
    public ProcessResponse createProcessResponse() {
        return new ProcessResponse();
    }

    /**
     * Create an instance of {@link ArrayOfProcessRequest }
     * 
     */
    public ArrayOfProcessRequest createArrayOfProcessRequest() {
        return new ArrayOfProcessRequest();
    }

    /**
     * Create an instance of {@link ArrayOfProcessResponse }
     * 
     */
    public ArrayOfProcessResponse createArrayOfProcessResponse() {
        return new ArrayOfProcessResponse();
    }

    /**
     * Create an instance of {@link ReconRequest }
     * 
     */
    public ReconRequest createReconRequest() {
        return new ReconRequest();
    }

    /**
     * Create an instance of {@link ReconResponse }
     * 
     */
    public ReconResponse createReconResponse() {
        return new ReconResponse();
    }

    /**
     * Create an instance of {@link AvtaleGiro }
     * 
     */
    public AvtaleGiro createAvtaleGiro() {
        return new AvtaleGiro();
    }

    /**
     * Create an instance of {@link CardInfo }
     * 
     */
    public CardInfo createCardInfo() {
        return new CardInfo();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link DnBNorDirectPayment }
     * 
     */
    public DnBNorDirectPayment createDnBNorDirectPayment() {
        return new DnBNorDirectPayment();
    }

    /**
     * Create an instance of {@link Environment }
     * 
     */
    public Environment createEnvironment() {
        return new Environment();
    }

    /**
     * Create an instance of {@link Fraud }
     * 
     */
    public Fraud createFraud() {
        return new Fraud();
    }

    /**
     * Create an instance of {@link LoyaltyInformation }
     * 
     */
    public LoyaltyInformation createLoyaltyInformation() {
        return new LoyaltyInformation();
    }

    /**
     * Create an instance of {@link MicroPayment }
     * 
     */
    public MicroPayment createMicroPayment() {
        return new MicroPayment();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link ArrayOfItem }
     * 
     */
    public ArrayOfItem createArrayOfItem() {
        return new ArrayOfItem();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link PaymentFacilitatorInformation }
     * 
     */
    public PaymentFacilitatorInformation createPaymentFacilitatorInformation() {
        return new PaymentFacilitatorInformation();
    }

    /**
     * Create an instance of {@link Recurring }
     * 
     */
    public Recurring createRecurring() {
        return new Recurring();
    }

    /**
     * Create an instance of {@link Terminal }
     * 
     */
    public Terminal createTerminal() {
        return new Terminal();
    }

    /**
     * Create an instance of {@link ArrayOfPaymentMethodAction }
     * 
     */
    public ArrayOfPaymentMethodAction createArrayOfPaymentMethodAction() {
        return new ArrayOfPaymentMethodAction();
    }

    /**
     * Create an instance of {@link PaymentMethodAction }
     * 
     */
    public PaymentMethodAction createPaymentMethodAction() {
        return new PaymentMethodAction();
    }

    /**
     * Create an instance of {@link ArrayOfKeyValuePair }
     * 
     */
    public ArrayOfKeyValuePair createArrayOfKeyValuePair() {
        return new ArrayOfKeyValuePair();
    }

    /**
     * Create an instance of {@link KeyValuePair }
     * 
     */
    public KeyValuePair createKeyValuePair() {
        return new KeyValuePair();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link BBSException }
     * 
     */
    public BBSException createBBSException() {
        return new BBSException();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link AuthenticationException }
     * 
     */
    public AuthenticationException createAuthenticationException() {
        return new AuthenticationException();
    }

    /**
     * Create an instance of {@link MerchantTranslationException }
     * 
     */
    public MerchantTranslationException createMerchantTranslationException() {
        return new MerchantTranslationException();
    }

    /**
     * Create an instance of {@link UniqueTransactionIdException }
     * 
     */
    public UniqueTransactionIdException createUniqueTransactionIdException() {
        return new UniqueTransactionIdException();
    }

    /**
     * Create an instance of {@link GenericError }
     * 
     */
    public GenericError createGenericError() {
        return new GenericError();
    }

    /**
     * Create an instance of {@link ValidationException }
     * 
     */
    public ValidationException createValidationException() {
        return new ValidationException();
    }

    /**
     * Create an instance of {@link SecurityException }
     * 
     */
    public SecurityException createSecurityException() {
        return new SecurityException();
    }

    /**
     * Create an instance of {@link PaymentInfo }
     * 
     */
    public PaymentInfo createPaymentInfo() {
        return new PaymentInfo();
    }

    /**
     * Create an instance of {@link AuthenticationInformation }
     * 
     */
    public AuthenticationInformation createAuthenticationInformation() {
        return new AuthenticationInformation();
    }

    /**
     * Create an instance of {@link AvtaleGiroInformation }
     * 
     */
    public AvtaleGiroInformation createAvtaleGiroInformation() {
        return new AvtaleGiroInformation();
    }

    /**
     * Create an instance of {@link CardInformation }
     * 
     */
    public CardInformation createCardInformation() {
        return new CardInformation();
    }

    /**
     * Create an instance of {@link CustomerInformation }
     * 
     */
    public CustomerInformation createCustomerInformation() {
        return new CustomerInformation();
    }

    /**
     * Create an instance of {@link DnBNorDirectPaymentInformation }
     * 
     */
    public DnBNorDirectPaymentInformation createDnBNorDirectPaymentInformation() {
        return new DnBNorDirectPaymentInformation();
    }

    /**
     * Create an instance of {@link PaymentError }
     * 
     */
    public PaymentError createPaymentError() {
        return new PaymentError();
    }

    /**
     * Create an instance of {@link ArrayOfPaymentError }
     * 
     */
    public ArrayOfPaymentError createArrayOfPaymentError() {
        return new ArrayOfPaymentError();
    }

    /**
     * Create an instance of {@link ArrayOfTransactionLogLine }
     * 
     */
    public ArrayOfTransactionLogLine createArrayOfTransactionLogLine() {
        return new ArrayOfTransactionLogLine();
    }

    /**
     * Create an instance of {@link TransactionLogLine }
     * 
     */
    public TransactionLogLine createTransactionLogLine() {
        return new TransactionLogLine();
    }

    /**
     * Create an instance of {@link InvoiceInformation }
     * 
     */
    public InvoiceInformation createInvoiceInformation() {
        return new InvoiceInformation();
    }

    /**
     * Create an instance of {@link OrderInformation }
     * 
     */
    public OrderInformation createOrderInformation() {
        return new OrderInformation();
    }

    /**
     * Create an instance of {@link SecurityInformation }
     * 
     */
    public SecurityInformation createSecurityInformation() {
        return new SecurityInformation();
    }

    /**
     * Create an instance of {@link FinancialSummary }
     * 
     */
    public FinancialSummary createFinancialSummary() {
        return new FinancialSummary();
    }

    /**
     * Create an instance of {@link TerminalInformation }
     * 
     */
    public TerminalInformation createTerminalInformation() {
        return new TerminalInformation();
    }

    /**
     * Create an instance of {@link FraudAnalysis }
     * 
     */
    public FraudAnalysis createFraudAnalysis() {
        return new FraudAnalysis();
    }

    /**
     * Create an instance of {@link MobileInformation }
     * 
     */
    public MobileInformation createMobileInformation() {
        return new MobileInformation();
    }

    /**
     * Create an instance of {@link WalletInformation }
     * 
     */
    public WalletInformation createWalletInformation() {
        return new WalletInformation();
    }

    /**
     * Create an instance of {@link QueryException }
     * 
     */
    public QueryException createQueryException() {
        return new QueryException();
    }

    /**
     * Create an instance of {@link NotSupportedException }
     * 
     */
    public NotSupportedException createNotSupportedException() {
        return new NotSupportedException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "RegisterRequest")
    public JAXBElement<RegisterRequest> createRegisterRequest(RegisterRequest value) {
        return new JAXBElement<RegisterRequest>(_RegisterRequest_QNAME, RegisterRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvtaleGiro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "AvtaleGiro")
    public JAXBElement<AvtaleGiro> createAvtaleGiro(AvtaleGiro value) {
        return new JAXBElement<AvtaleGiro>(_AvtaleGiro_QNAME, AvtaleGiro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "CardInfo")
    public JAXBElement<CardInfo> createCardInfo(CardInfo value) {
        return new JAXBElement<CardInfo>(_CardInfo_QNAME, CardInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DnBNorDirectPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "DnBNorDirectPayment")
    public JAXBElement<DnBNorDirectPayment> createDnBNorDirectPayment(DnBNorDirectPayment value) {
        return new JAXBElement<DnBNorDirectPayment>(_DnBNorDirectPayment_QNAME, DnBNorDirectPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Environment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Environment")
    public JAXBElement<Environment> createEnvironment(Environment value) {
        return new JAXBElement<Environment>(_Environment_QNAME, Environment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fraud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Fraud")
    public JAXBElement<Fraud> createFraud(Fraud value) {
        return new JAXBElement<Fraud>(_Fraud_QNAME, Fraud.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoyaltyInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "LoyaltyInformation")
    public JAXBElement<LoyaltyInformation> createLoyaltyInformation(LoyaltyInformation value) {
        return new JAXBElement<LoyaltyInformation>(_LoyaltyInformation_QNAME, LoyaltyInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MicroPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "MicroPayment")
    public JAXBElement<MicroPayment> createMicroPayment(MicroPayment value) {
        return new JAXBElement<MicroPayment>(_MicroPayment_QNAME, MicroPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfItem")
    public JAXBElement<ArrayOfItem> createArrayOfItem(ArrayOfItem value) {
        return new JAXBElement<ArrayOfItem>(_ArrayOfItem_QNAME, ArrayOfItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentFacilitatorInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "PaymentFacilitatorInformation")
    public JAXBElement<PaymentFacilitatorInformation> createPaymentFacilitatorInformation(PaymentFacilitatorInformation value) {
        return new JAXBElement<PaymentFacilitatorInformation>(_PaymentFacilitatorInformation_QNAME, PaymentFacilitatorInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recurring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Recurring")
    public JAXBElement<Recurring> createRecurring(Recurring value) {
        return new JAXBElement<Recurring>(_Recurring_QNAME, Recurring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Terminal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Terminal")
    public JAXBElement<Terminal> createTerminal(Terminal value) {
        return new JAXBElement<Terminal>(_Terminal_QNAME, Terminal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPaymentMethodAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfPaymentMethodAction")
    public JAXBElement<ArrayOfPaymentMethodAction> createArrayOfPaymentMethodAction(ArrayOfPaymentMethodAction value) {
        return new JAXBElement<ArrayOfPaymentMethodAction>(_ArrayOfPaymentMethodAction_QNAME, ArrayOfPaymentMethodAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentMethodAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "PaymentMethodAction")
    public JAXBElement<PaymentMethodAction> createPaymentMethodAction(PaymentMethodAction value) {
        return new JAXBElement<PaymentMethodAction>(_PaymentMethodAction_QNAME, PaymentMethodAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValuePair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfKeyValuePair")
    public JAXBElement<ArrayOfKeyValuePair> createArrayOfKeyValuePair(ArrayOfKeyValuePair value) {
        return new JAXBElement<ArrayOfKeyValuePair>(_ArrayOfKeyValuePair_QNAME, ArrayOfKeyValuePair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyValuePair }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "KeyValuePair")
    public JAXBElement<KeyValuePair> createKeyValuePair(KeyValuePair value) {
        return new JAXBElement<KeyValuePair>(_KeyValuePair_QNAME, KeyValuePair.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Token }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Token")
    public JAXBElement<Token> createToken(Token value) {
        return new JAXBElement<Token>(_Token_QNAME, Token.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "RegisterResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BBSException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "BBSException")
    public JAXBElement<BBSException> createBBSException(BBSException value) {
        return new JAXBElement<BBSException>(_BBSException_QNAME, BBSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "Result")
    public JAXBElement<Result> createResult(Result value) {
        return new JAXBElement<Result>(_Result_QNAME, Result.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "AuthenticationException")
    public JAXBElement<AuthenticationException> createAuthenticationException(AuthenticationException value) {
        return new JAXBElement<AuthenticationException>(_AuthenticationException_QNAME, AuthenticationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantTranslationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "MerchantTranslationException")
    public JAXBElement<MerchantTranslationException> createMerchantTranslationException(MerchantTranslationException value) {
        return new JAXBElement<MerchantTranslationException>(_MerchantTranslationException_QNAME, MerchantTranslationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueTransactionIdException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "UniqueTransactionIdException")
    public JAXBElement<UniqueTransactionIdException> createUniqueTransactionIdException(UniqueTransactionIdException value) {
        return new JAXBElement<UniqueTransactionIdException>(_UniqueTransactionIdException_QNAME, UniqueTransactionIdException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "GenericError")
    public JAXBElement<GenericError> createGenericError(GenericError value) {
        return new JAXBElement<GenericError>(_GenericError_QNAME, GenericError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ValidationException")
    public JAXBElement<ValidationException> createValidationException(ValidationException value) {
        return new JAXBElement<ValidationException>(_ValidationException_QNAME, ValidationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "SecurityException")
    public JAXBElement<SecurityException> createSecurityException(SecurityException value) {
        return new JAXBElement<SecurityException>(_SecurityException_QNAME, SecurityException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "PaymentInfo")
    public JAXBElement<PaymentInfo> createPaymentInfo(PaymentInfo value) {
        return new JAXBElement<PaymentInfo>(_PaymentInfo_QNAME, PaymentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "QueryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "AuthenticationInformation")
    public JAXBElement<AuthenticationInformation> createAuthenticationInformation(AuthenticationInformation value) {
        return new JAXBElement<AuthenticationInformation>(_AuthenticationInformation_QNAME, AuthenticationInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvtaleGiroInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "AvtaleGiroInformation")
    public JAXBElement<AvtaleGiroInformation> createAvtaleGiroInformation(AvtaleGiroInformation value) {
        return new JAXBElement<AvtaleGiroInformation>(_AvtaleGiroInformation_QNAME, AvtaleGiroInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "CardInformation")
    public JAXBElement<CardInformation> createCardInformation(CardInformation value) {
        return new JAXBElement<CardInformation>(_CardInformation_QNAME, CardInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "CustomerInformation")
    public JAXBElement<CustomerInformation> createCustomerInformation(CustomerInformation value) {
        return new JAXBElement<CustomerInformation>(_CustomerInformation_QNAME, CustomerInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DnBNorDirectPaymentInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "DnBNorDirectPaymentInformation")
    public JAXBElement<DnBNorDirectPaymentInformation> createDnBNorDirectPaymentInformation(DnBNorDirectPaymentInformation value) {
        return new JAXBElement<DnBNorDirectPaymentInformation>(_DnBNorDirectPaymentInformation_QNAME, DnBNorDirectPaymentInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "PaymentError")
    public JAXBElement<PaymentError> createPaymentError(PaymentError value) {
        return new JAXBElement<PaymentError>(_PaymentError_QNAME, PaymentError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPaymentError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfPaymentError")
    public JAXBElement<ArrayOfPaymentError> createArrayOfPaymentError(ArrayOfPaymentError value) {
        return new JAXBElement<ArrayOfPaymentError>(_ArrayOfPaymentError_QNAME, ArrayOfPaymentError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTransactionLogLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfTransactionLogLine")
    public JAXBElement<ArrayOfTransactionLogLine> createArrayOfTransactionLogLine(ArrayOfTransactionLogLine value) {
        return new JAXBElement<ArrayOfTransactionLogLine>(_ArrayOfTransactionLogLine_QNAME, ArrayOfTransactionLogLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionLogLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "TransactionLogLine")
    public JAXBElement<TransactionLogLine> createTransactionLogLine(TransactionLogLine value) {
        return new JAXBElement<TransactionLogLine>(_TransactionLogLine_QNAME, TransactionLogLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "InvoiceInformation")
    public JAXBElement<InvoiceInformation> createInvoiceInformation(InvoiceInformation value) {
        return new JAXBElement<InvoiceInformation>(_InvoiceInformation_QNAME, InvoiceInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "OrderInformation")
    public JAXBElement<OrderInformation> createOrderInformation(OrderInformation value) {
        return new JAXBElement<OrderInformation>(_OrderInformation_QNAME, OrderInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "SecurityInformation")
    public JAXBElement<SecurityInformation> createSecurityInformation(SecurityInformation value) {
        return new JAXBElement<SecurityInformation>(_SecurityInformation_QNAME, SecurityInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinancialSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "FinancialSummary")
    public JAXBElement<FinancialSummary> createFinancialSummary(FinancialSummary value) {
        return new JAXBElement<FinancialSummary>(_FinancialSummary_QNAME, FinancialSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TerminalInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "TerminalInformation")
    public JAXBElement<TerminalInformation> createTerminalInformation(TerminalInformation value) {
        return new JAXBElement<TerminalInformation>(_TerminalInformation_QNAME, TerminalInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FraudAnalysis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "FraudAnalysis")
    public JAXBElement<FraudAnalysis> createFraudAnalysis(FraudAnalysis value) {
        return new JAXBElement<FraudAnalysis>(_FraudAnalysis_QNAME, FraudAnalysis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MobileInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "MobileInformation")
    public JAXBElement<MobileInformation> createMobileInformation(MobileInformation value) {
        return new JAXBElement<MobileInformation>(_MobileInformation_QNAME, MobileInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WalletInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "WalletInformation")
    public JAXBElement<WalletInformation> createWalletInformation(WalletInformation value) {
        return new JAXBElement<WalletInformation>(_WalletInformation_QNAME, WalletInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "QueryRequest")
    public JAXBElement<QueryRequest> createQueryRequest(QueryRequest value) {
        return new JAXBElement<QueryRequest>(_QueryRequest_QNAME, QueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "QueryException")
    public JAXBElement<QueryException> createQueryException(QueryException value) {
        return new JAXBElement<QueryException>(_QueryException_QNAME, QueryException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ProcessRequest")
    public JAXBElement<ProcessRequest> createProcessRequest(ProcessRequest value) {
        return new JAXBElement<ProcessRequest>(_ProcessRequest_QNAME, ProcessRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ProcessResponse")
    public JAXBElement<ProcessResponse> createProcessResponse(ProcessResponse value) {
        return new JAXBElement<ProcessResponse>(_ProcessResponse_QNAME, ProcessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotSupportedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "NotSupportedException")
    public JAXBElement<NotSupportedException> createNotSupportedException(NotSupportedException value) {
        return new JAXBElement<NotSupportedException>(_NotSupportedException_QNAME, NotSupportedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProcessRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfProcessRequest")
    public JAXBElement<ArrayOfProcessRequest> createArrayOfProcessRequest(ArrayOfProcessRequest value) {
        return new JAXBElement<ArrayOfProcessRequest>(_ArrayOfProcessRequest_QNAME, ArrayOfProcessRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProcessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ArrayOfProcessResponse")
    public JAXBElement<ArrayOfProcessResponse> createArrayOfProcessResponse(ArrayOfProcessResponse value) {
        return new JAXBElement<ArrayOfProcessResponse>(_ArrayOfProcessResponse_QNAME, ArrayOfProcessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReconRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ReconRequest")
    public JAXBElement<ReconRequest> createReconRequest(ReconRequest value) {
        return new JAXBElement<ReconRequest>(_ReconRequest_QNAME, ReconRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReconResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary", name = "ReconResponse")
    public JAXBElement<ReconResponse> createReconResponse(ReconResponse value) {
        return new JAXBElement<ReconResponse>(_ReconResponse_QNAME, ReconResponse.class, null, value);
    }

}
