import java.io.*;
import java.util.*;

// Collection
// List(순서가 있음) - LinkedList, Stack, Vector, ArrayList
// Set(중복X) - HashSet, SortedSet-TreeSet
// Map(key:value) - Hashtable, HashMap, SortedMap-TreeMap

/*
// ArrayList
public class Main {
    public static void main(String[] args) {
        // ArrayList 선언
        ArrayList<Integer> al = new ArrayList<>();

        // ArrayList에 데이터 입력
        for (int i=0;i<5;i++) {
            al.add(i);
        }

        System.out.println(al);

        // 3번데이터 제거
        al.remove(3);
        System.out.println(al);

        // 하나씩 가져와서 결과 출력
        for (int i=0;i<al.size();i++) {
            System.out.print(al.get(i) + " ");
        }
    }
}
*/

/*
// LinkedList
public class Main {
    public static void main(String[] args) {
        // LinkedList 선언
        LinkedList<Integer> ll = new LinkedList<>();

        // 값 입력
        for (int i=0;i<5;i++) {
            ll.add(i);
        }
        System.out.println(ll);

        // 3번데이터 삭제
        ll.remove(3);
        System.out.println(ll);

        for (Integer value : ll) {
            System.out.print(value + " ");
        }
    }
}
*/

/*
// Vector
public class Main{
    public static void main(String[] args){
        // vector 선언
        Vector<Integer> v = new Vector<>();

        // 그 밑은 똑같음
    }
}
*/

/*
// Stack
public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World!");
        stack.push("Hello");
        stack.push("Hello");

        // stack Iterator 선언
        Iterator<String> itr = stack.iterator();

        // 결과 출력
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }System.out.println();
        // 후입선출(LIFO)
        stack.pop();

        // iterator 재정의
        itr = stack.iterator();
        // 결과 출력
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }


    }
}
*/

/*
// Queue
// 우선순위에 따라 객체를 처리해야할때
public class Main {
    public static void main(String[] args){
        // 우선순위 큐 선언
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // 데이터 입력
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // 첫번째 데이터 출력
        System.out.println(pQueue.peek()); //10

        // 오름차순으로 데이터 출력(출력된 데이터는 제거됨)
        System.out.println(pQueue.poll()); //10
        System.out.println(pQueue.peek()); //15(오름차순이기 때문에)
    }
}
*/

/*
// Deque
// 양방향 큐, 양쪽 끝에서 요소 추가/제거, 크기 조정되는 배열(ArrayDeque)
public class Main {
     public static void main(String[] args){
         // Dequeue 선언
         ArrayDeque<Integer> de_que = new ArrayDeque<>(10);

         // 값 입력
         de_que.add(10);
         de_que.add(20);
         de_que.add(30);
         de_que.add(40);
         de_que.add(50);

         System.out.println(de_que);

         // deque 초기화
         de_que.clear();

         // 첫번째에 데이터 입력
         de_que.addFirst(564);
         de_que.addFirst(291);

         // 마지막에 데이터 입력
         de_que.addLast(24);
         de_que.addLast(14);

         System.out.println(de_que);

     }
}
*/

/*
// Set
// HashSet
// 중복값 X, 정렬 X
public class Main {
    public static void main(String[] args) {
        // HashSet 선언 및 데이터 입력
        HashSet<String> hs = new HashSet<>();
        hs.add("Hello");
        hs.add("World");
        hs.add("Hello");
        hs.add("Blog");
        hs.add("CrazyKim");

        // Traversing elements
        Iterator<String> itr = hs.iterator();
        while(itr.hasNext()) {
           System.out.println(itr.next());
        }
    }
}
*/

/*
// LinkedHashSet
// hashSet과 유사하지만 차이점은 데이터를 저장하는 순서를 유지한다
public class Main {
    public static void main(String[] args) {
        //LinkedHashSet 선언 및 데이터 입력
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Hello");
        lhs.add("World");
        lhs.add("Hello");
        lhs.add("blog");
        lhs.add("CrazyKim");

        //결과 출력
        Iterator<String> itr=lhs.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
*/

/*
// Sorted Set
// TreeSet
// Tree를 사용하여 저장, 데이터의 순서는 자연적인 순서(오름차순)대로 유지
public class Main {
    public static void main(String[] args) {
        //TreeSet 변수 선언 및 데이터 입력
        TreeSet<String> ts = new TreeSet<>();

        ts.add("Hello");
        ts.add("World");
        ts.add("Hello");
        ts.add("Blog");
        ts.add("CrazyKim");

        // Traversing elements
        Iterator<String> itr = ts.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
*/

/*
//Map
//HashMap
//key-value형태, 인덱싱 및 검색작업이 빨라지도록 함
public class Main {
    public static void main(String[] args) {
        //HashMap 선언 및 데이터 입력
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "Hello");
        hm.put(2, "World");
        hm.put(3, "CrazyKim");


        System.out.println("Value for 1 is " + hm.get(1)); // Value for 1 is Hello
        for(Map.Entry<Integer, String> e : hm.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
//        1 Hello
//        2 World
//        3 CrazyKim
    }
}
*/