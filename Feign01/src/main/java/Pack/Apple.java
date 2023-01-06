package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import feign.hystrix.FallbackFactory;

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
//	@Autowired
//	RestTemplate restTemplate;
	
	@GetMapping("")
	public String f1() {
//		System.out.println("app1");
//		System.out.println(restTemplate.hashCode());
//		
//		// 문자열 주세요. 요청
//		String str = restTemplate.getForObject(
//				"http://localhost:8082/bpp1", String.class);
		
		return "app1 : ";//  + str;
	}
}

//@FeignClient(name = "monkey", url="http://localhost:8082")
//import feign.hystrix.FallbackFactory;
@FeignClient(
		name = "Feign0002", 
		fallbackFactory = FeignFactory.class)
interface TestClient{
	@RequestMapping("/bpp1/{num}")
	String myFunc(@PathVariable Integer num);
}

@Component
class FeignFactory implements FallbackFactory<TestClient>{
	@Override
	public TestClient create(Throwable cause) {
		System.out.println("factory create call");
		return new TestClient() {
			@Override
			public String myFunc(@PathVariable Integer num) {
				System.out.println(num);
				return "Hystrix 발생됨";
			}
		};
	}
}

@RestController
@RequestMapping("/app2")
class AppController2{
	@Autowired
	TestClient testClient;
	
	@RequestMapping("/{num}")
	public String f1(@PathVariable Integer num) {
		System.out.println("app2");
		String str = testClient.myFunc(num);
		
		return "app2 : " + str;
	}
}

// ============================================================

//@FeignClient(name = "tiger", url="http://localhost:8082")
//interface TestClient2{
//	@RequestMapping("/bpp2/{num}")
//	String myFunc(@PathVariable Integer num);
//}
//
//@Service
//class TempService{
//	@Autowired
//	TestClient2 testClient2;
//	
//	String collectionCommand(Integer productId) {
//		/*
//		 db 접속
//		 // 20줄짜리 코드가 있다...
//		 		
//		*/
//		String str = testClient2.myFunc(productId);
//		return str;
//	}
//}
//
//@RestController
//@RequestMapping("/app3")
//class AppController3{
//	@Autowired
//	TempService tempService;
//	
//	@GetMapping("")
//	public String f1() {
//		System.out.println("app3");
//		
//		String str = tempService.collectionCommand(3000);
//		
//		return "app3 : " + str;
//	}
//}


