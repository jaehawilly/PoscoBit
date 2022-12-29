package Pack;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@RequestMapping("/app3")
class AppController{
	@GetMapping("")
	public LinkedList<Integer> f1() {
		System.out.println("bpp2");
		
//		return new Person("앵무새", 10);
		
		LinkedList<Integer> li = new LinkedList<>();
		li.add(1000);
		li.add(2000);
		li.add(3000);
		
		return li;
	}
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Person{
	String name;
	int age;
}


