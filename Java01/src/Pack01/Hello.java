package Pack01;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// ex)
//public class Hello {
//	public static void main(String[] args) {
//		
//	}
//}



/*
//ex74-5)
class Tiger extends Thread{
	Button button;
	Hello hello;
	Tiger(){}
	Tiger(Button button){
		this.button=button;
	}
	Tiger(Hello hello) {
		this.hello = hello;
	}
	public void run() {
		System.out.println("외부");
		Platform.runLater(() -> {			
//			button.setText("앵무새");
			hello.btn1.setText("소나무");
		});
	}
}

public class Hello extends Application{
	Button btn1, btn2;
	
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(1);
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		// -------------------------------------------------------------------
		btn1 = new Button("서버오픈");
		btn2 = new Button("버튼2");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				new Thread() {
					public void run() {
						System.out.println("thread");
						
						// 람다식으로 넣기를 원한다.
						Platform.runLater( ()->{
							//btn1.setText("호랑이");
							btn1.setDisable(true);
						});
					}
				}.start();
			}
		});
//		btn1.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				btn2.setText("호랑이"); //btn1을 누르면 btn2의 text 설정
//			}
//		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//Tiger t = new Tiger(btn1);
				Tiger t = new Tiger(Hello.this);
				t.start();

				// btn1.setVisible(false); //btn2를 누르면 btn1이 눈에 안보이게
				// btn1.setVisible(!btn1.isVisible()); //이렇게 하면 눈에 보이는지 확인 후 눈에 안보이게
				// btn1.setDisable(true); //btn2를 누르면 btn1을 비활성화(안눌러지게)
				// btn1.setDisable(!btn1.isDisable()); //이렇게 하면 비활성화인지 확인 후 비활성화
			}
		});
		root.getChildren().addAll(btn1, btn2);
		//-----------------------------------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		System.out.println(2);
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();
		System.out.println("end");
	}
}
*/


/*
//ex74-4) TextField, TextArea
public class Hello extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(1);
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		// -------------------------------------------------------------------
		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(1000);
			}
		});
		Button btn2 = new Button("버튼2");
		
		// TextArea(넓은 입력창)
		TextArea textArea = new TextArea();
		
		
		// TextField(한줄 입력창)
		TextField textField = new TextField();
		textField.setOnAction(new EventHandler<ActionEvent>() {	
			// textField에 text를 입력 후 Enter를 쳤을때마다 실행
			@Override
			public void handle(ActionEvent arg0) {
				// textfield에 있는 text 출력
				String s = textField.getText();
				System.out.println(s);
				textArea.appendText(s + "\n");
				textField.setText(""); // Enter칠때 textField reset시킴
			}
		});
		
		root.getChildren().addAll(btn1, btn2, textField, textArea);
		
		//-----------------------------------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("호랑이");
		arg0.show();
		System.out.println(2);
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch();
		System.out.println("end");
	}
}
*/
//2022.11.01






/*
//ex74-3)
public class Hello extends Application{
	// launch() 함수를 호출하면 start() 함수도 호출된다.
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(1);
		VBox root = new VBox(); // Vertical 배치(세로) //HBox=Horizontal 배치(가로)
		root.setPrefSize(400, 300); // 창 크기(size) 설정
		root.setSpacing(10); // button 사이에 거리(공백)를 만든다.
		// -------------------------------------------------------------------
		
//		<컨트롤의 종류>
//		Button, EditBox, InputBox, Radio, combobox, scrollbar, Progressbar 등등
//		<컨트롤 제어 종류>
//		1. 속성제어 : 대략 30가지
//		2. 액션 제어 : 이벤트, 메세지라고도 함(click 등)
		
		
		// 부모에게 컨트롤을 연결시키는 방법1
//		Button btn1 = new Button("버튼1");
//		root.getChildren().add(btn1); // 버튼이 생긴다.
//		Button btn2 = new Button("버튼2");
//		root.getChildren().add(btn2); // 버튼이 2개 생기고 vertical(세로)로 배치된다.
		
		
		// 부모에게 컨트롤을 연결시키는 방법2
		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			// 클릭 이벤트 처리
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(1000);
			}
		});
		Button btn2 = new Button("버튼2");
		root.getChildren().addAll(btn1, btn2); // 버튼 2개 생긴다.(한꺼번에)
		
		//
		Scene scene = new Scene(root);
		arg0.setScene(scene); // 어떤 창을 보이게 할건지 정해주기
		arg0.setTitle("호랑이"); // 창 제목 정해주기
		arg0.show();
		System.out.println(2);
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); // 블로킹 함수이다.
		System.out.println("end");
	}
}
*/





/*
//ex74-2)
public class Hello extends Application{
	// launch() 함수를 호출하면 start() 함수도 호출된다.
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(1);
		VBox root = new VBox(); // Vertical 배치(세로) //HBox=Horizontal 배치(가로)
		root.setPrefSize(400, 300); // 창 크기(size) 설정
		// -------------------------------------------------------------------
		
		// 디자인이 들어간다.
		
		//
		Scene scene = new Scene(root);
		arg0.setScene(scene); // 어떤 창을 보이게 할건지 정해주기
		arg0.setTitle("호랑이"); // 창 제목 정해주기
		arg0.show();
		System.out.println(2);
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); // 블로킹 함수이다.
		System.out.println("end");
	}
}
*/


/*
//ex74-1)
// 환경설정 경로(Run configurations)
// --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib"
// --add-modules=javafx.controls,javafx.fxml
//

public class Hello extends Application{
	// launch() 함수를 호출하면 start() 함수도 호출된다.
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(1);
		
		arg0.show();
		
		System.out.println(2);
	}
	public static void main(String[] args) {
		System.out.println("start");
		launch(); // 블로킹 함수이다.
		System.out.println("end");
	}
}
*/



/*
//ex73-4)
interface Test1{
	void f1();
}
// 사용1)
class Tiger implements Test1{
	@Override
	public void f1() {
		System.out.println(1);
	}
}

class Lion extends Thread{
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f1();
		
		// 사용2)
		Test1 t2 = new Test1() {
			@Override
			public void f1() {
				System.out.println(2);	
			}
		};
		t2.f1();
		
		// 사용3) 람다식
		Test1 t3 = () -> {
			System.out.println(3);
		};
		t3.f1();
		
		// 사용4) 익명 객체
		new Test1() {
			@Override
			public void f1() {
				System.out.println(4);	
			}
		}.f1();
		
		// 응용1
		Thread t5 = new Thread() {
			public void run() {
				System.out.println("thread start1");
				System.out.println("thread end1");
			}
		};
		t5.start();
		
		// 응용2
		new Thread() {
			public void run() {
				System.out.println("thread start2");
				System.out.println("thread end2");
			}
		}.start();
	}
}
*/




/*
//ex73-3)
interface Test1{
	void f1();
}
interface Test2{
	int f1();
}
class Tiger{
	void f2(Test1 t) {
		t.f1();
	}
	void f3(Test2 t) {
		System.out.println(t.f1());
	}
	Test1 f4() {
		return new Test1() {
			@Override
			public void f1() {
				System.out.println(444);
			}
		};
	}
	Test1 f5() {
		return () -> {
				System.out.println(555);
		};
	}
}
public class Hello {
	public static void main(String[] args) {
		Test1 t1 = () ->{
			System.out.println(1);
		};
		t1.f1();
		
		Tiger tiger = new Tiger();
		tiger.f2(new Test1() {
			@Override
			public void f1() {
				System.out.println(10);
				System.out.println(20);
				System.out.println(30);
			}
		});
		tiger.f2(()->{
			System.out.println(40);
			System.out.println(50);
			System.out.println(60);
		});
		
		tiger.f3(new Test2() {
			@Override
			public int f1() {
				return 888;
			}
		});
		
		tiger.f3(()->{
			return 999;
		});
		
		tiger.f3(()->1000);
		
		// --------------------------------
		Test1 t2 = tiger.f4();
		t2.f1();
		
		tiger.f5().f1();
	}
}
*/





/*
//ex73-2)
// interface 하나에 함수 하나만 있게 하는 annotation
@FunctionalInterface
interface Test1{
	void f1();
}
interface Test2{
	void f1(int num);
}
interface Test3{
	void f1(int num, String str);
}
interface Test4{
	int f1(); // return이 있는 함수
}
interface Test5{
	int f1(int num); // return이 있고 인수가 1개인 함수
}
public class Hello {
	public static void main(String[] args) {
		// 익명 클래스로 객체 생성
		Test1 t1 = new Test1() {
			@Override
			public void f1() {
				System.out.println("f1 call");
			}
		};
		t1.f1();
		
		
		// 람다 함수 기본형
		Test1 t2 = ()->{
			System.out.println("f2 call");
		};
		t2.f1();
		
		
		Test2 t3 = new Test2() {
			@Override
			public void f1(int num) {
				System.out.println(num + "입니다.");
			}
		};
		t3.f1(100);
		
		
		// 인수 전달이 1개일때만 ()를 생략할 수 있다. (인수0개 또는 2개이상일때는 생략X)
		// 거의 대부분의 프로그램에서는 ()를 생략한다.
		Test2 t4 = (num)->{
			System.out.println(num + "입니다.");
		};
		t4.f1(200);
		
		Test2 t41 = num->{
			System.out.println(num + "입니다.");
		};
		t41.f1(300);
		
		Test3 t5 = (n, s)->{
			System.out.println(n + s);
		};
		t5.f1(300, "홍길동");
		
		
		Test4 t6 = ()->{
			return 400;
		};
		System.out.println(t6.f1());
		
		// 단문장일때는 {} 와 return을 생략할 수 있다.(대신 생략하려면 {}와 return 동시에 둘다 생략해야됨)
		// 생략이 일반적이다.
		Test4 t7 = ()->500;
		System.out.println(t7.f1());
		
		// 약식의 의미를 가질때는 슈가 코드라고 한다(코드를 압축해서 간결해짐)
		Test5 t8 = n->n+600;
		System.out.println(t8.f1(700));
	}
}
*/


