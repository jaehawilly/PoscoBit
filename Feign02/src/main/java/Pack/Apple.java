package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/bpp1")
class BppController2{
	@GetMapping("/{num}")
	public String f1(@PathVariable Integer num) {
		System.out.println("bpp1");
		try {
			Thread.sleep(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "호랑이" + num;
	}
}

@RestController
@RequestMapping("/bpp2")
class AppController2{
	@GetMapping("/{num}")
	public String f1(@PathVariable Integer num) {
		System.out.println("bpp2");
		return "앵무새" + num;
	}
}