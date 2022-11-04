package pack1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.VBox;

public class Main extends Application{
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	@Override
	public void start(Stage arg0) throws Exception {
		TextField textField = new TextField();
		textField.setPromptText("Field값을 차례대로 입력하세요");
		TextArea textArea = new TextArea();
		textArea.setPrefSize(400, 300);
		
		Button btn1 = new Button("데이터 조회(SELECT)"); // Select
		Button btn2 = new Button("데이터 추가(INSERT)	입력양식 :  (값) (값) (값) (값)..."); // Insert
		Button btn3 = new Button("데이터 변경(UPDATE)	입력양식 :  (바꾸고싶은Field명)	  (값)    조건(필드=값)"); // Update
		Button btn4 = new Button("데이터 삭제(DELETE)	입력양식 :  조건(필드=값)"); // Delete
		// ------------------------------------------
		
		VBox root = new VBox();
		root.setPrefSize(500, 500);
		root.setSpacing(10);
		
		// SELECT(데이터 조회)
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				textArea.appendText("============================\n");
				String s = "SELECT * FROM table01";			
				try {
					rs = stmt.executeQuery(s);
					while (rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						int age = rs.getInt(3);
						int salary = rs.getInt(4);
						textArea.appendText(id + " " + name + " " + " " + age + " " + salary + "\n");
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				textField.setText("");
				
			}
		});
		
		// 데이터 추가(INSERT)
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String input = textField.getText();
				String[] srr = input.split(" ");
				String s = "insert into table01 values(" + srr[0] + ", '" + srr[1] + "', " + srr[2] + ", " + srr[3] + ");";
				try {
					stmt.executeUpdate(s);
					textField.setText("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 데이터 변경(UPDATE)
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String input = textField.getText();
				String[] srr = input.split(" ");
				String s = "update table01 set " + srr[0] + "=" + srr[1] + " where " + srr[2] + ";";
				try {
					stmt.executeUpdate(s);
					textField.setText("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 데이터 삭제(DELETE)
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String input = textField.getText();
				String[] srr = input.split(" ");
				String s = "delete from table01 where " + srr[0] + ";";
				try {
					stmt.executeUpdate(s);
					textField.setText("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
//		textField.setOnAction(new EventHandler<ActionEvent>() {
//			
//			// textField에 text를 입력 후 Enter를 쳤을때마다 실행
//			@Override
//			public void handle(ActionEvent arg0) {
//				String s = textField.getText();
//				// 4. SQL 쿼리 작성
//				// 주의사항
//				// 1) JDBC에서 쿼리를 작성할 때는 세미콜론(;)을 빼고 작성한다.
//				// 2) SELECT 할 때 * 으로 모든 칼럼을 가져오는 것보다
//				// 가져와야 할 칼럼을 직접 명시해주는 것이 좋다.
//				// 3) 원하는 결과는 쿼리로써 마무리 짓고, java 코드로 후작업 하는 것은 권하지 않음
//				// 4) 쿼리를 한 줄로 쓰기 어려운 경우 들여쓰기를 사용해도 되지만 띄어쓰기에 유의 !!
//				
//				char c = s.charAt(0);
//				
//				if(c == 'S' || c == 's') {
//					// select일때				
//					try {
//						rs = stmt.executeQuery(s);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					// 6. 실행결과 출력하기
//					try {
//						textArea.appendText(s + "\n");
//						while (rs.next()) {
//							// 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
//							// 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
//							int id = rs.getInt(1);
//							String name = rs.getString(2);
//							int age = rs.getInt(3);
//							int salary = rs.getInt(4);
//							
//							textArea.appendText(id + " " + name + " " + " " + age + " " + salary + "\n");
//						}
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				} else if(c == 'q') {
//					return;
//				} else {		
//					try {
//						stmt.executeUpdate(s);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//				textField.setText(""); // Enter칠때 textField reset시킴
//				
//			}
//		});
		
		
		// ---------------------------------------------------------
		root.getChildren().addAll(btn1, btn2, btn3, btn4, textField, textArea);
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("데이터를 입력하세요");
		arg0.show();
		// ----------------------------------------------------------
		
		
//		String sql = "SELECT * FROM table01";
		
		// 5. 쿼리 수행
		// 레코드들은 ResultSet 객체에 추가된다.
		
	
	
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
		launch(args);
		}  catch (ClassNotFoundException e) {
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

