public class Algorithms {

	public static final int NOT_FOUND = -1;

	public static int getFirstElement(int[] arr) {
		return arr[0];
	}

	//This algorithm runs in O(1) (constant) time, because the running time is not related to the input size.

	public static int linearSearch(int[] arr, int target) {
		for(int i=0; i<arr.length; i++)
			if(arr[i]==target)
				return i;
		return NOT_FOUND;
	}

	//Best Case: arr[0]=target, which yields O(1) running time.
	//Worst case: arr[arr.length-1] = target or not found.  yields O(n) (linear) time.
	//Average case: (1/n) (1 + 2 + 3 + .. + n) = (1/n) (n(n+1)) / 2 = (n+1)/2 = O(n).


	public static int binarySearch(int[] arr, int target) {

		int start = 0, end = arr.length-1;

		while(start <=end) {

			int mid = (start + end)/2;

			if(arr[mid]==target)
				return mid;

			else if (target < arr[mid])
				end = mid-1;
			else
				start = mid+1;

		}

		return NOT_FOUND;
	}

	/* Recurrence : T(n) = T(n/2) + 1 			;; T(1) = 1
			     = T(n/4) + 1 + 1
			     = T(n/8) + 1 + 1 + 1
                             ....

             after k times: = T(n/2^k) + k.

             We wish n/2^k = 1 --> n = 2^k ---> k = log_2 n

                            = T(1) + log_2 n = 1 + log_2 n = O(log_n).

        */

        public static int sumMatrix(int[][] matrix) {

		int sum = 0;

                for(int row = 0; row < matrix.length; row++)
			for(int col = 0; col < matrix[row].length; col++)

				sum+= matrix[row][col];
		return sum;
	}

	//For matrix_(n x m), this algorithm runs in O(nm) time. If n = m, then we can say O(n^2).



	public static void main(String[] args) {

		int[] arr = new int[100000000];

		java.util.Random random = new java.util.Random();
		for(int i=0; i<100000000; i++)
			arr[i] = random.nextInt();

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		char ch;
	       do {


			int target = random.nextInt();

			long startTime = System.currentTimeMillis();

			int ans = binarySearch(arr, target);

			long finishTime = System.currentTimeMillis();

			double seconds = (finishTime-startTime) / 1000.0;

			System.out.println("Binary Search took " + seconds + " seconds");

			startTime = System.currentTimeMillis();

			ans = linearSearch(arr, target);

			finishTime = System.currentTimeMillis();

			seconds = (finishTime - startTime) / 1000.0;

			System.out.println("Linear search took " + seconds + " seconds");

			System.out.println();

			System.out.print("Do you want to continue?");

			ch = scanner.next().charAt(0);

		}while(Character.toLowerCase(ch)=='y');

	}
}
