package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/users")
class Banana {
	@GetMapping("")
	public String f1() {
		System.out.println("f1");
		return "f1";
	}
	
//	@GetMapping("/1")
	@GetMapping("/{num}")
	public String f2(@PathVariable String num) {
		System.out.println("f2 : " + num);
		return "f2";
	}
	
	@GetMapping("/{num}/{name}")
	public String f3(
			@PathVariable String num, 
			@PathVariable String name) {
		System.out.println("f3 : " + num + name);
		return "f3 : " + num + name;
	}
	
//	@GetMapping("")
//	public String f4(
//			@RequestParam("postId") String postId) {
//		System.out.println("f4 : " + postId);
//		return "f4 : " + postId;
//	}
}