/*
//ex73-1) 람다 함수 : 함수적 프로그래밍
// ex1)
public class Hello {
	static 함수코드가리턴 func(함수코드를 받는다.) {
		return 함수코드;
	}
	public static void main(String[] args) {
		func(
				void f1() {System.out.println();}
		);
	}
}
*/


/*
//ex72-5)
// 입력 후에 블로킹이 연속적으로 일어날 수도 있고, 출력 후에 블로킹이 일어날 수도 있다.
// example input&output
//main start
//Tiger start
//Lion start
// >> 1
//Lion end
// >> 2
// >> 3
//Tiger end
//main end

class Lion extends Thread{
	public void run() {
		System.out.println("Lion start");
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); // << 블로킹 1
		System.out.println("Lion end");
	}
}
class Tiger extends Thread{
	public void run() {
		Thread t = new Lion();
		t.start();
		System.out.println("Tiger start");
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); // << 블로킹 2
		System.out.println("Tiger end");
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t = new Tiger();
		t.start();
		Scanner sc = new Scanner(System.in);
		sc.nextInt(); // << 블로킹 3
		
		System.out.println("main end");
	}
}
*/


/*
//ex72-4)
// 실행시킬때마다 결과값이 달라진다.
class Tiger extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("코끼리" + i);
			try {Thread.sleep(0);} catch (InterruptedException e) {}
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		Tiger t = new Tiger();
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("호랑이" + i);
			try {Thread.sleep(0);} catch (InterruptedException e) {}
		}
		
		System.out.println("main end");
		// cpu가 쉴 수 있는 가장 짧은 시간을 쉬세요.
		// try {Thread.sleep(1000);} catch (InterruptedException e) {}
	}
}
*/


/*
//ex72-3)
class Tiger extends Thread{
	@Override
	public void run() {
		System.out.println("thread start");
		System.out.println("run call");
		System.out.println("thread exit");
	}
}
public class Hello {
	public static void main(String[] args) {
		System.out.println("main start");
		Thread t = new Tiger();
		t.start();
		
		// Thread.sleep()은 한줄로 쓰는걸 추천
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		System.out.println("main end");
	}
//	 main start
//	 main end
//	 thread start
//	 run call
//	 thread exit
}
*/


/*
//ex72-2)
// Thread 클래스는 start 실행 시 run 메소드가 수행되도록 내부적으로 동작한다.
class Tiger extends Thread{
	@Override
	public void run() {
		System.out.println("run call");
	}
}

public class Hello {
	public static void main(String[] args) {
		Thread t = new Tiger();
		t.start();
	}
}
*/


/*
//ex72-1) Thread 기본예제
class A{
	void start() {
		System.out.println("start");
		run();
	}
	void run() {
		System.out.println("A run");
	}
}


class B extends A{
	void run() {
		System.out.println("B run");
	}
}
public class Hello {
	public static void main(String[] args) {
		A t = new B();
		t.start(); // start 함수가 어디있는가?(B class에 있는 것 호출)
	}
}
*/
//2022.10.31





/*
//ex71-2)
class A{
	int num = 30;
	int run() {
		System.out.println("A의 run Call");
		return num;
	}
}
class B extends A{
	A a;
	int num=20;
	B(A a) {
		this.a=a;
	}
	int run() {
		System.out.println("B의 run Call");
		return num + a.run();
	}
}
class C extends A{
	A a;
	int num=10;
	C(A a) {
		this.a=a;
	}
	int run() {
		System.out.println("C의 run Call");
		return num + a.run();
	}
}

// Decorator Pattern(데코레이터 패턴)
public class Hello {
	public static void main(String[] args) {
		A a = new A();
		a = new B(a); //a는 살아있는 객체다.(B class 안에 멤버 변수로 살아있다)
		// System.out.println(a.run()); //50
		a = new C(a);
		System.out.println(a.run());
	}
}
*/


/*
//ex71-1)
class A{}
class B extends A{}
class C extends A{}

public class Hello {
	public static void main(String[] args) {
		// upcasting
		// A t1 = new B();
		// A t2 = new C();
		A t1 = new B();

		t1 = new C(); // 새로운 객체 1개
		
		t1 = new B(); // 새로운 객체 1개

	}
}
*/


/*
//ex70) sample.txt의 내용 읽기(read)
public class Hello {
	public static void main(String[] args) {
		System.out.println("start");
		try {
			Reader r = new FileReader("sample.txt");
			
			// int java.io.Reader.read() throws IOException
			// 읽을 데이터가 파일에 없다라고 판단될때는 -1을 리턴한다.
			while(true) {
				int readData = r.read();
				if(readData == -1) {
					System.out.println("파일 끝까지 읽어서 탈출함");
					break;
				}
				System.out.print((char)readData);
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
}
*/


/*
//ex69) sample.txt에 체스판 그리기(write)
public class Hello {
	public static void main(String[] args) {
		int width = 8, height = 7;
//		int width = 7, height = 8;
		try {
			Writer w = new FileWriter("sample.txt");
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					w.write((i+j)%2==0 ? "O " : "X ");
				}
				w.write("\n");
			}
			w.close();
		} catch (IOException e) {e.printStackTrace();}
	}
}
*/


/*
//ex68) 파일 입출력
public class Hello {
	public static void main(String[] args) {
		System.out.println("start");
		// 왼쪽은 부모, 오른쪽은 자식(업캐스팅)
		try {
			// 파일을 오픈시킨다.
			Writer w = new FileWriter("sample.txt");
			w.write("apple"); //sample.txt에 apple이라는 텍스트를 쓴다
			w.write("\n");
			w.write("호랑이");
			w.close(); //까먹지 말것
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
*/



/*
//ex67)
public class Hello {
	public static void main(String[] args) {
		// 3 << 1 : 3 * 2^1
		// 3 << 2 : 3 * 2^2
		// 3 << 3 : 3 * 2^3
		// 3 << 4 : 3 * 2^4
		// 800(512 + 256 + 32)
		// 800 * y
		// (512 + 256 + 32) * y
		// y * 512 + y * 256 + y * 32
		// y * 2^9 + y * 2^8 + y * 2^5
		// y << 9 + y << 8 + y << 5
		int w = 800;
		int y = 321;
		// 아래의 두개의 식 중 위의 식보다 아래의 식이 더 계산 빠름
		System.out.println(w*y);
		System.out.println((y << 9) + (y << 8) + (y << 5));
		
		// 이렇게 해보면 더 자세히 속도 비교 가능
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 2000; j++) {
				System.out.println((y << 9) + (y << 8) + (y << 5));
			}
		}
	}
}
*/



/*
//ex66)
public class Hello {
	public static void main(String[] args) {
		//char 0x1101 0101;  // 2진수
		char data = 0x00D5;  // 16진수로 표현
		
		String[] ar = { "선풍기", "에어컨", "전자렌지", "라이디", 
				"티비", "드라이기", "컴퓨터", "냉장고"};
		
		char mask = 0x80;
		for (int i=0;i<8;i++) {
			int result = data & mask;
			mask >>= 1;
			// 방법1
//			if(result != 0) {
//				System.out.println(ar[i] + "는 On입니다");
//			}else {
//				System.out.println(ar[i] + "는 Off입니다");
//			}
			// 방법2
			System.out.println(
					ar[i] + (result !=0 ? "On" : "Off ") +
					"입니다.");
		}
		
		// 선풍기 	는 On입니다.
		// 에어콘 	는 On입니다.
		// 전자렌지 	는 Off입니다.
		// 라디오 	는 On입니다.
		// 티비		는 Off입니다.
		// 드라이기 	는 On입니다.
		// 컴퓨터		는 Off입니다.
		// 냉장고 	는 On입니다.
	}
}
*/


