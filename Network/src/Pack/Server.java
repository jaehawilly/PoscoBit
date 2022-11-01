package Pack;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

class ClientThread extends Thread{
	Socket socket;
	ClientThread() {}
	ClientThread(Socket socket) {
		this.socket=socket; // 주입(injection)
	}
	public void run() {
		try {
			
			
			while(true) {
				InputStream is = socket.getInputStream();
				
				// read : 블로킹 함수
				// 4096byte까지는 데이터 송수신 시에 데이터 loss가 없다.
				byte[] data = new byte[512];
				int size = is.read(data);
				
				// 서버 종료 버튼을 눌러서 종료 시켰을 때 size=-1 exception 처리 해줘야함
				if(size==-1) {
					System.out.println("클라이언트가 접속 종료하였습니다.");
					break;
				}
				System.out.println(size);
				// tiger
				String result = new String(data, 0, size, "utf-8");
				System.out.println(result);
				
			}
			
			
		} catch (IOException e) {
			System.out.println("호랑이");
//			e.printStackTrace();
		}
	}
}

class ConnectThread extends Thread{
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5000));
			
			// 1차 블로킹이 풀린다.
			System.out.println("누군가를 기다림");
			Socket socket = serverSocket.accept();
			
			// 스레드 생성
			ClientThread clientThread = new ClientThread(socket);
			clientThread.start();
			
			System.out.println("누군가 접속됨");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
public class Server extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//-----------------------------------------------------------
		
		Button btn1 = new Button("서버오픈");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ConnectThread connectThread = new ConnectThread();
				connectThread.start();
				
			}
		});
		
		
		
		
		root.getChildren().addAll(btn1);
		//-----------------------------------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("서버 프로그램");
		arg0.show();
	}
	public static void main(String[] args) {
		System.out.println("Server Start");
		launch();
		System.out.println("Server End");
		
//		try {
//			ServerSocket serverSocket = new ServerSocket();
//			System.out.println("메인 서버 소켓 생성");
//			
//			// port 번호 : 0~99999 사용 가능(0~1023은 관공서 port번호이므로 사용x)
//			// 192.168.0.19 (내 pc ipv4 주소)
//			// 127.0.0.1(localhost와 똑같은 주소)->일반적으로 localhost라고 적음
//			//스스로에게 자기 자신이 누구인지 설정
//			serverSocket.bind(new InetSocketAddress("192.168.0.19", 5000));
//			System.out.println("바인딩 완료");
//			
//			// 누군가의 접속을 기다린다.(블록킹 함수)
//			Socket socket = serverSocket.accept();
//			System.out.println("누군가 접속됨");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		// 종료를 막기 위하여 코드 잔류.
//		System.out.println("숫자를 입력하면 서버를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");
	}

}

// 1. 접속을 할때마다 thread를 생성

// 2. 처음부터 thread를 1개만 만들어 놓고 Linkedlist를 사용해서 소켓 번호를 저장해놓음
// -> 게임에서 많이 사용(thread를 많이 만들 수 없는 환경이기 때문)