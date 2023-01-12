package Pack;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

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

//==================SimpleFilter====================
//@RestController
//@RequestMapping("/app")
//class AppController{
//	@GetMapping("/{id}")
//	public String f1(@PathVariable Integer id) {
//		return (id==1000) ? "로그인성공" : "로그인실패";
//	}
//}


//==================AuthPostFilter====================
@Data
class Member {
	String id;
	String pw;
}

@RestController
@RequestMapping("/app")
class ZuulMsa01Controller {

	@PostMapping
	public ResponseEntity<?> f1(@RequestBody Member member) {
		System.out.println(member.toString());
//		HttpHeaders responseHeaders = new HttpHeaders();
//	    responseHeaders.set("authHeader", "auth");
	    boolean isCorrect = member.getPw().equals("1234");
		if(isCorrect) {
			return ResponseEntity
					.ok() // 200
//					.headers(responseHeaders)
					.body(member);
		}
		return ResponseEntity
				.badRequest() // 400
//				.headers(responseHeaders)
				.body("fail");
	}
}