/*
//ex65)
public class Hello {
	static String hexaToBinary(int n) {
		String result = Integer.toBinaryString(n);
		
		while(result.length() < 32) {
			result = "0" + result;
		}
		StringBuffer result1 = new StringBuffer(result);
		for (int i = 0; i < 7; i++) {
			result1.insert((7-i)*4, " ");
		}
		return result1.toString();
	}
	
	public static void main(String[] args) {
		// ARGB // 2자리씩 차지 : A=3b(투명도), Red=12, Green=cd, Blue=59
		int num = 0x3b12cd59;
		// Red를 푸는 과정
		//        0x3b12cd59; // num
		//      & 0x00ff0000; // mask
		//        0x00120000; // result
		//  >> 16 0x00000012; // result >> 16
		System.out.println(hexaToBinary(num));						//num
		System.out.println(hexaToBinary(0x00ff0000));				//mask
		System.out.println(hexaToBinary(num & 0x00ff0000));			//result
		System.out.println(hexaToBinary((num & 0x00ff0000) >> 16));	//result >> 16
		
		int Alpha = (num & 0xff000000) >> 24;
		System.out.println(Alpha); //59
		
		int Red = (num & 0x00ff0000) >> 16;
		System.out.println(Red); //18
		
		int Green = (num & 0x0000ff00) >> 8;
		System.out.println(Green); //205
		
		int Blue = (num & 0x000000ff);
		System.out.println(Blue); //89
		
		int result2 = (Red << 16) | (Green << 8) | Blue;
		System.out.println(hexaToBinary(result2));
	}
}
*/


/*
//ex64) 비트 연산
public class Hello {
	static String hexaToBinary(int n) {
		String result = Integer.toBinaryString(n); //111011000100101100110101011001
		//System.out.println("1 : " + result.length());
		
		while(result.length() < 32) {
			result = "0" + result;
		}
		//System.out.println("2 : " + result);
		
		StringBuffer result1 = new StringBuffer(result); // StringBuffer는 갱신을 할수있다
		//System.out.println("3 : " + result1);
		
		for (int i = 0; i < 7; i++) {
			result1.insert((7-i)*4, " ");
		}
		//System.out.println("4 : " + result1); //0011 1011 0001 0010 1100 1101 0101 1001
		return result1.toString(); //StringBuffer를 String으로 변환해준다(return값이 String이므로)
	}
	
	public static void main(String[] args) {
		// 앞에 0x가 붙으면 뒤에는 16진수가 된다 / 0만 붙으면 뒤에는 8진수가 된다
		// 진법 : 2진법, 10진법, 16진법(개인적으로 익히기)
		// 16진법 : 0 1 2 3 4 5 6 7 8 9 A  B  C  D  E  F
		//                           10 11 12 13 14 15
		int num = 0x3b12cd59; //16진수를 2진수로 바꿔보자!
		// 이진수 : 11 1011 0001 0010 1100 1101 0101 1001
		// 끝에서부터 4자리씩 끊고 앞에 공백에 0채워넣기
		// 0011 1011 0001 0010 1100 1101 0101 1001
		String result = Integer.toBinaryString(num); //111011000100101100110101011001
		System.out.println(result);
		
		//직접 함수 만들어서 네자리씩 끊기
		System.out.println(hexaToBinary(num));
	}
}
*/


/*
//ex63-2) 제네릭 문법
// class 개수를 줄이는 건 아님(class는 사용할때마다 내부적으로 생성된다) - 보이는 코드길이만 줄어듦
class Tiger<T>{
	private T data;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data=data;
	}
}
public class Hello {
	public static void main(String[] args) {
		// Tiger<Integer> t = new Tiger<Integer>();
		Tiger<Integer> t1 = new Tiger<>();
		t1.setData(100);
		System.out.println(t1.getData());
		
		
		Tiger<String> t2 = new Tiger<>();
		t2.setData("호랑이");
		System.out.println(t2.getData());
		
		
		Tiger<Float> t3 = new Tiger<>();
		t3.setData(3.14f);
		System.out.println(t3.getData());
		
		LinkedList<String> mm = new LinkedList<>();
		
	}
}
*/


/*
//ex63-1) 제네릭이 필요한 이유를 설명한 코드
class Tiger{
	private int data;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data=data;
	}
}
class Lion{
	private String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data=data;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.setData(100);
		System.out.println(t.getData());
		
		Lion l = new Lion();
		l.setData("호랑이");
		System.out.println(l.getData());
	}
}
*/



/*
//ex62) annotation(@)
class A{
	void showMeTheMoney() {
		
	}
}

class B extends A{
	// @Override를 붙이는 이유(annotation)
	// : 이렇게 오타를 발생시키고 override를 하면 오류발생을 알려줌
//	@Override
//	void ShowMeTheMoney() {
//		System.out.println(2);
//	}
}

interface C{
	void f1();
}
class D implements C{
	// 코드 자동 완성을 이용하였다.(ctrl+space)
	@Override
	public void f1() {
		// TODO Auto-generated method stub
		
	}
}

public class Hello {
	public static void main(String[] args) {
		A a = new B();
		a.showMeTheMoney();
	}
}
*/


/*
//ex61) Collection
// CRUD(Create, Read, Update, Delete)에 맞게 알맞은 자료구조를 선택해서 사용해야함
// List(순서가 있음) - LinkedList, Stack, Vector, ArrayList
// Set(중복X) - HashSet, SortedSet-TreeSet
// Map(key:value) - Hashtable, HashMap, SortedMap-TreeMap

// LinkedList - 평균적으로 좋은 것, 추가, 삭제에 좋음, but 검색에 취약함
// 나머지는 각자 시간날때 해볼것!
// Queue Interface는 PriorityQueue, Deque, ArrayDeque

// Collection 중 LinkedList의 예시
public class Hello {
	public static void main(String[] args) {
		// <저장할 데이터 타입>
		// 반드시 클래스 타입만 가능하다.(LinkedList<int> 이런건 안됨)
		// LinkedList<Integer> mm = new LinkedList<Integer>();
		LinkedList<Integer> mm = new LinkedList<>();
		System.out.println(mm.size());
		
		// (Create)RUD
		mm.add(100);
		for (int i = 0; i < 10; i++) {
			mm.add(i*10+i);
		}
		System.out.println(mm.size() + "개 있다");
		
		// C(Read)UD
		// 방법1 : 활용성이 없다.(당장은 편하지만)
		System.out.println(mm);
		
		// 방법2 : 
		for (int i = 0; i < mm.size(); i++) {
			System.out.print(mm.get(i) + " ");
		}System.out.println();
		
		// 방법 : forEach :
		// i, data, x, value, item
		for (Integer value : mm) {
			System.out.print(value + " ");
		}System.out.println();
		
		int[] ar = {1, 2, 3};
		for (int value : ar) {
			System.out.print(value + " ");
		}System.out.println();
		
		System.out.println(mm.get(5));
		
		// CR(Update)D
		mm.set(5, 2022);
		System.out.println(mm);
		
		// CRU(Delete)
		mm.remove(4);
		System.out.println(mm);
		
		// C : create, insert, add
		// R : read, select, get
		// U : update, set
		// D : delete, remove, erase, clear
	}
}
*/
//2022.10.28


/*
//ex60) String
public class Hello {
	public static void main(String[] args) {
		String s = "무궁화꽃이피었습니다";
		
		// 1) 문자열 길이
		System.out.println(s.length()); //10
		
		// 2) 해당 인덱스의 문자
		System.out.println(s.charAt(3)); //꽃
		
		// 3) 해당 문자열의 시작인덱스(정확하게 일치하는 문자열이 포함되어있을때만)
		System.out.println(s.indexOf("궁화")); //1
		System.out.println(s.indexOf("나무")); //-1(포함X)
		if(s.indexOf("나무")==-1) {
			System.out.println("not found");
		}else {
			System.out.println("find");
		}
		
		// 4) 해당 문자열1을 해당 문자열2로 대체해서 출력함(단, 원본은 안바뀜)
		System.out.println(s.replace("꽃이", "나무가")); //무궁화나무가피었습니다
		System.out.println(s); //무궁화꽃이피었습니다
		String newString = s.replace("꽃이", "식물이");
		System.out.println(newString); //무궁화식물이피었습니다
		
		// 5) 해당 인덱스부터 끝까지 자른다(끝범위도 지정 가능)
		System.out.println(s.substring(3)); //꽃이피었습니다
		System.out.println(s.substring(3, 5)); //꽃이
		//(a, b) >> a부터 b-1까지
		
		
		// 그 외 String 클래스 메소드(실습)
		// 문자열에 이어붙이기(원본이 바뀌진 않음)
		System.out.println(s.concat("안녕")); //무궁화꽃이피었습니다안녕
		System.out.println(s); //무궁화꽃이피었습니다
		
		// 문자열에 해당 문자열이 포함되어있는지 true/false로 출력
		System.out.println(s.contains("궁")); //true
		System.out.println(s.contains("안")); //false
		
		// 문자열이 해당 문자열로 끝나는지 true/false로 출력
		System.out.println(s.endsWith("다")); //true
		System.out.println(s.endsWith(".")); //false
		
		// 문자열이 해당 문자열과 완전히 같은지 true/false로 출력
		System.out.println(s.equals("무궁화꽃이피었습니다")); //true
		System.out.println(s.equals("무궁화")); //false
		
		// 해당 문자열이 빈 문자열인지 true/false로 출력
		System.out.println(s.isEmpty()); //false
		System.out.println("".isEmpty()); //true
		
		// 문자열을 해당 문자열로 완전히 대체함(원본은 바뀌지 않음)
		System.out.println(s.replaceAll(s, "안녕")); //안녕
		System.out.println(s); //무궁화꽃이피었습니다
		
		// 문자열을 해당 문자열을 기준으로 나눠준다(원본은 바뀌지 않음)
		System.out.println(s.split("이")[0]); //무궁화꽃
		System.out.println(s.split("이")[1]); //피었습니다
		System.out.println(s); //무궁화꽃이피었습니다
		
		// 문자열을 소문자, 대문자로 바꿔준다(원본은 바뀌지 않음)
		String str = "aBcDefgH";
		System.out.println(str.toLowerCase()); //abcdefgh
		System.out.println(str.toUpperCase()); //ABCDEFGH
		System.out.println(str); //aBcDefgH
		
		// 문자열의 왼쪽, 오른쪽 공백을 제거해준다(가운데 공백들은 제거X)
		String str2 = " a b  c   d ";
		System.out.println(str2.trim()); //a b  c   d
	}
}
*/

