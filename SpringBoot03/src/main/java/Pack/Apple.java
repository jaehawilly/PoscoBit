package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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