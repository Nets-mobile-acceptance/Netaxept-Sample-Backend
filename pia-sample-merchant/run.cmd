set spring.profiles.active=default
set NETAXEPT_HOST=test.epayment.nets.eu
set NETAXEPT_PORT=443

echo Starting Pia merchant backend demo
java -jar target\pia-merchant-service-1.5.0.jar