/*
//ex59) Scanner(입력)
public class Hello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		System.out.println("입력된 숫자는 : " + num + "입니다.");
	}
}
*/


/*
//ex58) Thread.sleep()
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		
		for (int i = 0; i < 5; i++) {
			
			// 특정 조건 만족한 이후에 함수실행을 끝내는 이러한 함수를
			// 블로킹함수.
			try {Thread.sleep(3000);} catch (InterruptedException e) {}
			System.out.println(i*10);
		}
		
		System.out.println(2);
	}
}
*/


/*
//ex57)
class Tiger{
	void f1() {
		System.out.println(1);
		
		try {
			throw new Exception();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 이 함수를 호출한 게 Exception을 catch함
	void f2() throws Exception{
		System.out.println(2);
		throw new Exception();
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.f1();
		
		// Unhandled exception type Exception
		try {
			t.f2();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
*/


/*
//ex56) 예외처리(exception)
public class Hello {
	public static void main(String[] args) {
		
		// 1. Arithmetic Exception
		try {
			System.out.println(4/0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. ArrayIndexOutOfBoundsException
		int[] ar = new int[3];
		try {
			ar[3] = 10;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. NullPointerException
		String str = null;
		try {
			System.out.println(str.length());			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("무궁화꽃이피었습니다.");
	}
}
*/


/*
//ex55) 삼항연산
public class Hello {
	public static void main(String[] args) {
		
		// ex1
		int num1;
		if(true) {
			num1 = 10;
		}else {
			num1 = 20;
		}
		
		num1 = true ? 10 : 20;
		
		// ex2
		if (true) {
			System.out.println("호랑이");
		}else {
			System.out.println("코끼리");
		}
		
		System.out.println(true ? "호랑이" : "코끼리");
		
		Tiger t = new Tiger();
		t.f1(3, 4);
		
		
		// 우박수 문제(삼항연산자로 표현)
		int num=1234567;
		while(true) {
			System.out.println(num);
			num = (num%2==0) ? num/2 : num*3+1;
			
			if(num==1) {
				System.out.println(num);
				break;
			}
		}

	}
}
class Tiger{
	int f1(int a, int b) {
//		if(a > b) {
//			return 1000;
//		}else {
//			return 2000;
//		}
		return a > b ? 1000 : 2000;
	}
}
*/


/*
//ex54)
interface Animal{
	abstract void cry();
}
class Dog implements Animal{
	public void cry() {System.out.println("멍멍");}
}
class Cat implements Animal{
	public void cry() {System.out.println("야옹");}
}
public class Hello {
	public static void main(String[] args) {
		Animal t = new Dog();
		t.cry();
	}
}
*/

/*
//ex53)
class Animal{
	void cry() {System.out.println("잉잉");}
}
class Dog extends Animal{
	void cry() {System.out.println("멍멍");}
}
class Cat extends Animal{
	void cry() {System.out.println("야옹");}
}
class Snake extends Animal{
	// cry() 구현없으면 부모를 따른다.
}
public class Hello {
	public static void main(String[] args) {
//		Dog t1 = new Dog();
//		Cat t2 = new Cat();
//		Snake t3 = new Snake();
//		
//		for (int i = 0; i < 5; i++) {
//			switch (new Random().nextInt(3)) {
//			case 0: t1.cry(); break;
//			case 1: t2.cry(); break;
//			case 2: t3.cry(); break;
//			default: break;
//			}			
//		}
//		int a, b, c;
//		int[] ar = new int[3];
//		Animal[] ani = new Animal[3];
//		ani[0] = new Dog();
//		ani[1] = new Cat();
//		ani[2] = new Snake();
		
		
// 		위의 코드와 동일한 코드이다.(이렇게 줄일수있다.)
		Animal[] ani = new Animal[] { new Dog(), new Cat(), new Snake()};
		for (int i = 0; i < 5; i++) {
			ani[new Random().nextInt(3)].cry();			
		}
	}
}
*/


/*
//ex52)업캐스팅을 하는 이유
class Animal{
	void cry() {
		System.out.println("잉잉");
	}
}
class Dog extends Animal{
	void cry() {
		System.out.println("멍멍");
	}
}
class Cat extends Animal{
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal{
	// cry() 구현없으면 부모를 따른다.
}
class Zoo{
	// 1. upcasting을 하게 되면 이렇게 하나만으로 모든 cry() 동작을 할 수 있다
	// Animal ani = new Dog(), new Cat(), new Snake()
	void sound(Animal ani) {
		ani.cry();
	}
	
	
	// 2. upcasting을 안하게 되면 이렇게 동물이 추가될때마다 cry()를 추가해야함
	void sound(Dog dog) {
		dog.cry();
	}
	void sound(Cat cat) {
		cat.cry();
	}
	void sound(Snake snake) {
		snake.cry();
	}
}
public class Hello {
	public static void main(String[] args) {
		Animal t1 = new Dog();
		Animal t2 = new Cat();
		Animal t3 = new Snake();
		t1.cry();
		t2.cry();
		t3.cry();
		System.out.println("--------------------");
		
		Dog t4 = new Dog();
		Cat t5 = new Cat();
		Snake t6 = new Snake();
		t4.cry();
		t5.cry();
		t6.cry();
		System.out.println("--------------------");
		
		Zoo zoo = new Zoo();
		zoo.sound(new Dog());
		zoo.sound(new Cat());
		zoo.sound(new Snake());
	}
}
*/


/*
//ex51) 다형성(업캐스팅)
// 클래스의 결과나 인터페이스나 동일하다.
class A{
	void f1() {
		System.out.println(1);
	}
	void f2() {
		System.out.println(2);
	}
	void f3() {
		System.out.println("f3 call");
		f4(); // 자식꺼에도 있으면 부모꺼가 아닌 자식꺼를 실행시킨다.
	}
	void f4() {
		System.out.println("부모 f4");
	}
}
class B extends A{
	void f2() {
		System.out.println(3);
	}
	void f4() {
		System.out.println("자식 f4");
	}
}
public class Hello {
	public static void main(String[] args) {
		// 부 = 자
		A t = new B();
		t.f1();
		t.f2();
		t.f3();
	}
}
*/



/*
//ex50) 다형성
class A{
	void f1() {}
}

class B extends A{
	void f2() {}
}

public class Hello {
	public static void main(String[] args) {
		// 좌변은 문법 구사 / 우변은 할당메모리를 의미함
		// 상속과는 무관하다.
		A t1 = new A();
		t1.f1();
		
		
		// up casting(업캐스팅)
		A t2 = new B(); //문법적으로는 A만, 할당된 메모리는 둘다(가능)
		t2.f1();
		
		
		// 자바에서 지원하지 않는다.(다운캐스팅)
//		B t3 = new A(); // 문법적으로는 A,B 둘다, 할당된메모리는 A만(오류)
		
		
		// 자식것을 보고 없으면 부모것을 살펴본다.
		B t4 = new B();
		t4.f1();
		t4.f2();
	}
}
*/

/*
//ex49-2)
class A {void f1() {System.out.println(1);}}
interface B{void f2();}
interface C{void f3();}
class D extends A implements B, C{
	public void f2() {System.out.println(2);}
	public void f3() {System.out.println(3);}
}
public class Hello {
	public static void main(String[] args) {
		D t = new D();
		t.f1();
		t.f2();
		t.f3();
		
		StringBuffer sb;
	}
}
*/


/*
//ex49-1)
interface A{
	void f1();
}
interface B{
	void f2();
}
class C implements A, B{
	public void f1() {System.out.println(1);}
	public void f2() {System.out.println(2);}
}
public class Hello {
	public static void main(String[] args) {
		C t = new C();
		t.f1();
		t.f2();
	}
}
*/


/*
//ex48)
// abstract : 클래스이기 때문에 다중상속을 할 수 없다.
// interface 동일한 조건일때는 interface를 선택(다중상속을 할 수 있다.)
interface Tiger{
	abstract void f1();
	void f2();
}
class Lion implements Tiger{
	// interface에 있는 것을 구현한 함수는 반드시 public 이어야 한다.
	public void f1() {	System.out.println(1);}
	public void f2() {	System.out.println(2);}
}
public class Hello {
	public static void main(String[] args) {
		Lion t = new Lion();
		t.f1();
		t.f2();
	}
}
*/

