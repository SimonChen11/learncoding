import java.util.*;
import java.nio.charset.*;
import javax.ws.rs.core.*;

class test {

	public static void main(String[] args) {

		// Number n = 0.1;
		// System.out.println(n.getClass()); 
  //    	Class<? extends Number> c = n.getClass();
  //    	System.out.println(c); 


		GenericType<List<String>> stringListType = new GenericType<List<String>>() {};
		System.out.println(stringListType.getClass());



		// System.out.println(-1%10);

		// ArrayList<Integer> list = new ArrayList<>();

		// list.add(1);
		// list.add(2);

		// Integer[] result = list.toArray(new Integer[0]);

		// System.out.println(result.length);

		// Integer test = null;
		// byte[] test = new byte[] {-1};



		// String a = new String(test, StandardCharsets.UTF_16);

		// System.out.println(a);

		// System.out.println(Arrays.toString(a.getBytes(StandardCharsets.UTF_8)));
	
		//String test1 = test == null ? new HashSet<String>() : 1;

		// System.out.println("abc" + test == null ?  1 : new HashSet<String>());

		// int i = 0;

		// do {

		// 	System.out.println(i);
		// 	i++;
		// } while (i < 5);

 
		// List<List<Integer>> result = new ArrayList<>();
		// result.add(Arrays.asList(98, 218, 331, 410));
		// result.add(Arrays.asList(98, 218, 352, 389));
		// result.add(Arrays.asList(98, 218, 331, 410));
		// result.add(Arrays.asList(98, 218, 352, 389));
		// result.add(Arrays.asList(98, 218, 352, 389));
		// result.add(Arrays.asList(98, 218, 331, 410));
		// result.add(Arrays.asList(98, 218, 331, 410));
		// result.add(Arrays.asList(98, 218, 352, 389));
		// result.add(Arrays.asList(98, 218, 352, 389));
		// result.add(Arrays.asList(98, 218, 331, 410));
		// result.add(Arrays.asList(98, 218, 331, 410));
		// result.add(Arrays.asList(98, 218, 352, 389));
		




 	// Collections.sort(result, (x, y) -> {
  //           if (x.get(0) != y.get(0)) {
  //           //	System.out.println("here0");
  //               return x.get(0) - y.get(0);
  //           }
            
  //           if (x.get(1) != y.get(1)) {
  //           //	System.out.println("here1: " + x.get(1) + " " + x.get(1).getClass() + " " + y.get(1) + " " + y.get(1).getClass() + " " + !x.get(1).equals(y.get(1)));
  //               return x.get(1) - y.get(1);
  //           }
            
  //           if (x.get(2) != y.get(2)) {

  //           //	            System.out.println("here2");
  //               return x.get(2) - y.get(2);
  //           }
            


  //           return x.get(3) - y.get(3);
            
  //       });
         
  //       for (List<Integer> item : result) {
  //           System.out.println(Arrays.toString(item.toArray()));
		// }


		// String test = "2";

		// System.out.println(test.getBytes(Charset.forName("UTF-8")).length);

		// for(byte result : test.getBytes(Charset.forName("UTF-8"))) {
		// 	System.out.print(result + ":");
		// }

		// System.out.println();


		
		// System.out.println(test);

		// System.out.println(test.charAt(0));

		// try {
		// 	throw new RuntimeException("first");
		// }
		// catch (IllegalArgumentException e) {
		// 	System.out.println("IllegalArgumentException" + e);
		// 	throw new ArrayIndexOutOfBoundsException("abcd");
		// }
		// catch(Exception e) {
		// 	System.out.println("I am here Exception hello" + e);
		// }	

		// System.out.println("abcd");
		// Integer a = 1;
		// System.out.println(a);

		// HashMap<Integer, String> result = new HashMap<>();

		// result.put(1, "20");

		// System.out.println(result.get(1));


		// for(HashMap.Entry entry : result.entrySet()) {
		// 	System.out.println(entry.getKey() + "," + entry.getValue());
		// }

		// Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

		// pq.offer(1);
		// pq.offer(2);

		// System.out.println(pq.poll());
	}
}