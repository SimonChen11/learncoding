import java.util.*;

class TreeSetSample {

	static class Node {

		int val;
		int test;

		Node(int val, int test) {
			this.val = val;
			this.test = test;
		}

	}

	public static void main(String[] args) {

		System.out.println("12345".substring(0, 2));

		Integer[] test = new Integer[] {4, 2, 3};

		System.out.println(test.length);

		Arrays.sort(test);

		System.out.println(test[0]);

		List<Integer> newList = new ArrayList<>(Arrays.asList(test));

		System.out.println(newList.toString());



		Node a = new Node(2, 1);
		Node b = new Node(2, 2);

		TreeSet<Node> set = new TreeSet<>((x, y) -> x.val -y.val);

		set.add(b);
		set.add(a);

		System.out.println(set.contains(b));

		System.out.println(set.contains(a));

		System.out.println(set.first().test);

		System.out.println(a.equals(b));

		System.out.println(set.size());


  		




	}
}