/*
//ex47)
abstract class 대장장이{
	void 칼() {
		System.out.println("칼 만듦");
	}
	abstract void 방패();
}
class 병사1 extends 대장장이{
	void 방패() {
		System.out.println("드래곤이빨 방패 구해서 사용함");
	}
}
class 병사2 extends 대장장이{
	void 방패() {
		System.out.println("나무 방패 구해서 사용함");
	}
}
public class Hello {
	public static void main(String[] args) {
		병사1 t1 = new 병사1();
		t1.칼();
		t1.방패();
		병사2 t2 = new 병사2();
		t2.칼();
		t2.방패();
	}
}
*/

/*
//ex46)
abstract class Tiger{
	// 추상 함수이다.
	// 추상 함수를 1개라도 가지는 클래스는 반드시 추상 클래스이어야 한다.
	abstract void f1(); // 미완성코드(abstract : 추상)
	
	// 완성된 코드
	void f2() {
		System.out.println(1);
	}
}

// 상속받은 자식은 반드시 부모의 미완성코드를 완성해야 한다.
// 오버라이드(override) 문법을 이용해서
class Lion extends Tiger{
	void f1() {
		System.out.println(2);
	}
}

public class Hello {
	public static void main(String[] args) {
		// 추상 클래스는 객체 생성을 할 수 없다.
		// Tiger t = new Tiger();(X)
		Lion t = new Lion();
		t.f1();
		t.f2();
	}
}
*/

/*
//ex45)
// 자식은 부모이다.
// 사자는 호랑이이다.(X)
// 사자는 동물이다.(O) (is a)
class Tiger{}
class Animal{}
class Lion extends Animal{}

// 자식은 부모것을 가지고 있다.
// 경찰은 무기를 가지고 있다. (has a)
class Weapon{}
class Police extends Weapon{}


public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
	}
}
*/


/*
//ex44) 다형성(polymorphism)
// n차 상속이 가능하다. 다중상속은 불가.
//f4키 누르면 상속계층도를 볼 수 있다.
class A{void f1() { System.out.println(1); }}
class B extends A{void f2() { System.out.println(2); }}
class C extends B{void f3() { System.out.println(3); }}
class D extends C{void f4() { System.out.println(4); }}
class F extends A{void f5() { System.out.println(5); }}

class G extends Object{
	
}

public class Hello {
	public static void main(String[] args) {
		D t1 = new D();
		t1.f4(); //f1() f2() f3() f4()
		
		F t2 = new F();
		t2.f5(); //f1() f5()
		
		String s;
		System.out.println(t2.hashCode());
	}
}
*/


/*
//ex43) 상속 : 기존클래스가 가지고 있는 기능을 확장하는 것이다.
// 단일 책임의 원칙 : 객체지향프로그램 개발의 5대 원칙중 1개
// <SOLID원칙>
// S 단일 책임 원칙 : 한 클래스는 하나의 기능만 가지는 원칙
// O 개방 폐쇄 원칙 : 확장에는 열려있으나 수정에는 닫혀있어야 한다
// L 리스코프 치환 원칙 : 상위타입은 반드시 하위 타입으로 대체할 수 있어야 한다
// I 인터페이스 분리 원칙 : 인터페이스 내에 메소드는 최소한일 수록 좋다
// D 의존관계 역전 원칙 : 구체적인 클래스보다 추상클래스나 인터페이스에 의존해야 한다
// 부모클래스
class Tiger{
	void f1() {
		System.out.println(1);
	}
	void f3() {
		System.out.println(31);
	}
}
// 자식클래스()
class Lion extends Tiger{
	void f2() {
		System.out.println(2);
	}
	void f3() { // override(부모클래스와 자식클래스에 있는 메소드가 동일할 때)
		System.out.println(32);
	}
	void f4() {
		//this.f3(); //자식 본인
		super.f3(); //부모
	}
}
// 윗 클래스를 확장해서 사용하세요. 기존기능 + 알파
public class Hello {
	public static void main(String[] args) {
		Lion t = new Lion();
		t.f1();
		t.f2();
		t.f3(); //부모클래스와 자식클래스에 있는 메소드가 동일할 때 자식꺼 호출
		t.f4();
	}
}
*/

/*
//ex42)
class Tiger{
	Lion f1(int a, String s, Tiger t, Lion l) {
		// return l;
		return new Lion();
	}
}
class Lion{
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.f1(10, "호랑이", new Tiger(), new Lion());
	}
}
*/

/*
//ex41-4) this 용법4
class Tiger{
	int money=500;
	void f1() {
		System.out.println("tiger f1 call");
		Lion lion = new Lion();
		lion.merry(this); // this == t
	}
	void f3() {
		System.out.println("tiger f3 call");
	}
}
class Lion{
	void merry(Tiger t) {
		if (t.money > 600) {
			System.out.println("ok");
		}else {
			System.out.println("ng");
		}
		System.out.println("lion f2 call");
		t.f3();
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.f1();
	}
}
*/
//2022.10.27


////////////////////////////////////////////////
//ex 41-3) this 용법3
//class Tiger {
//	int x, y;
//	Tiger() {
//		System.out.println(1);
//	}
//
//	Tiger(int a) {
//		this(); // this 생성자 메서드는 첫 줄에 있어야 한다
//		x = a * 33;
//		System.out.println(2);
//	}
//
//	Tiger(int a, int b) {
//		this(a);
//		y = b;
//		System.out.println(3);
//	}
//}
//
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t = new Tiger(10, 20);
//		System.out.println(t.x + " " + t.y);
//	}
//}

//ex 41-2) this 용법2-2
//class Tiger {
//	Tiger f1() {
//		System.out.println("아침먹고");
//		return this;
//	}
//	Tiger f2() {
//		System.out.println("점심먹고");
//		return this;
//	}
//	Tiger f3() {
//		System.out.println("저녁먹고");
//		return this;
//	}
//}
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t = new Tiger();
//		// 체이닝 기법을 사용하는 이유는 코드의 난입을 막는 목적
//		t.f1().f2().f3();
//		
//		// 한 세트 개념이 아니다
//		t.f1();
//		t.f2();
//		t.f3();
//		
//		// 중간에 연관이 없는 코드가 난입했다
//		t.f1();
//		System.out.println("잔다.");
//		t.f2();
//		t.f3();
//	}
//}

//ex41-2) this 용법2-1
//함수 호출 체이닝을 위해서 사용된다
//class Tiger {
//	Tiger f1() {
//		System.out.println(this.hashCode());
//		return this;
//	}
//	Tiger f2() {
//		System.out.println("f2 call");
//		return this;
//	}
//	void f3() {
//		System.out.println("f3 call");
//	}
//}
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t = new Tiger();
//		System.out.println(t.hashCode());
//		Tiger t2 = t.f1();
//		System.out.println(t2.hashCode());
//		System.out.println("-------------------------------------------------");
//		
//		Tiger tiger = new Tiger();
//		// chaining 기법
//		tiger.f1().f1().f1().f2().f2().f2().f2().f2().f2().f3();;
//	}
//}

//ex41-1) this 용법1
//생성자 함수의 인수명과 필드명을 구분하기 위하여 사용한다
//class Tiger {
//	String name;
//	int age;
//
//	Tiger() {
//	}
//	Tiger(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "Tiger [name=" + name + ", age=" + age + "]";
//	}
//}
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t = new Tiger("홍길동", 20);
//		System.out.println(t.toString());
//	}
//}

/*
//ex40) this 정의
//this : new를 이용해서 생성된 객체를 공유하는 변수 
class Tiger {
	int num = 10;
	Tiger() {
		// this = t; 공유가 되었다
		System.out.println(this.hashCode());
	
		//this.num = 20;
		num = 20;
	}
	
	void f1() {
	}
	void f2() {
		this.f2();
	}
}

public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		System.out.println(t.hashCode());
		t.num = 20;
		
		// 참조 변수 t,t2가 가르키는 객체가 다르다
		Tiger t2 = new Tiger();
	}
}
*/

//ex39) this 예시
//class Tiger {
//	String name;
//	int age;
//	
//	Tiger() {
//	}
//	Tiger(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//	
//	@Override
//	public String toString() {
//		return "Tiger [name=" + name + ", age=" + age + "]";
//	}
//}
//
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t = new Tiger("호랑이", 10);
//		System.out.println(t.toString());
//	}
//}

//ex 38) 인수전달 생성자
//class Tiger {
//	String name;
//	int age;
//
//	Tiger() {
//		name = "홍길동";
//		age = 20;
//	}
//
//	Tiger(String n, int a) {
//		name = n;
//		age = a;
//	}
//
//	void showData() {
//		System.out.println(name + " " + age);
//	}
//
//	@Override
//	public String toString() {
//		return "Tiger [name=" + name + ", age=" + age + "]";
//	}
//}
//
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t1 = new Tiger();
//		t1.showData();
//		System.out.println(t1.toString());
//
//		// 인수 전달 생성자를 만들지 않으면 생성되는 모든 객체는 같은 값을 가진다
//		Tiger t2 = new Tiger();
//		t2.showData();
//
//		Tiger t3 = new Tiger("호랑이", 40);
//		t3.showData();
//	}
//}

