package Pack;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@RequestMapping("/t2")
	public String func02() {
		System.out.println("func02 Call");
		System.out.println(rabbitTemplate.hashCode());
		rabbitTemplate.convertAndSend(
			"exchange01",		// exchange
			"routingKey01",		// 주는놈의 key
			"LION"				// 보내는 문자열
		);
		return "redirect:/";
	}
	
}