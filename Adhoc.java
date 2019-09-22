import java.util.*;

class Adhoc {

	static class Node {

		int val;

	}

	public static void main(String[] args) {

		// TreeSet<Node> set = new TreeSet<>((x, y) -> x.val - y.val);

		// set.add()


		System.out.println(Arrays.asList(new int[] {1, 2,3}));

		System.out.println((int)'A');

		System.out.println("".isEmpty	());



		char a = 'b';
		Character b = 'b';

		System.out.println(a);
		System.out.println(b);


		// int[] a = new int[] {1, 2, 3};
		// int[] b = new int[] {1, 2, 3};

		// System.out.println(a.equals(b));

		// List<Integer> list = new ArrayList<>();
		// list.add(1);
		// list.add(2);
		// List<Integer> secondList = new ArrayList<>();
		// secondList.add(1);
		// secondList.add(2);

//		System.out.println(list == secondList);
//		System.out.println(list.equals(secondList));


		// TreeSet<Integer> set = new TreeSet<>();
		// set.add(3);
		// set.add(1);
		// set.add(2);

		// System.out.println(set.first());
		// System.out.println(set.last());
		// System.out.println(set.floor(1));
		// System.out.println(set.lower(1));
		// System.out.println(set.higher(1));
		// System.out.println(set.ceiling(1));

		LinkedList<Integer> list = new LinkedList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2,111);
		//System.out.println(list.getFirst());
		// System.out.println(list.peekFirst());
		// System.out.println(list.peekLast());
		// System.out.println(list.pollFirst());
		// System.out.println(list.pollLast());
		System.out.println(list.contains(3));
		System.out.println(list.contains(22222));
		System.out.println(list.get(0));

		System.out.println(list.getLast());
		System.out.println(list.toString());



		TreeMap<Integer, Integer> map = new TreeMap<>();

		map.put(1, 2);
		map.put(2, 4);
		map.put(3, 5);
		map.put(5, 1);

		System.out.println(map.toString());

		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

		// for(Map.Entry<Integer, Integer> entry : entrySet) {
		// 	System.out.println(entry.getKey());
		// }

		System.out.println(map.floorEntry(2).getKey());

		System.out.println(map.firstEntry().getKey());
		//System.out.println(map.floorEntry(0).getKey());
		System.out.println(map.subMap(1, 2).size());


		// System.out.println(Thread.currentThread().getName());
	 //    Thread.currentThread().interrupt();

		// int[] result = new int[10];

		// String a = "abc";
		// String b = "ab" + "c";

		// System.out.println(a == b);
		// List<Integer>[] a = new List[3];
		// a[0] = new ArrayList<Integer>();
		// a[0].add(1);
		// a[0].add(2);

		// System.out.println(a[0].toString());

		// Random random = new Random();
		// for(int i = 0; i < 10; i++) {
		// 	System.out.println(random.nextInt(10) + 1);
		// }

		// StringBuilder builder = new StringBuilder();
		// builder.append("a");

		// builder.append("b");

		// builder.deleteCharAt(builder.length() - 1);

		// System.out.println(builder.toString());


		// int[][] result = new int[][] {{1, 2, 3}, {2,2}};

		// System.out.println(result[0].length + " " + result[1].length);


		// Set
		// String a = "a";
		// String b = "b";

		// System.out.println(a.equals(b));

		// char a = '2';
		// System.out.println(a);
		// Character ab = '2';
		// System.out.println(a == ab);

		// Boolean boolType = false;

		// System.out.println(boolType);
		// System.out.println(boolType);


		// Set<Integer> test = new HashSet<>();

		// test.add(1);
		// test.add(2);
		// test.add(3);
		// test.remove(1);
		// System.out.println(test.contains(2));
		// System.out.println(test.contains(1));

		// Integer[] b = new Integer[1];
		// b[0] = 1;

		// System.out.println(b[0] + " b[0]");

		// Integer[] result = test.toArray(new Integer[0]);

		// for(int item : result) {
		// 	System.out.println(item);		
		// }
		// List c =  Arrays.asList(1,2,3);



		// System.out.println(c.get(1) + "Arrays.asList" + c.getClass());



		// 




		// String a = "abc";
		// String c = "c";

		// int maxValue = Integer.MIN_VALUE;
		// int one = Integer.MIN_VALUE;

		// System.out.println(2/3);
		// System.out.println((maxValue+one)>>>1);

		// String b = "ab" + c;

		// System.out.println(a == b);

		// for(char item : a.toCharArray()) {
		// 	System.out.println(item);
		// }

		// for(int i = 0; i < a.length(); i++)
		// 	System.out.println(a.charAt(i));

		// System.out.println(a.substring(1, 3));

	}
}