//ex37) 기본생성자 
////class Tiger {
////	
////}
////class Tiger {
////	Tiger() {
////	}
////}
////위 두 코드는 동일한 코드이다
////생성자가 없으면 기본 생성자를 자동으로 만들어 준다
////만약 생성자를 만들게 된다면 기본 생성자를 만들지 않는다
//class Tiger {
//	Tiger() {
//	}
//	Tiger(int num) {
//	}
//}
//
//public class Hello {
//	public static void main(String[] args) {
//		// 객체는 생성될 때 무조건 생성자를 호출한다
////		Tiger t = new Tiger();
////		System.out.println(1);
//
//		// 기본 생성자가 없기 때문에 에러가 발생한다
//		// 그래서 원칙적으로 기본 생성자를 그냥 만들어준다
//		Tiger t = new Tiger();
//		System.out.println(1);
//	}
//}

//ex36 클래스 - 생성자 
//class Tiger {
//	// 1. 생성자 : 생성자 함수
//	// 2. 생성자도 함수이기 때문에 오버로딩이 가능
//	// 3. 함수이름이 반드시 클래스 이름과 동일해야 한다
//	// 4. 인수전달을 할 수 있지만 리턴값을 가질 수 없다
//	// 5. 목적은 멤버변수초기화가 유일한 목적
//	// 6. 객체가 생성(new)될 때 자동 호출이 되고 임의로 호출할 수 없다
//	
//	// 기본 생성자
//	Tiger() { 
//		System.out.println("생성자 콜1");
//	}
//	Tiger(int num) {
//		System.out.println("생성자 콜2");
//	}
//	void f1() {
//		System.out.println("f1 call");
//	}
//	void f2() {
//		// 스스로 자신의 클래스 타입으로 객체를 만들 수 있는가 ? YES
//		Tiger t = new Tiger();
//		// 사용하는 주체가 다르다
//		t.f1();
//		f1();
//	}
//}
//
//public class Hello {
//	public static void main(String[] args) {
//		System.out.println(1);
//		Tiger t = new Tiger();
//		System.out.println(2);
//		Tiger t2 = new Tiger(100);
//		System.out.println(3);
//	}
//}

////ex35) main 메서드
//public class Hello {
//	// 생성자를 가질 수 있다
//	// 필드를 가질 수 있다
//	// 메서드를 가질 수 있다
//	int count = 100;
//	void f1() {
//		
//	}
//	void f2() {
//		System.out.println(count);
//		f1();
//	}
//	static void f3() {
//		System.out.println("f3");
//	}
//	
//	// main()에 static이 없으면 따로 Hello 객체를 생성해야 한다
//	public static void main(String[] args) {
//		// static 안에서는 static만 사용할 수 있다
////		System.out.println(count); 
////		f1();
//		f3();
//		Hello h = new Hello();
//		h.f1();
//		h.f3();
//		
//	}
//}


/*
//ex34) static : 정적(고정)!= 동적(dynamic)
//static은 처음부터 메모리에 존재한다 (객체를 생성해서 사용할 필요가 없다)
//static은 속도와 연관 (객체를 생성하는 데 오랜 시간이 소요되기 때문)
class Tiger {
	static int count;
	
	static void f1() {
		System.out.println("call 1");
	}
	
	void f2() {
		System.out.println("call 2");
	}
	
	void f3() {
		f2(); // 인스턴스 메서드는 인스턴스 메서드를 호출할 수 있다
		System.out.println("call 3");
	}
	
	static void f4() {
		// static 메서드 안에서는 static 멤버만 사용할 수 있다
		// f2(); // static 메서드는 인스턴스 메서드를 호출할 수 없다 (객체가 생성됬는지 모르기 때문)
		f1();
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger.f1();
		Tiger t = new Tiger();
		t.f2(); // 인스턴스 메서드는 객체를 생성한 이후 사용할 수 있다
		t.f1(); // 객체를 생성해서 static메서드도 사용할수는 있다
		
		// abs() 역시 static 메서드(정수 절댓값 계산)
		System.out.println(Math.abs(-100));
		// 객체를 생성할 수 없는 이유는 Math클래스의 생성자가 private로 되어있기 때문이다
		// Math m = new Math();
		System.out.println(Math.PI);
		System.out.println("----------------------------------------------------------");
		t.f3();
	}
}
*/


//ex33) 오버로딩
//class Tiger {
//	// 오버로딩 규칙
//	// 1. 전달되는 인수의 개수가 다를 때
//	// 2. 인수의 개수가 같더라도 인수타입이 다를 때
//	void show() {
//		System.out.println(1);
//	}
//
//	void show(int num) {
//		System.out.println(2);
//	}
//
//	void show(int a, int b) {
//		System.out.println(3);
//	}
//
//	void show(short num) {
//		System.out.println(4);
//	}
//}
//
//class Point {
//	int x, y;
//}
//class Rect {
//	// int width, heigh;
//	int getArea(int w, int h) {
//		return w * h;
//	}
//	int getArea(Point s, Point e) {
//		int w = e.x - s.x;
//		int h = e.y - s.y;
//		return w * h;
//	}
//	int getArea(int x1, int y1, int x2, int y2) {
//		int w = x2 - x1;
//		int h = y2 - y1;
//		return w * h;
//	}
//}
//public class Hello {
//	public static void main(String[] args) {
//		Tiger t = new Tiger();
//		t.show();
//		t.show((int) 1);
//		t.show(2, 3);
//		t.show((short) 4);
//		Rect r = new Rect();
//		System.out.println(r.getArea(3, 4));
//		System.out.println(r.getArea(3, 4, 6, 8));
//		Point p1 = new Point();
//		Point p2 = new Point();
//		p1.x = 3; 
//		p1.y = 4; 
//		p2.x = 8; 
//		p2.y = 9; 
//		
//		System.out.println(r.getArea(p1, p2));
//	}
//}
////////////////////////////////////////////////


/*
//ex32)
class Lion{
	void cry() {
		System.out.println("어흥");
	}
}
class Tiger{
	String f1() {
		//String 타입의 클래스 객체가 리턴된다.
		return "호랑이";
	}
	Lion f2() {
		Lion lion = new Lion();
		return lion; // lion >> 확보받은 메모리
	} // Lion형으로 return
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		System.out.println(t.f1());
		Lion l = t.f2(); // 공유되었다.
		l.cry();
	}
}
*/

/*
//ex31)
class Lion{
	void cry() {
		System.out.println("어흥");
	}
}
class Tiger {
	// int a = 10, String b = "호랑이", ch = '책'
	// String으로 인수 전달 받았다는 것은 클래스로 전달 받았다.
	void func(int a, String b, char ch, Lion lion) {
		System.out.println(a + b + ch);
		System.out.println("2 : " + lion.hashCode()); // 동일한 객체
		lion.cry();
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		Lion l = new Lion();
		System.out.println("1 : " + l.hashCode());
		t.func(10, "호랑이", '책', l);
	}
}
*/


/*
//ex30)
class Tiger{
	int func() {
		return 100;
	}
	void test() {
		
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		
		// 1. 버린다.
		t.func();
		
		// 2. 변수로 받아서 사용
		int num=t.func();
		System.out.println(num*10);
		
		// 3. 바로 출력으로 연결.
		System.out.println(t.func());
		
		// 출력으로 연결시킬수없다.
//		System.out.println(t.test());
	}
}
*/

/*
//ex29)
class Tiger{
	// void f1()만 함수 원형(prototype)
	//1
	void f1() {
		System.out.println(1);
	}
	//2
	void f2(int a) { // 인수 전달은 1개 이상 할 수 있다.
		System.out.println(2);
	}
	//3
	int f3() { // 리턴은 1개만 할 수 있다.
		System.out.println(3);
		return 0;
	}
	//4
	int f4(int a) {
		System.out.println(4);
		return 0;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.f1();
		t.f2(10);
		t.f3();
		t.f4(0);
	}
}
*/


/*
//ex28)
class Person {
	// 필드는 외부에 오픈시키지 않는다.
	// 데이터 은닉
	private String name="홍길동";
	private int age=20;
	
	public void setName(String n) {
		this.name=n;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Person p1=new Person();
		p1.setName("강길동");
		System.out.println(p1.getName());
		
		// 이렇게 쓰면 안된다.
		//p1.name="강길동";
		//p1.age=30;
		//System.out.println(p1.name + " " + p1.age);
	}
}
*/


/*
//ex27)
class Tiger{
	int num;
	float count;
	String str;
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		t1.num=10;
		t1.count=20.0f;
		t1.str="호랑이1";
		System.out.println(t1.num);
		
		t2.num=30;
		t2.count=40.0f;
		t2.str="호랑이2";
		System.out.println(t2.num);
	}
}
*/



