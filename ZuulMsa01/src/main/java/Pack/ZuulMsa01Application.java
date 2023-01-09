package Pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulMsa01Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulMsa01Application.class, args);
	}

}
