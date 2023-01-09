package Pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

// eureka zuul 사용법
// filterType
// pre
// api gateway 구축


class SimpleFilter extends ZuulFilter{
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String filterType() {
		return "pre"; // "post", "routing", "error"
	}
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		return null;
	}
}


@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient			// @EnableDiscoveryClient
public class ZuulServer01Application {
	
	@Bean
	public SimpleFilter simpleFilter() {
		return null;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulServer01Application.class, args);
	}

}
