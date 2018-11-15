# Netaxept-Sample-Backend
![](./Resources/NetsLogo.jpg)


The merchant sample backend is a reference implementation of  a merchant backend and the following main features are to be included:
- APIs for the merchant app to initiate a transaction.
- APIs toward NetAxept to receieve transaction status information

**PiA - Netaxept iOS SDK** can also be found [here](https://github.com/Nets-mobile-acceptance/Netaxept-iOS-SDK)

**PiA - Netaxept Android SDK** can also be found [here](https://github.com/Nets-mobile-acceptance/Netaxept-Android-SDK)	


# Get started:
![](./Resources/overview.png)

**netaxept-soap-client:**
	This project builds the client used for communicating with Netaxept
	
**pia-merchant-demo:**
	This contains the root pom which builds the netaxept client and the pia-merchant-service.

**etc/secrets:**
	The secrets.properties contains credentials needed to connect to Netaxept.

**src:**
	The sources for the demo merchant backend
	
**target:**
	precompiled ready to run jar file of the merchant demo backend
	
**root:**
	pom.xml	- pom for building the pia-merchant-service
	run.cmd - Sets up necessary environment variables end starts the service

![](./Resources/DesignUML.png)
	
# Installation
1) Edit credentials to Netaxept
Edit the file 
```
etc/secrets/secrets.properties
```
Enter the test credentials as supplied by Netaxept **(Note: There are Unit tests which verifies the connection to Netaxept, thus these tests require correct credentials.)**
Enter the test credentials as supplied by Netaxept or add "-DskipTests" to skip running tests 

2) Build "pia-merchant-demo"  
The merchant backend service has a dependency to netaxept-soap-client. For this reason when building for the first time,
build the multimodule project so that the client is installed in the local maven repo.
 
```
mvn clean install -Pdevelopment -f pia-merchant-demo/pom.xml
```

3) Run the service
```
:/> run
```

4) Generate javadoc of "pia-merchant-demo" and docs will be located under 
```
:/pia-merchant-demo>mvn javadoc:javadoc
```

# Payment flow
The payment flow follows the following process:
1) Register payment.
   This will stage a payment order in Netaxept using the parameters provided.
   The parameters define what type of payment is staged and will govern what steps are to follow.
   A unique reference to the staged transaction will be returned to the consumer and is to be used 
   during further processing.
2) Terminal call
   This phase does not involve this component.
   During this phase the Client SDK will provide payment details directly to Netaxept.
   For card payments this is PCI sensitive data like card number, CVV/CVD/CID.
   This data will be appended to the transaction identified by the transactionId returned during phase 1).
   This secret data is never passes through this component. It is transmitted and stored in the PCI certified
   environment at Netaxept.
   When done this data will be available for further processing the payment.
3) Authorization
   A call is made to Netaxept to authorize the transaction using the staged data.
   If the authorization succeeds the Order is placed to the Fake Order service.
   Once the order has been placed successfully the money can be captured in the next stage. 
   After successful authorization also the card token is stored for future use, if that option was selected during phase 1)
4) Finalization
   During this phase the payment is either captured or cancelled.
   The criteria for this is if the goods was successfully processed via the fake order service.
   A cancellation at this stage will free the amount which was reserved to the card account during phase 2.
   After capture, the transaction is complete and cannot be reversed. In that case a refund needs to be 
   invoked which is out of scope for this demo.

# Contact
If you have any question or feedback, please contact us via email: [mobile-acceptance@nets.eu](mailto:mobile-acceptance@nets.eu)

# License

MIT License

Copyright (c) 2018 Nets Denmark A/S

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rightsto use, copy, modify, merge, publish, distribute, sublicense, and/or sellcopies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in allcopies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS ORIMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THEAUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHERLIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THESOFTWARE.
