package eu.nets.ms.pia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource({"classpath:config/application-${spring.profiles.active}.yml"})
@ComponentScan(basePackages = {"eu.nets.ms.pia"})
@SpringBootApplication
public class Application {
	public Application(){
		super();
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class);
    }
}
