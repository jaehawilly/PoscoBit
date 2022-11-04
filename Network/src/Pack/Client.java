package Pack;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
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


public class Client extends Application{
	Socket socket = null;
	String message;
	InputStream is;
	OutputStream os;
	// TextArea(넓은 입력창)
	TextArea textArea = new TextArea();
	// TextField(한줄 입력창)
	TextField textField = new TextField();
	
	
	public String printMessage() {
		return this.message;
	}
	
	public void getReceiveMessage(String s) {
		try {
			message = s;
			Platform.runLater(()->{
				// textArea는 GUI 요소중 하나로써 화면에 출력해주는 요소
				textArea.appendText(s);
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(10);
		//-----------------------------------------------------------
		
		//-----------------------------------------------------------
		
		while(true) {
			try {
				is = socket.getInputStream();
				byte[] receiveMessage = new byte[512];
				int length = is.read(receiveMessage);
				message = new String(receiveMessage, 0, length, "UTF-8");
				Platform.runLater(()-> {
					textArea.appendText(message);
				});				
			} catch (Exception e) {
				break;
			}
		}

		
		Button btn1 = new Button("서버접속");
		Button btn3 = new Button("접속 종료");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				socket = new Socket();
				try {
//					socket.connect(new InetSocketAddress("192.168.0.104", 5000));
					socket.connect(new InetSocketAddress("192.168.0.19", 5000));
					btn1.setDisable(!btn1.isDisabled());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					socket.close();
					System.exit(0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
//		// TextArea(넓은 입력창)
//		TextArea textArea = new TextArea();
		// client의 TextArea에 다른 client의 message 씀
//		String str = getReceiveMessage(receiveMessage);
//		try {
//			Platform.runLater(()->{
//				textArea.appendText(str + "\n");
//			});
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		textArea.appendText(str + "\n");
		
		
		
		
		// client가 자기가 textField에 쓴 message를 textArea에 출력
		// TextField(한줄 입력창)
		textField.setOnAction(new EventHandler<ActionEvent>() {	
			
			// textField에 text를 입력 후 Enter를 쳤을때마다 실행
			@Override
			public void handle(ActionEvent arg0) {
				// textfield에 있는 text를 textArea에 출력
				String s = textField.getText();
				try {
					Platform.runLater(()->{
						textArea.appendText(s + "\n");						
					});					
					textField.setText(""); // Enter칠때 textField reset시킴
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				// client가 textField에 쓴 내용을 server로 send
				try {
					os = socket.getOutputStream();
					byte[] sendData = s.getBytes("utf-8");
					os.write(sendData);
					os.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		root.getChildren().addAll(btn1, btn3, textArea, textField);
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
