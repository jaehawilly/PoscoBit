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
import javafx.stage.WindowEvent;

import java.io.*;

class ClientThread extends Thread{
	Socket socket;
	int num;
	LinkedList<Client> clients = new LinkedList<>();
	
	ClientThread() {}
	ClientThread(Socket socket, int num, LinkedList<Client> clients) {
		this.socket=socket; // 주입(injection)
		this.num=num;
		this.clients=clients;
	}
	public void run() {
		try {
			
			while(true) {
				
				//------------------------- Input---------------------------//
				InputStream is = socket.getInputStream();
				// read : 블로킹 함수
				// 4096byte까지는 데이터 송수신 시에 데이터 loss가 없다.
				byte[] receiveData = new byte[512];
				int length = is.read(receiveData);
				
				String result = new String(receiveData, 0, length, "utf-8");
				System.out.println(result);
				
				//------------------------- Output---------------------------//
				for(Client client : clients) {
//					client.getReceiveMessage(result);
					
					OutputStream os = socket.getOutputStream();
					os.write(receiveData);
					os.flush();
				}
				
				
				
				
				System.out.println(result); // 서버에 메시지 출력
				
				
				// 서버 종료 버튼을 눌러서 종료 시켰을 때 size=-1 exception 처리 해줘야함
				if(length==-1) {
					System.out.println("클라이언트" + num + "가 접속 종료하였습니다.");
					break;
				}
			}
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
}

class ConnectThread extends Thread{
	// 클라이언트들을 담는 링크드리스트형 객체
	LinkedList<Client> clients = new LinkedList<>();
	ServerSocket serverSocket;
	
	public void run() {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.19", 5000));
			makeClients();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void makeClients() {
		while(true) {
			// 1차 블로킹이 풀린다.
			try {
				Socket socket = serverSocket.accept();
				int num = clients.size()+1;
				clients.add(new Client());
				System.out.printf("%d번 클라이언트가 접속하였습니다.\n", num);
				
				// 스레드 생성
				ClientThread clientThread = new ClientThread(socket, num, clients);
				clientThread.start();					

			} catch (Exception e) {
				
			}
		}
	}
	
	// 서버의 작동을 중지시키는 메소드.
	// 서버를 완전히 중지시키는 것이기 때문에 모든 클라이언트에 대한 정보를 끊어준다.
//	public void stopServer() {
//		try {
//			// stopServer는 서버를 완전하게 중지를 시키는 것이기 때문에
//			// 모든 클라이언트들에 대한 정보를 끊어준다.
//			
//			// 현재 작동중인 모든 소켓 닫기
//			Iterator<Client> iterator = clients.iterator();
//			// iterator로 하나씩 접근
//			while(iterator.hasNext()) {
//				Client client = iterator.next();
//				// 닫아줌.
//				client.socket.close();
//				// iterator에서도 닫아준 소켓 제거
//				iterator.remove();
//			}
//			// 서버 소켓 객체 닫기
//			if(serverSocket != null && !serverSocket.isClosed()) {
//				serverSocket.close();
//			}
//			System.out.println(clients.size());
//			System.out.println("서버 종료되었습니다.");
////			// 쓰레드 풀 종료하기
////			if(threadPool != null && !threadPool.isShutdown()) {
////				// shutdown으로 자원할당 해제
////				threadPool.shutdown();
////			}
//		} catch (Exception e) {
//		}
//	}
}
public class Server extends Application{
	Button btn1;
	Button btn2;
	ConnectThread connectThread;
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//-----------------------------------------------------------
		btn1 = new Button("서버오픈");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				connectThread = new ConnectThread();
				connectThread.start();
				btn1.setDisable(!btn1.isDisable());
			}
		});
		
		btn2 = new Button("서버종료");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		arg0.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		root.getChildren().addAll(btn1, btn2);
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