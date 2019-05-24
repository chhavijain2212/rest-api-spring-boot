package myemmo.chhavi.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "myemmo.chhavi.cars")
@SpringBootApplication
public class CarsApplication 
{	
	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

}
