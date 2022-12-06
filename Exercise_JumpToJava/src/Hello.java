import java.util.*;
import java.io.*;

/* 10
class OddException extends Exception {
}
public class Hello {
    static void execute(int n) throws OddException {
        System.out.printf("입력 숫자: %d\n", n);
        if (n % 2 == 1) {  // 홀수이면 OddException이 발생한다.
            throw new OddException();
        }
        System.out.println("짝수입니다.");
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                execute(r.nextInt(10));
            } catch (OddException e) {
                e.printStackTrace();
            }
        }
    }
}
*/


/* 9
class Calculator{
    int[] data;
    Calculator(int[] data) {
        this.data=data;
    }
    public int sum() {
        int sum=0;
        for (int value : data) {
            sum+=value;
        }
        return sum;
    }
    public double avg() {
        return (float) sum()/data.length;
    }
}
public class Hello {
    public static void main(String[] args) {
        int[] data1 = {1,2,3,4,5};
        Calculator cal1 = new Calculator(data1);
        System.out.println(cal1.sum()); // 15 출력
        System.out.println(cal1.avg()); // 3.0 출력

        int[] data2 = {6,7,8,9,10};
        Calculator cal2 = new Calculator(data2);
        System.out.println(cal2.sum()); // 40 출력
        System.out.println(cal2.avg()); // 8.0 출력
    }
}
*/


/* 8
public class Hello {
    public static void main(String[] args) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
        while(true) {
            String line = br.readLine();
            if(line==null) break;
            lines.add(line);
        }
        br.close();

        int total = 0;
        for (String line : lines) {
            line = line.trim();
            int num = Integer.parseInt(line);
            total+=num;
        }
        float average = (float) total / lines.size();
        System.out.printf("총합 : %d, 평균 : %.2f\n", total, average);

        PrintWriter pw = new PrintWriter("result.txt");
        pw.write(String.format("%.2f", average));

        pw.close();
    }
}
*/


/* 7
public class Hello{
    public static void main(String[] args) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
        while(true) {
            String line = br.readLine();
            if(line==null) break;
            lines.add(line);
        }
        br.close();

        lines.sort(Comparator.reverseOrder());

        PrintWriter pw = new PrintWriter("result.txt");
        for (String line : lines) {
            pw.println(line);
        }
        pw.close();

    }
}
*/




/* 6
public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] srr = temp.split(",");
        int sum=0;
        for (String value : srr) {
            int num=Integer.parseInt(value);
            sum+=num;
        }
        System.out.println(sum);
    }
}
*/


/* 5
public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<9;i++){
            System.out.print(n*(i+1) + " ");
        }
    }
}
*/

/* 4
public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
    static public int fibonacci(int n) {
        if (n==0) return 0;
        else if(n==1) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}
*/


/* 3
public class Hello {
    public static void main(String[] args) {
        int[] A = {20, 55, 67, 82, 45, 33, 90, 87, 100, 25};
        int sum=0;
        for (int value : A) {
            sum += (value>=50 ? value : 0);
        }
        System.out.println(sum);

//        int total = Arrays.stream(A).filter((a)-> a>=50).sum();
//        System.out.println(total);
    }
}
*/


/* 2
public class Hello {
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<>();
        a.put("A", 90);
        a.put("B", 80);
//        System.out.println(a.get("c")==null ? 70 : a.get("c"));
        System.out.println(a.getOrDefault("C", 70));
    }
}
*/



/* 1
public class Hello {
    public static void main(String[] args) {
        String s = "a:b:c:d";
        String[] temp = s.split(":");
        String result = String.join("#", temp);
        System.out.println(result);
    }
}
*/