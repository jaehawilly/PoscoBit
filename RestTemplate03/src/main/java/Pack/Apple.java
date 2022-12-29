package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Mono;

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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Person {
	String name;
	int age;
}

@RestController
@RequestMapping("/app2/{num}")
class AppController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("")
	public String f1(@PathVariable String num) {
		System.out.println("app2");

		// 요청
		Integer data = restTemplate.getForObject(
				"http://localhost:8082/bpp2/{a1}/{a2}", 
				Integer.class, 
				777, 888
		);
//		String result = "";
//		for (Person v : data) {
//			result += (v.getName() + " " + v.getAge() + " ");
//		}
		
//		ResponseEntity<Person[]> data = restTemplate.getForEntity(
//				"http://localhost:8082/bpp2/{num}", 
//				Person[].class,
//				num + 999);
//		
//		String result = "";
//		for (Person v : data.getBody()) {
//			result += (v.getName() + " " + v.getAge() + " ");
//		}

		return "app1 : " + data;
	}
}



@RestController
@RequestMapping("/app3")
class AppController3{
	@GetMapping("")
	public String f1() {
		System.out.println("app3");
		
		// LinkedList<Integer> 타입
//		WebClient client = WebClient.create(); // 객체 생성
//		System.out.println(client.hashCode());
//		
//		// 개발용.....
//		Integer[] data = client
//			.get()
//			.uri("http://localhost:8082/bpp2")
//			.retrieve()
//			.bodyToMono(Integer[].class)
//			.block();
//		
//		String s = "";
//		for(Integer v: data) {
//			s += (v + " ");
//		}
//		
//		return s;
		
		
		// 개발용.....
//		Person data = client
//			.get()
//			.uri("http://localhost:8082/bpp2")
//			.retrieve()
//			.bodyToMono(Person.class)
//			.block();
//		
//		return data.getName() + " " + data.getAge();
		
		
		// 실제 코드
//		return client
//				.get()
//				.uri("http://localhost:8082/bpp2")
//				.retrieve()
//				.bodyToMono(String.class);
		
		Mono<String> result = f2();
		result.subscribe((v) -> {
			System.out.println("나중 실행........");
			System.out.println(v);
		});
		System.out.println("먼저 실행........");
		
		return null;
	}
	
	public Mono<String> f2() {
		WebClient client = WebClient.create();
		return client
				.get()
				.uri("http://localhost:8082/bpp2")
				.retrieve()
				.bodyToMono(String.class);
	}
}






