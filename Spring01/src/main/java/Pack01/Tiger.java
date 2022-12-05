package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tiger {
	@RequestMapping("/t1")
	public String func01() {
		System.out.println("function call");
		return "TigerView"; // 갈 곳의 뷰 이름
	}
}
