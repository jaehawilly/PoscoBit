package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
public class Apple {
	@RequestMapping("/")
	public String func00() {
		System.out.println("Apple class Call");
		
		return "index";
	}
	
	@RequestMapping("/t1")
	public String func01() {
		System.out.println("func01 Call");
		
		return "AppleView";
	}
	
}

@RestController
@RequestMapping("/app1")
class AppController{
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{num}")
	@HystrixCommand(
			fallbackMethod = "catcat",
			commandProperties = {
					@HystrixProperty(
						name = "execution.isolation.thread.timeoutInMilliseconds",
						value = "500"), // 기본 타임아웃 설정(응답을 기다리는 시간)
					@HystrixProperty(
						name = "circuitBreaker.errorThresholdPercentage",
						value = "25"), // 25%이상 문제가 발생하면 서킷 오픈.
					@HystrixProperty(
						name = "metrics.rollingStats.timeInMilliseconds",
						value = "10000"), // 최근 10초동안 n회 이상 호출되면 통계 시작
					@HystrixProperty(
						name = "circuitBreaker.requestVolumeThreshold",
						value = "3"), // 윗 속성의 n이 3으로 설정
					@HystrixProperty(
						name = "circuitBreaker.sleepWindowInMilliseconds",
						value = "8000"), // 서킷 오픈 유지 시간
			}
	)
	public String f1(
			@PathVariable Integer num
			) {
		System.out.println("app1");
		
		// 광고 동영상 데이터를 주세요.
		String str = restTemplate.getForObject(
				"http://localhost:8082/bpp1/" + num, 
				String.class);
		
		return "app1 : " + str;
	}
	public String catcat(Integer num, Throwable t) {
		System.out.println("알림" + t);
		return "기본 광고를 시작합니다. " + num;
	}
}





