public class TestSentinel {

	public static void main(String[] args) {
		SentinelLink<Integer> list = new  SentinelLink<Integer>();



			list.addFirst(5);
			list.addFirst(3);
			list.addFirst(6);
			list.addFirst(9);
			System.out.println("size: " + list.size());


			list.print();

	}

}
