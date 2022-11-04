package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main extends Application {
	
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox(); // 세로
		root.setPrefSize(800, 600); // 가로, 세로 해상도 설정
		root.setSpacing(10);
		
		Button btn0 = new Button("메뉴얼");
		Button btn1 = new Button("테이블 조회");
		TextArea textArea = new TextArea();
		TextField textField = new TextField();
		
		// 버튼0을 눌렀을 때
		btn0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				textArea.appendText("데이터 추가는 id name age salary 순으로 입력해주세요." + "\n");
				textArea.appendText("데이터 업데이트는 filed(id, name, age, sallary) value 순으로 입력해주세요." + "\n");
				//		textArea.appendText("데이터 추가는 id name age salary 순으로 입력해주세요.");
			}
		});
		
//		textField.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				String s = textField.getText();
//				input = s.split(" ");
//				textField.setText("");
//			}
//		});
		
//		// 버튼1을 눌렀을 때
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					rs = stmt.executeQuery("select * from table01");
					while (rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						int age = rs.getInt(3);
						int salary = rs.getInt(4);
						
						String result = new String(id + " " + name + " " + age + " " + salary);
						textArea.appendText(result + "\n");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Button btn2 = new Button("데이터 추가");
//		// 버튼1을 눌렀을 때
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					PreparedStatement st = conn.prepareStatement("insert into table01(id,name,age,salary) values(?,?,?,?)");
					
					String[] input = textField.getText().split(" ");
					if(input[0].equals(null)) {
						st.setString(1, null);
					} else {
						st.setInt(1, Integer.parseInt(input[0]));
					}
					
					st.setString(2, input[1]);
					st.setInt(3, Integer.parseInt(input[2]));
					st.setInt(4, Integer.parseInt(input[3]));
					st.executeUpdate();
					textField.setText("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		Button btn3 = new Button("데이터 업데이트");
		
		
		
		
		Button btn4 = new Button("데이터 삭제");
		root.getChildren().addAll(btn0, btn1, btn2, btn3 ,btn4, textField, textArea);
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("sql 작성 프로그램");
		arg0.show();
	}	
	
	public void select() {
	}
	
	
	public static void main(String[] args) {
	
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 연결하기
			String url = "jdbc:mysql://localhost:3306/db01";
			conn = DriverManager.getConnection(url, "root", "1234");
			// 3. 쿼리 수행을 위한 Statement 객체 생성
			stmt = conn.createStatement();
			
			launch();
			while(true) {				
				// 4. SQL 쿼리 작성
				// 주의사항
				// 1) JDBC에서 쿼리를 작성할 때는 세미콜론(;)을 빼고 작성한다.
				// 2) SELECT 할 때 * 으로 모든 칼럼을 가져오는 것보다
				// 가져와야 할 칼럼을 직접 명시해주는 것이 좋다.
				// 3) 원하는 결과는 쿼리로써 마무리 짓고, java 코드로 후작업 하는 것은 권하지 않음
				// 4) 쿼리를 한 줄로 쓰기 어려운 경우 들여쓰기를 사용해도 되지만 띄어쓰기에 유의 !!
				Scanner sc = new Scanner(System.in);
				String sql = sc.nextLine();
				char c = sql.charAt(0);
				
				if(c == 'S' || c == 's') {
				} else if(c == 'q') {
					break;
				} else {		
					stmt.executeUpdate(sql);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				System.out.println("End");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}