/*
//ex26) 클래스
//클래스의 3대요소 : 생성자, 필드, 메소드
//GOF의 디자인 패턴
// 1. 파일 1개당 클래스 1개가 원칙이다.
// 2. 파일명은 클래스명과 동일하게 하는게 원칙이다.
// 3. 클래스명의 첫자는 대문자, 파일명의 첫자는 소문자
// 4. 1개의 파일에 여러개의 클래스가 들어갈 수 있는데
// 		반드시 1개만 public 이어야 한다.
// 5. Person 설계도이다.
//	1. 생성자
//	2. 필드(field) >> 변수
//	3. method     >> 함수(function)
// 6. 객체 생성 방법
// Person person = new Person();
class Person{
	
}
public class Hello {
	public static void main(String[] args) {
		// new는 메모리를 사용하는 것이다.
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		
		//서로 다른 이름으로 객체를 공유했다.
		//서로 다른 이름으로 객체를 참조(reference)했다.
		//사회 : 홍길동, 집 : 곰돌이
		Person p4=p1;
		System.out.println(p4.hashCode());
		
		// 메모리 반납코드가 있어야 하는 것이 원칙인데
		// 자바는 사용하지 않는다고 판단이 되면 자동 반납이다.
		// 자바가 메모리를 가비지 콜렉션을 한다.
		
	}
}
*/
// 2022.10.26







/*
//ex25) random 세로 더하기
import java.util.Random;
public class Hello {
	public static void main(String[] args) {
		Random rn = new Random();
		int[][] arr = new int[3][4];
		int[] sum = new int[4];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = rn.nextInt(10);
			}
		}
		// 원본 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		
		// 덧셈하고 출력
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				sum[j] += arr[i][j];
			}
			System.out.print(sum[j] + " ");
		}
	}
}
*/


/*
//ex24) random
import java.util.Random;
public class Hello {
	public static void main(String[] args) {
		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			// ex1)
			// +- 20억 사이의 숫자를 랜덤하게 얻는다.
			// int num = rn.nextInt();
			// System.out.println(num);
			
			// ex2)
			// 0~9
			// 0 <= x < 10
			System.out.print(rn.nextInt(10) + " ");
		}System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(new Random().nextInt(100) + " ");
		}System.out.println();
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				int num = rn.nextInt(10);
				System.out.print(rn.nextInt(10) + " ");
			}System.out.println();
		}
	}
}
*/



/*
//ex23)
public class Hello {
	public static void main(String[] args) {
		int[] arr = new int[3];
		int[][] brr = new int[5][3]; // [세로길이][가로길이]
		int[][][] crr = new int[2][5][3]; // [세로길이][가로길이]
		System.out.println("test1 : " + brr.length);
		System.out.println("test2 : " + brr[0].length);
		
		for (int i = 0; i < brr.length; i++) {
			for (int j = 0; j < brr[0].length; j++) {
				brr[i][j] = i*brr[0].length+j;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%3d", brr[i][j]);
			}System.out.println();
		}
	}
}
*/


/*
//ex22)
class Tiger{
	
}
public class Hello {
	public static void main(String[] args) {
//		String s2=new String("호랑이");
//		Tiger t1=new Tiger();
		
		String[] t1   =new String[3];
		Tiger[] t2    =new Tiger[3];
		
		String[] t31  =new String[] {new String("호"), new String("랑")};
		String[] t32  =new String[] {"호", "랑"};
		Tiger[] t4    =new Tiger[] {new Tiger(), new Tiger()};
		
		String[] t51  ={new String("호"), new String("랑")};
		String[] t52  ={"호", "랑"};
		Tiger[] t6    ={new Tiger(), new Tiger()};
		
		// 클래스 : String
		// 클래스
		// 객체지향프로그래밍
	}
}
*/





/*
//ex21)
class Tiger {
	void f1() {
		System.out.println("call");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger[] arr = new Tiger[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Tiger();
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i].f1();
		}
		
		Tiger[] brr=new Tiger[] {
				new Tiger(), 
				new Tiger(), 
				new Tiger()
		};
		for (Tiger obj : brr) {
			obj.f1();
		}
		Tiger[] crr=new Tiger[] {
				new Tiger(), 
				new Tiger(), 
				new Tiger()
		};
	}

}
*/




/*
//ex20)
public class Hello {
	public static void main(String[] args) {
		String[] arr=new String[4];
		
		arr[0]=new String("앵무새0");
		arr[0]="앵무새0";
		
		arr[1]="앵무새1";
		arr[2]="앵무새2";
		arr[3]="앵무새3";
		String[] brr=new String[] {
			new String("호랑이"), 
			"코끼리", 
			"독수리"};
		String[] crr={"호랑이1", "코끼리1", "독수리1"};
		System.out.println(arr[2]);
		for (int i = 0; i < brr.length; i++) {
			System.out.print(brr[i] + " ");
		}System.out.println();
		for (String value : crr) {
			System.out.print(value + " ");
		}System.out.println();
	}
}
*/


/*
//ex19) 배열
public class Hello {
	public static void main(String[] args) {
		int a=10; //일반변수
		
		// array
		// 방법1
		int[] arr=new int[5];
		// 방법2
		int[] brr=new int[] {1,2,3,4};
		// 방법3
		int[] crr= {1,2,3,4,5,6};
		System.out.println(arr.length);
		System.out.println(brr.length);
		System.out.println(crr.length);
		
		for(int i=0;i<brr.length;i++) {
			System.out.print(brr[i] + " ");
		}System.out.println();
		
		// i, value, item, x
		// foreach
		for (int value : crr) {
			System.out.print(value + " ");
		}System.out.println();
		
		//
		int[] drr=new int[5];
		// 0~4
		// ArrayIndexOutOfBoundsException
		// drr[5] = 100;
		drr[2] = 100;
		drr[2*5-7] = 100;
		drr[4] = 2;
		drr[drr[4]*3-5] = 999;
	}
}
*/


/*
//ex18) 우박수 문제
public class Hello {
	public static void main(String[] args) {
		int num=1234567;
		while(true) {
			System.out.println(num);
			if(num%2==0) {
				num=num/2;
			}else {
				num=num*3+1;
			}
			
			if(num==1) {
				System.out.println(num);
				break;
			}
		}
	}
}
*/


/*
//ex17)
// for : 정확하게 반복횟수를 알고 있을 때
// while : 프로그래머가 반복횟수를 모를때...
public class Hello {
	public static void main(String[] args) {
		int num=0;
		// ex1)
		while(num<4) {
			System.out.println(num++);
		}
		// ex2)
		while(true) {
			System.out.println(num++);
			if(num==33) {
				System.out.println("탈출 일보직전");
				break;
			}
		}
	}
}
*/

/*
//ex16)
public class Hello {
	public static void main(String[] args) {
		//1. case 뒤에는 변수가 올 수 없다.
		//2. switch에는 변수를 사용할 수 있다.
		//3. case뒤에 숫자가 중복될 수 없다.
		//4. 자바 버전에 따라서 문자열/문자를 분기시킬 수 있다.
		//5. 일반적으로 case break는 한쌍인데 의도적으로 break를 생략할 수 있다.
		int num=200;
		String s="독수리";
		
		switch (s) {
		
		case "독수리":
			System.out.println(1);
			break;
		case "코끼리":
			System.out.println(1);
			break;
			
		default: break;
		}
		
		switch (s) {
		case "독수리": //break;
		case "코끼리":
			System.out.println("동물입니다.");
			break;
		case "소나무": //break;
		case "대나무":
			System.out.println("식물입니다.");
			break;
			
		default: break;
		}
		
		int jumsu=80;
		switch(jumsu/10) {
		case 10: //break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		default:
			break;
		}
	}
}
*/



//ex15) for in for
//public class Hello {
//	public static void main(String[] args) {
//		// ex1)
//		// 격자형태(테이블형태, 맵형태)
//		for(int i=0;i<3;i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print("[" + i + " " + j + "]");
//			}
//			System.out.println();
//		}System.out.println();
//		
//		// ex2)
//		// 격자형태(테이블형태, 맵형태)
//		for(int i=0;i<3;i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(" * ");
//			}
//			System.out.println();
//		}System.out.println();
//		
//		// ex3)
//		int width=4, height=3;
//		for(int i=0;i<height;i++) {
//			for (int j = 0; j < width; j++) {
////				System.out.print(i*width+j);
//				System.out.printf("%2d", i*width+j);
//			}
//			System.out.println();
//		}System.out.println();
//		
//		System.out.printf( "호랑이\n" );
//		System.out.printf( "코끼리\n" );
//		System.out.printf( "코%d끼%d리%d\n", 777, 888, 999 );
//		System.out.printf("%d\n", 3);
//		System.out.printf("%4d\n", 3);
//		System.out.printf("%04d\n", 3);
//		
//		int a=10, b=20, c=30;
//		String s = String.format("무궁화:%d 소나무:%d 백합:%d", 10, 20, 30);
//		System.out.println("output : " + s);
//		
//		//ex4)
//		for(int i=0;i<3;i++)
//			for(int j=0;j<4;j++)
//				System.out.println("test");
//		
//		//ex5)
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<4;j++)
//				System.out.println("apple");
//			
//			System.out.println("banana");
//		}
//		
//		//ex6)
//		//for(int i=0;i<3;i++);
//		int count;
//		for(count=0; count<3; count++);
//		
//		System.out.println(count);
//	}
//}


