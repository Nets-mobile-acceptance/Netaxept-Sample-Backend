--------------------------------------------------------------------------------------------
Folder content:
--------------------------------------------------------------------------------------------
netaxept-soap-client:
	This project builds the client used for communicating with Netaxept
	
pia-merchant-demo:
	This contains the root pom which builds the netaxept client and the pia-merchant-service.

etc/secrets:
	The secrets.properties contains credentials needed to connect to Netaxept.

src:
	The sources for the demo merchant backend
target:
	precompiled ready to run jar file of the merchant demo backend
	
root:
	pom.xml	- pom for building the pia-merchant-service
	run.cmd - Sets up necessary environment variables end starts the service
	
	
--------------------------------------------------------------------------------------------
How to:
--------------------------------------------------------------------------------------------	
1) Edit credentials to Netaxept
Edit the file etc/secrets/secrets.properties
Enter the test credentials as supplied by Netaxept
Enter the test credentials as supplied by Netaxept or add "-DskipTests" to skip running tests in step 2)

Note: There are Unit tests which verifies the connection to Netaxept. 
These tests require correct credentials.

2) Build "pia-merchant-demo"  
The merchant backend service has a dependency to netaxept-soap-client. For this reason when building for the first time,
build the multimodule project so that the client is installed in the local maven repo.
 
mvn clean install -Pdevelopment -f pia-merchant-demo/pom.xml

3) Run the service
:/> run

4) Generate javadoc of "pia-merchant-demo" and docs will be located under 
:/pia-merchant-demo>mvn javadoc:javadoc