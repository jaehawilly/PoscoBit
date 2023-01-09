package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Apple {
	@GetMapping("/")
	public String func00() {
		System.out.println("Apple class Call");
		return "index";
	}
	
	@GetMapping("/t1")
	public String func01() {
		System.out.println("func01 Call");
		
		return "AppleView";
	}
}

@FeignClient(name = "noName", url = "http://localhost:8765")
interface TestClient {
	@GetMapping("/bpp1")
	String myFunc();
}

@RestController
@RequestMapping("/app1")
class AppController {
	@Autowired
	TestClient testClient;
	
	@GetMapping("")
	public String f1() {
		System.out.println("app1");
		
		String str = testClient.myFunc();
		
		return "app1 : " + str;
	}
}