//ex14)
//public class Hello {
//	// int a = n1++;
//	// int b = ++n2;
//	static void f1(int a, int b) {
//		System.out.println(a + " " + b);
//	}
//	public static void main(String[] args) {
//		int a = 3;
//		int b = a++; //1. 대입 2. 증가
//		System.out.println(a + " " + b);
//		
//		int c = 3;
//		int d = ++c; //1. 증가 2. 대입
//		System.out.println(c + " " + d);
//		int n1=3, n2=3;
//		System.out.println("-------------------------");
//		f1(n1++, ++n2);
//		n1++;
//		++n2;
//		// 자료가 10이 있을때
//		// 이 자료를 순회하면서 하나씩 가져오거나 저장할때
//		// 일반적으로 이터레이터를 사용하게 되는데
//		// 이터레이터 연산 중에서
//		// 이터레이터++
//		// ++이터레이터
//		// 라는 두 명령이 존재한다.
//		// 이때 두 명령의 실행속도는 30배정도 차이가 난다.
//		// ++이터레이터가 30배정도 빠르다.
//		// 그래서
//	}
//}

//ex13)
//public class Hello {
//	public static void main(String[] args) {
//		// 1만 증가 시킨다는 전제 아래에서
//		int num=0;
//		//대입연산과 덧셈연산이 사용된다.
//		// move, add 어셈블리어로 번역
//		num=num+1;
//		System.out.println(num);
//		// inc
//		// num++, ++num은 속도가 똑같다.
//		num++;
//		System.out.println(num);
//		++num;
//		System.out.println(num);
//		
//		num+=1; // 약간 좋다.
//		System.out.println(num);
//		
//		int test=10;
//		int count=20;
//		test+=count;
//		// test = test + count;
//	}
//}


//ex12)
//public class Hello {
//	public static void main(String[] args) {
//		char ch = 'A'; //문자 'A'의 아스키코드값은 65
//		// println ch가 무슨 타입인지 확인한다.
//		// 문자타입이라고 확인하고 숫자를 아스키문자로 출력한것이다.
//		System.out.println(ch);
//		// 강제 형 변환(단, 현재 라인에서만 적용된다.)
//		// 강제 형 변환(타입캐스팅)
//		System.out.println((int)ch);
//		System.out.println(65);
//		System.out.println((char)65);
//		int num = 65;
//		System.out.println(num);
//		System.out.println((char)num);
//		System.out.println("-------------------------");
//		
//		char ch2='A';
//		for(int i=0;i<26;i++) {
//			System.out.println((char)(ch2+i));
//		}
//	}
//}


//ex11)
//public class Hello {
//	public static void main(String[] args) {
//		// 기본코드1
//		int num=5;
//		for(int i=0;i<10;i++) {
//			System.out.println(num+ " * " + i + " = " + num*i);
//		}
//		// 기본코드2
//		int sum=0;
//		num = 10;
//		for (int i = 0; i <= num; i++) {
//			//sum = sum + i;
//			sum+=i; // 복합대입연산자
//		}
//		System.out.println(sum);
//		
//	}
//}



// ex10) for
//public class Hello {
//	public static void main(String[] args) {
//		// 정석코드1
//		for (int i = 0; i < 4; i++) {
//			System.out.println(i);
//		}
//		// 정석코드2
//		for (int i = 1; i <= 4; i++) {
//			System.out.println(i);
//		}
//		// 정석코드3
//		// 4*2+1번
//		int aa=4;
//		for (int i = -aa; i <= aa; i++) {
//			System.out.println(i);
//		}
//		// bad code
//		for(int i=0;i<=4;i++) {
//			System.out.println(i);
//		}
//		for(int i=2;i<=4;i++) {
//			System.out.println(i);
//		}
//		for(int i=2;i<=4;i+=2) {
//			System.out.println(i);
//		}
//		for(int i=2;i>4;i+=2) {
//			System.out.println(i);
//		}
//	}
//}



// ex9) if
//public class Hello {
//	public static void main(String[] args) {
//		// if for while switch
//		
//		// ex1)
//		// if(true)
//		// if(3>2)
//		// if(true||false)
//		if(true) {
//			System.out.println(1);
//			System.out.println(2);
//		}
//		// scope 생략 가능
//		if(true)
//			System.out.println(3);
//		
//		// ex2)
//		int num=10;
//		if(num%2==0) {
//			System.out.println("짝수");
//		}else {
//			System.out.println("홀수");
//		}
//		
//		// ex3) n개중에 1개를 선택
//		if(false) {
//			System.out.println(10);
//		}else if(false) {
//			System.out.println(20);
//		}else if(true) {
//			System.out.println(30);
//		}else {
//			System.out.println(40);
//		}
//		
//		// ex4)
//		if(true) {
//			if(false) {
//				if(true) {
//					
//				}
//			}else {
//				if(true) {
//					
//				}else if(false) {
//					
//				}else {
//					
//				}
//			}
//		}
//	}
//}


// ex8) 논리연산(관계연산)
//public class Hello {
//	public static void main(String[] args) {
//		// and(&&), or(||), not(부정)
//		System.out.println(false && false);
//		System.out.println(false && true);
//		System.out.println(true && false);
//		System.out.println(true && true);
//		System.out.println("------------------");
//		System.out.println(false || false);
//		System.out.println(false || true);
//		System.out.println(true || false);
//		System.out.println(true || true);
//		System.out.println("------------------");
//		boolean test=true;
//		System.out.println(!test);
//		System.out.println(!(10>20));
//		
//		System.out.println( true && true && true && false );
//		System.out.println( !(false && true && false && false) );
//		
//		// 연산자 우선순위 : 산술 > 관계(비교) > 논리
//		System.out.println(
////			3+2>2 && 4-2<10 && 3*3>=8
////			5>2 && 2<10 && 9>=8
////			true && true && true
//				);
//		// 아래 프로그램은 잘못 작성된 예이다.
//		// 코드의 가독성이 떨어진다.
//		// System.out.println(true && true || true);
//		// 연산자 우선순위를 결정해서 적어주는 것이 좋다.
//		System.out.println((true && true) || true);
//		System.out.println(true && (true || true));
//		
//		
//	}
//}


//ex7) 비교연산(관계연산)
//public class Hello {
//	public static void main(String[] args) {
//		// 산술연산
//		System.out.println(3>2);
//		System.out.println(3<2);
//		System.out.println(3>=2);
//		System.out.println(3<=2);
//		System.out.println(3==2);
//		System.out.println(3!=2);
//		
//		
//	}
//}



// ex6) 산술연산/문자열 연결
//public class Hello {
//	public static void main(String[] args) {
//		System.out.println(27 + 4);
//		System.out.println(27 - 4);
//		System.out.println(27 * 4);
//		System.out.println(27 / 4); //몫
//		// result : 0 ~ 3
//		System.out.println(27 % 4); //나머지
//		
//		System.out.println(27+4);
//		// 왼쪽에서 오른쪽으로 해석한다.
//		// 숫자 + 문자열 = 문자열
//		// 문자열 + 숫자 = 문자열
//		// 문자열 + 문자열 = 문자열
//		System.out.println(27+"호랑이");
//		System.out.println("호랑이"+27);
//		System.out.println("호랑이" + "코끼리");
//		System.out.println(27+13+"호랑이");
//		System.out.println(40+"호랑이");
//		System.out.println("호랑이" + 27 + 13);
//		System.out.println(27 + "호랑이" + 13);
//		System.out.print(27 + " " + 13);
//		int a = 10, b = 20;
//		System.out.println(a + " " + b);
//		// 문자 : 1개
//		// 문자열 : 0개이상
//	}
//}
//


// ex5) 표기법 정리
//public class Hello {
//	public static void main(String[] args) {
//		// 카멜표기법
//		int appleNum = 10;
//		// 파스칼표기법 : 맨앞에 오는 글자 대문자로 표기 + 카멜표기법
//		int TotalNumber = 10;
//		// 헝가리안표기법 : 접두어에 자료형을 알아볼 수 있게 표기
//		String strName;
//		// 스네이크 표기법 : 단어 사이에 언더바를 넣어서 표기
//		int total_number;
//	}
//}


// ex4)
//public class Hello {
//	public static void main(String[] args) {
//		short a = 200;
//		System.out.println(Short.MAX_VALUE);
//		System.out.println(Short.MIN_VALUE);
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(Long.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Character.MAX_VALUE);
//		System.out.println(Character.MIN_VALUE);
//		
//		int b = 10;
//		if (b < Short.MAX_VALUE) {
//			
//		}
//	}
//}

// ex03)
//public class Hello {
//	public static void main(String[] args) {
//		// type(형) int
//		// >> int, double, float, short, long, char, boolean, byte
//		// 8가지
//		// byte(1) : +- 127
//		// short(2) : +- 3xxxx
//		// char(2) : 문자 전용(0~65535)
//		// int(4) : 정수 전용 2^32(+- 20억)
//		// long(8) : 8byte 정수
//		// float(4) : 실수 전용(3.14)
//		// double(8) : 8byte 실수
//		// boolean(1) : true/false
//		
//		int a = 10;
//		double sum = 0.0;
//		for (int i=0;i<100;i++) {
//			sum+=0.1f;
//		}
//		System.out.println(sum);
//		
//	}
//}
// 2022.10.25

// ex1) 환경설정
// ex2) 
//public class Hello {
//	public static void main(String[] args) {
//		System.out.println("호랑이1");
//		System.out.println("호랑이2");
//		System.out.println("호랑이3");
//		System.out.println("호랑이4");	
//	}
//}