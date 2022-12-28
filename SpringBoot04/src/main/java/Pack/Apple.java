package Pack;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

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
@AllArgsConstructor
class Multiplication{
	final int factorA; // 3
	final int factorB; // 4
	public Multiplication() {
		this(0, 0);
	}
}

@Setter
@Getter
@NoArgsConstructor			// 디폴트 생성자
class User{
	String alias;
}

@Setter
@Getter
@NoArgsConstructor			// 디폴트 생성자
class MultiplicationResultAttempt{
	User user; 						// 수검자
	Multiplication multiplication;	// 문제
	int resultAttempt;				// 답안
}

interface RandomGenService{
	int getGenRandom();
	int getGenRandomA();
}

@Service
class RandomGenServiceImp implements RandomGenService{
	@Override
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
	@Override
	public int getGenRandomA() {
		return new Random().nextInt(10) + 10; // 10~19 random 값
	}
}

interface MultiplicationService{
	Multiplication createRandomMultiplication();
	boolean checkAttempt(MultiplicationResultAttempt mra);
}

@Service
class MultiplicationServiceImp implements MultiplicationService{
	@Autowired
	RandomGenService rgs;
	
	// 문제 제출 서비스
	public Multiplication createRandomMultiplication() {
		int factorA = rgs.getGenRandom();
		int factorB = rgs.getGenRandom();
		return new Multiplication(factorA, factorB);
	}
	// 답안 채점 서비스 함수
	public boolean checkAttempt(MultiplicationResultAttempt mra) {
		System.out.println("채점을 시작합니다. 결과를 리턴합니다.");
		return mra.getResultAttempt() == 
		mra.getMultiplication().getFactorA() * 
		mra.getMultiplication().getFactorB();
	}
}


@RestController
class Tiger{
	@Autowired
	MultiplicationService multiplicationService;
	
	@RequestMapping("/t2")
	public String func01() {
		System.out.println("func01 Call");
		
		return "호랑이";
	}
	@RequestMapping("/t3")
	public Multiplication func02() {
		System.out.println("func02 Call");
		// (3, 4) 문제를 리턴한다.
		return multiplicationService.createRandomMultiplication();
	}
	
	@RequestMapping("/t4")
	public boolean func03(
			@RequestBody MultiplicationResultAttempt mra
			) {
		System.out.println("test : t4");
		System.out.println(mra.user.alias);
		System.out.println(mra.multiplication.factorA);
		System.out.println(mra.multiplication.factorB);
		System.out.println(mra.resultAttempt);
		// (3, 4) 문제를 리턴한다.
		return multiplicationService.checkAttempt(mra);
	}
}







