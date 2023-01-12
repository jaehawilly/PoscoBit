package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
// ============================app=============================

@FeignClient(name = "noName", url = "http://localhost:8765")
interface TestClient {
	@GetMapping("/app/{id}")
	String myFunc(@PathVariable Integer id);
}

@RestController
@RequestMapping("/app")
class AppController {
	@Autowired
	TestClient testClient;
	
	@GetMapping("/{id}")
	public String f1(@PathVariable Integer id) {
		System.out.println("app/" + id);
		
		String str = testClient.myFunc(id);
		
		return "app : " + str;
	}
}

//============================bpp=============================

@FeignClient(name = "noName2", url = "http://localhost:8765")
interface TestClient2 {
	@GetMapping("/bpp/{token}")
	String myFunc(@RequestHeader Integer token);
}

@RestController
@RequestMapping("/bpp")
class BppController {
	@Autowired
	TestClient2 testClient2;
	
	@GetMapping("/{token}")
	public String f1(@PathVariable Integer token) {
		System.out.println("bpp/" + token);
		
		String str = testClient2.myFunc(token);
		
		return "bpp : " + str;
	}
}