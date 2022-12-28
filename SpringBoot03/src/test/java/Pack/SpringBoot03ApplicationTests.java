package Pack;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lombok.*;

// 곱하기만 전용으로 해주는 서비스
class Multiplication{ // Multiple + application
	int a, b;
	Multiplication(int a, int b) {this.a = a; this.b = b;}
	
	int getResult() { 
		System.out.println(a + " " + b);
		return a * b; 
	}
}


// -----------------------------------------------
interface RandomGeneratorService{
	public int getNum();
}

@Service
class RandomGeneratorServiceImp implements RandomGeneratorService{
	@Override
	public int getNum() {
		return new Random().nextInt(10);
	}
}
// -----------------------------------------------


interface MultiplicationService{
	public Multiplication f1();
}

@Service
class MultiplicationServiceImp implements MultiplicationService{
	@Autowired
	RandomGeneratorService b;
	
	@Override
	public Multiplication f1() {
		return new Multiplication(b.getNum(), b.getNum());
	}
}

@RequiredArgsConstructor
class Sample {
	final String name;
	final Integer age;
	Sample() {
		this("", 0);
	}
}

@SpringBootTest
class SpringBoot03ApplicationTests {
//	@Autowired
//	MultiplicationService c;
	
	@Test
	void test01() {
		Sample t1 = new Sample("호랑이", 100);
		System.out.println(t1.name);
		
//		Multiplication a = c.f1();
//		System.out.println(a.getResult());
	}
}



// @Service
// @Component
// @Controller
// @RestController
// @Repository






