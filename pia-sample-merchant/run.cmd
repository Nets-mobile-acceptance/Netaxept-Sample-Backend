set spring.profiles.active=default
set NETAXEPT_HOST=test.epayment.nets.eu
set NETAXEPT_PORT=443

echo Starting Pia merchant backend demo
java -jar target\pia-merchant-service-2.0.0.jar
