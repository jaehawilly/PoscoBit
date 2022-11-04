package Pack1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
public class ChatClient extends Application {
	Socket socket;
	TextArea textArea;
	Label label1;
	Button button1;
	Scene scene1, scene2;
	
	
	// 클라이언트 프로그램 동작 메소드
	public void startClient(String IP, int port) {
		//서버프로그램과 다르게 여러개의 쓰레드가 동시다발적으로 생겨나는 경우가 없기 때문에
		//굳이 ThreadPool을 사용할 필요가 없다.
		//따라서 Runnable객체 대신에 단순하게 Thread객체를 사용한다.
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// 소켓 초기화
					socket = new Socket(IP, port);
					// 메시지를 전달받도록 receive 메소드 호출
					System.out.println("run()" + socket);
					
					receive();
					
				} catch (Exception e) {
					//오류가 발생한 경우
					if(null == socket || !socket.isClosed()) {
						//stopClient 메소드를 호출해서 클라이언트를 종료
						stopClient();
						System.out.println("[서버 접속 실패]");
						
						//프로그램 자체를 종료시킨다.
						try {Thread.sleep(3000);} catch (InterruptedException e1) {e1.printStackTrace();}
						Platform.exit();
					}
				}
			}
		};
		thread.start();
	}
	
	
	// 클라이언트 프로그램 종료 메소드
	public void stopClient() {
		try {
			// 소켓이 열려있는 상태라면
			if(socket != null && !socket.isClosed()) {
				socket.close();
				
				System.out.println("socket close");
				Platform.exit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 서버로부터 메시지를 전달받는 메소드
	// 계속 전달받기 위해서 무한loop를 돌려준다.
	public void receive() {
		while(true) {
			try {
				// 현재 서버로부터 어떠한 메시지를 전달받을 수 있도록.
				InputStream in = socket.getInputStream();
				// 512byte만큼 버퍼에 담아서 끊어서 계속 전달받을 것.
				byte[] buffer = new byte[512];
				// read함수로 실제로 입력을 받는다.
				int length = in.read(buffer);
				// 내용을 입력받는 도중에 오류가 발생하면 IOException을 발생시킨다.
				if(length == -1 ) throw new IOException();
				// message에 버퍼에 있는 정보를 담기.
				String message = new String(buffer, 0, length, "UTF-8");
				// 화면에 출력
				Platform.runLater(()->{
					// textArea는 GUI 요소중 하나로써 화면에 출력해주는 요소
					textArea.appendText(message);
				});
				
			} catch (Exception e) {
				//오류가 발생했을 때는 stopClient 호출 후 반복문 break;
				stopClient();
				break;
			}
		}
	}
	
	
	// 서버로 메시지를 전송하는 메소드
	public void send(String message) {
		// 여기서도 메시지를 전송할 때 Thread를 이용하는데,
		// 서버로 메시지를 전송하기 위한 Thread 1개
		// 서버로부터 메시지를 전달받는 Thread 1개
		// 이렇게 총 2개의 Thread가 각각 다른 역할을 가진다.
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					// 보내고자 하는 것을 UTF-8로 인코딩을 한다.
					// 서버에서 전달받을 때 UTF-8로 인코딩된 것을 받도록 해두었기 때문.
					byte[] buffer = message.getBytes("UTF-8");
					//메시지 전송
					out.write(buffer);
					//메시지 전송의 끝을 알림.
					out.flush();
					
				} catch (Exception e) {
					//오류가 발생했다면
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	// 서버 연결을 확인하는 메소드
	public void connect(Stage primaryStage) {
		for (int i = 0; i < 1000; i++) {
			
			button1 = new Button("채팅방 입장하기");
			if(socket == null) {
				label1 = new Label("서버 대기 중");
				button1.setDisable(true);
				
			}else {
				label1 = new Label("입장 가능합니다.");
				button1.setDisable(false);
			}
			
		}
	}
	
	
	// 실제로 프로그램을 동작시키는 메소드
	@Override
	public void start(Stage primaryStage) {

		TextField IPText = new TextField("19");
		TextField portText = new TextField("9876");
		int port = 9876;
		startClient( "192.168.0." + IPText.getText(), port);
		
		connect(primaryStage);
		
		//layout1
		GridPane layout1 = new GridPane();
		layout1.setVgap(10);
		layout1.add(label1, 0, 0);
		layout1.add(button1, 0, 1);
		layout1.setAlignment(Pos.CENTER);
		GridPane.setHalignment(label1, HPos.CENTER);
		
		scene1 = new Scene(layout1, 600, 600);
		button1.setOnAction(e->primaryStage.setScene(scene2));
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		// BorderPane위에 하나의 레이아웃을 더 넣어주기 위한 것.
		HBox hbox = new HBox();
		// 여백
		hbox.setSpacing(5);
		
		// 사용자 이름이 들어갈 수 있는 텍스트 공간
		String client = socket.getLocalSocketAddress() + " ";
		String clientNum = client.substring(11, 14);
		Label userName = new Label(clientNum);
		userName.setPrefWidth(50); // 너비
		userName.setAlignment(Pos.BASELINE_CENTER);
		userName.setStyle("-fx-font-size:20");
		
		Button exitButton = new Button("나가기");
		exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		exitButton.setOnAction(event ->{
			System.out.println("stop client");
			stopClient();
			primaryStage.setScene(scene1);
		});
		Region region1 = new Region();
		HBox.setHgrow(region1,  Priority.ALWAYS);
		Region region2 = new Region();
		HBox.setHgrow(region2, Priority.ALWAYS);
		portText.setPrefWidth(80);
		exitButton.setPrefWidth(60);
		
		textArea = new TextArea();
		// 내용을 수정할 수 없도록 설정
		textArea.setEditable(false);
		// 레이아웃(borderPane)의 중간에 위치
		root.setCenter(textArea);
		
		TextField input = new TextField();
		input.setPrefWidth(Double.MAX_VALUE);
		input.setDisable(false); // 접속하기 이전에는 어떠한 메시지를 전송할 수 없도록.
		input.setOnAction(event ->{
			// 서버로 어떠한 메시지를 전달할 수 있도록.
			send(userName.getText() + " : " + input.getText() + "\n");
			input.setText(""); // 전송했으니까 전송칸 비우기
			input.requestFocus(); // 다시 어떠한 메시지를 전송할 수 있도록 포커싱을 설정
		});
		IPText.setOnAction(e->
		{startClient("192.168.0." + IPText.getText(), port);
			textArea.setText("");
		}
		
		);
		
		Button sendButton = new Button("보내기");
		sendButton.setDisable(false); // 접속하기 이전에는 이용할 수 없도록 설정
		
		// 버튼을 누르는 이벤트가 발생했을 때 전송될 수 있도록
		sendButton.setOnAction(event ->{
			send(userName.getText() +": " + input.getText() + "\n");
			input.setText("");
			input.requestFocus();
		});
		
		
		
		// hbox에 4개의 텍스트박스가 추가될 수 있도록.
		hbox.getChildren().addAll(IPText,region2, exitButton);
				
		// borderPane 상단에 위치
		root.setTop(hbox);
		
//		exitButton.setOnAction(e->{
//			stopClient();
//			primaryStage.setScene(scene1);
//		});
		//위에서 설정한 내용을 넣을 공간 생성
		BorderPane pane = new BorderPane();
		pane.setLeft(userName);
		pane.setCenter(input);
		pane.setRight(sendButton);
		
		root.setBottom(pane);
		scene2 = new Scene(root, 600, 600);
		primaryStage.setTitle("[ 채팅 클라이언트 ]");
		primaryStage.setScene(scene1); // scene등록
		primaryStage.setOnCloseRequest(event -> stopClient()); // 화면닫기 버튼을 누르면 stopClient 수행 후 종료.
		primaryStage.show();
		
		
	}
	
	// 프로그램의 진입접입니다.
	public static void main(String[] args) {
		launch(args);
	}
}