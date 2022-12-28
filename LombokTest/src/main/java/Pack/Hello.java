package Pack;

import lombok.*;

//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode

@Data
class Tiger{
	final String name;
	final Integer age;
}

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		Tiger t = new Tiger("호랑이", 100);
		System.out.println(t.toString());
	}

}




/*
@RequiredArgsConstructor
@ToString
class Tiger{
	final String name;
	final Integer age;
}

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		Tiger t = new Tiger("호랑이", 100);
		System.out.println(t.toString());
	}

}
*/








/*
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Tiger{
	String name;
	Integer age;
}

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger("호랑이", 100);
		System.out.println(t2.toString());
	}

}
*/





/*
@Getter
@Setter
class Tiger{
	int num;
}

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		Tiger t = new Tiger();
		t.setNum(100);
		System.out.println(t.getNum());
	}

}
*/