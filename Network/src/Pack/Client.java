package Pack;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application{
	Socket socket = null;
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//-----------------------------------------------------------
		
		Button btn1 = new Button("서버접속");
		Button btn2 = new Button("데이터 전송");
		Button btn3 = new Button("접속 종료");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				socket = new Socket();
				try {
					socket.connect(new InetSocketAddress("localhost", 5000));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream os = socket.getOutputStream();
					
					//byte 타입으로 데이터 전송해야한다(byte 타입밖에 안됨)
					String s = "apple" + count++;
					byte[] data = s.getBytes("utf-8");
//					for (byte b : data) {
//						System.out.println(b);
//					}
					os.write(data);
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		root.getChildren().addAll(btn1, btn2, btn3);
		//-----------------------------------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("클라이언트 프로그램");
		arg0.show();
	}
	public static void main(String[] args) {
		System.out.println("Client Start");
		launch();
		System.out.println("Client End");
		
//		Socket socket = new Socket();
//		
//		try {
//			System.out.println("숫자를 입력하면 접속을 시도합니다.");
//			new Scanner(System.in).nextInt();
//			
//			// 옆 사람 ipv4 주소 : 192.168.0.10
//			socket.connect(new InetSocketAddress("192.168.0.10", 5000));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		System.out.println("숫자를 입력하면 클라이언트를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
	}

}
