package Pack01;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

class Apple {
	String name;
	Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}

class MyBatisDao {
	InputStream is = null;
	SqlSession session = null;
	SqlSessionFactory factory() {		
		try {
			// 소스 코드만 리딩.
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {
			System.out.println("error");
		}
		// 코드를 컴파일 한것이고
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
		
		return sf;
	}
	
	void insert(Integer num) {
		session = factory().openSession();
		 
		 try { int result = session.insert("test02", num);
			 System.out.println("result : " + result);
			 if(result > 0) { // query 코드에 잘 들어갔는지 확인하는 코드 : result가 0보다 크면 잘들어갔다는 뜻
			 	session.commit(); // db에 실질적으로 저장
			 }
		 } catch (Exception e) {e.printStackTrace(); 
		 } finally {session.close();}
	}
	
	void delete(Integer num) {
		session = factory().openSession();
		try {
			int result = session.delete("test03", num);
			System.out.println("result : " + result);
			if (result > 0) { // query 코드에 잘 들어갔는지 확인하는 코드 : result가 0보다 크면 잘들어갔다는 뜻
				session.commit(); // db에 실질적으로 저장
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {session.close();}
	}
	
	void update(Integer num) {
		session = factory().openSession();
		try {
			int result = session.update("test04", num);
			System.out.println("result : " + result);
			if (result > 0) { // query 코드에 잘 들어갔는지 확인하는 코드 : result가 0보다 크면 잘들어갔다는 뜻
				session.commit(); // db에 실질적으로 저장
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {session.close();}
	}
	
	void showAll() {
		session = factory().openSession();
		try {
			List<Apple> li = session.selectList("test05");
			
			System.out.println("show all-----------------");
			for(Apple item : li) {
				System.out.println(item.getName() + " " + item.getAge());
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {session.close();}
	}
	
	void insert(Apple apple) {
		session = factory().openSession();
		 
		 try { int result = session.insert("test06", apple);
			 System.out.println("result : " + result);
			 if(result > 0) { // query 코드에 잘 들어갔는지 확인하는 코드 : result가 0보다 크면 잘들어갔다는 뜻
			 	session.commit(); // db에 실질적으로 저장
			 }
		 } catch (Exception e) {e.printStackTrace(); 
		 } finally {session.close();}
	}
	void delete(Apple apple) {
		session = factory().openSession();
		try {
			int result = session.delete("test07", apple);
			System.out.println("result : " + result);
			if (result > 0) { // query 코드에 잘 들어갔는지 확인하는 코드 : result가 0보다 크면 잘들어갔다는 뜻
				session.commit(); // db에 실질적으로 저장
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {session.close();}
	}
	
	void update(Apple apple) {
		session = factory().openSession();
		try {
			int result = session.update("test08", apple);
			System.out.println("result : " + result);
			if (result > 0) { // query 코드에 잘 들어갔는지 확인하는 코드 : result가 0보다 크면 잘들어갔다는 뜻
				session.commit(); // db에 실질적으로 저장
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {session.close();}
	}
}

public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		MyBatisDao dao = new MyBatisDao();
		dao.insert(666);
//		dao.showAll();
		
		Apple temp = new Apple();
		temp.setName("홍길동");
		temp.setAge(9999);
		dao.insert(temp);
		dao.showAll();

		System.out.println(2);
	}

}





