package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
class AppController1{
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("")
	public String f1() {
		System.out.println("app1");
		
		// 문자열 주세요. 요청
		String str = restTemplate.getForObject(
				"http://localhost:8082/bpp1", String.class);
		
		return "app1 : " + str;
	}
}


@RestController
@RequestMapping("/app2")
class AppController2{
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("")
	public String f1() {
		System.out.println("app2");
		
		// 문자열 주세요. 요청
		String str = restTemplate.getForObject(
				"http://tiger/bpp1", String.class);
		
		return "app2 : " + str;
	}
}