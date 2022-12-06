package Pack01;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Tiger {
	@RequestMapping("/t1")
	public String func01() {
		System.out.println("func01");
		return null; // 갈 곳의 뷰 이름
	}
	@RequestMapping("/t2")
	public String func02() {
		System.out.println("func02");
		return "TigerView";
	}
	@RequestMapping("/t3")
	public String func03(
		@RequestParam(value="name") String name) {
		System.out.println("func03");
		System.out.println(name);
		return "TigerView";
	}
	@RequestMapping("/t4")
	public String func04(
		@RequestParam(value="name") String name,
		@RequestParam(value="age") Integer age) {
		System.out.println("func04");
		System.out.println(name + age);
		return "TigerView";
	}
	@RequestMapping("/t5")
	public String func05(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name + age);
		System.out.println("func05");
		return "TigerView";
	}
	@RequestMapping("/t6")
	public String func06(Model model) {
		System.out.println("func06");
		model.addAttribute("key1", "호랑이");
		model.addAttribute("key2", 100);
		return "TigerView";
	}
	@RequestMapping("/t7")
	public String func07(
			Model model,
			@RequestParam(value="name") String name,
			@RequestParam(value="age") Integer age) {
		System.out.println("func07");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		
		System.out.println(name + age);
		return "TigerView";
	}
	@RequestMapping("/t8")
	public ModelAndView func08() {
		System.out.println("func08");
		ModelAndView mv = new ModelAndView("TigerView");
		mv.addObject("name", "독수리");
		mv.addObject("age", 200);
		return mv;
	}
	@RequestMapping("/t9")
	public ModelAndView func09(
		@RequestParam(value="token") Boolean token
		){
		System.out.println("func09");
		ModelAndView mv = new ModelAndView(token ? "TigerView":"LionView");
		mv.addObject("name", "독수리");
		mv.addObject("age", 200);
		return mv;
	}
	@RequestMapping("/t11")
	public String func11(Person p) { // 커맨드 객체
		System.out.println("func11");
		System.out.println(p.getId() + p.getPw());
		return "MonkeyView";
	}
	@RequestMapping("/t12")
	public String func12(Model model) { // 커맨드 객체
		System.out.println("func12");
		
		// 1. 정수 전달
		int num = 10;
		model.addAttribute("num", num);
		// 2. 문자열 전달
		String str = "문자열";
		model.addAttribute("str", str);
		// 3. 배열 전달
		int[] ar = {100, 200, 300};
		model.addAttribute("ar", ar);
		// 4. 객체 전달
		Person person = new Person("소나무", 400);
		model.addAttribute("person", person);
		// 5. 리스트 전달(정수 목록)
		LinkedList<Integer> list01 = new LinkedList<>();
		list01.add(500);
		list01.add(600);
		list01.add(700);
		model.addAttribute("list01", list01);
		// 6. 리스트 전달(문자열 목록)
		LinkedList<String> list02 = new LinkedList<>();
		list02.add("독수리1");
		list02.add("독수리2");
		list02.add("독수리3");
		model.addAttribute("list02", list02);
		// 7. 리스트 전달(문자열 목록)
		LinkedList<Person> list03 = new LinkedList<>();
		list03.add(new Person("홍길동1", 800));
		list03.add(new Person("홍길동2", 900));
		list03.add(new Person("홍길동3", 990));
		model.addAttribute("list03", list03);
		
		return "MonkeyView";
	}
	
	@RequestMapping("/t13_1")
	public String func13_1(
			// required = false : 필수는 아니다.
			@RequestParam(value="name", required = false)
			String name) {
		System.out.println("func13_1");
		
		return "CatView";
	}
	@RequestMapping("/t13_2")
	public String func13_2(
			// required = false : 필수는 아니다.
			@RequestParam(value="name", required = true)
			String name) {
		System.out.println("func13_2");
		
		return "CatView";
	}
	@RequestMapping("/t13_3")
	public String func13_3(
			// required = t/f가 의미없다.
			@RequestParam(value="name", defaultValue = "고양이")
			String name) {
		System.out.println("func13_3");
		System.out.println(name);
		return "CatView";
	}
	
	// @RequestMapping은 get, post 모두 다 받아준다.
	// 				get, post를 지정해서 받을수가 있다.
	//@RequestMapping(value="/t14", method=RequestMethod.POST)
	@RequestMapping(value="/t14_1", method=RequestMethod.GET)
	public String func14_1() {
		System.out.println("func14_1");
		return "TigerView";
	}

	@RequestMapping(value="/t14_2", method=RequestMethod.POST)
	public String func14_2() {
		System.out.println("func14_2");
		return "TigerView";
	}
	
	@RequestMapping(value="/t14_3")
	public String func14_3() {
		System.out.println("func14_3");
		return "TigerView";
	}
	
	@GetMapping(value="/t15_1")
	public String func15_1() {
		System.out.println("func15_1");
		return "TigerView";
	}
	
	@PostMapping(value="/t15_2")
	public String func15_2() {
		System.out.println("func15_2");
		return "TigerView";
	}
	
	@RequestMapping(value="/register/step1")
	public String func16() {
		System.out.println("t16");
		
		// 이것은 실제 경로를 지시한다.
		return "register/step1";
	}
	
	@GetMapping(value="/t17")
	public String func17_1() {
		System.out.println("f17_1");
		return "DogView";
	}
	
	@PostMapping(value="/t17")
	public String func17_2() {
		System.out.println("func17_2");
		return "SnakeView";
	}
	
	@PostMapping(value="/t18")
	public String func18(Model model, Animal animal) {
		System.out.println("func18");
		
		System.out.println(animal.item.get(0));
		System.out.println(animal.item.get(1));
		System.out.println(animal.item.get(2));
		model.addAttribute("animal", animal);
		
		return "SnakeView";
	}
	
	@RequestMapping(value="/t19")
	public String func19(turtle turtle) {
		System.out.println("func19");
		System.out.println(turtle.rabbit.num1);
		System.out.println(turtle.num2);
		
		return "TurtleView";
	}
}



@Controller
@RequestMapping("register") // 1차 문자열
class Lion {
	@RequestMapping("/step2") // 2차 문자열
	public String f1() {
		System.out.println("step2");
		return "register/step2";
	}
	@RequestMapping("/step3") // 2차 문자열
	public String f2() {
		System.out.println("step3");
		return "register/step3";
	}
}











