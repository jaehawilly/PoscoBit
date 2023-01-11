package Pack;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

// eureka zuul 사용법
// filterType
// pre
// api gateway 구축


@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient			// @EnableDiscoveryClient
public class ZuulServer01Application {
	
	@Bean
	SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulServer01Application.class, args);
	}

}
