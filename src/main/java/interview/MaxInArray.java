package interview;


public class MaxInArray {

	public static void main(String[] args) {
		
		int[] a = {3,234,2,4,3,5345,345,3,2,34,24,23,4,234,23,2,5,43,5,34};
		int sum1 = 0;
		for (int i = 0; i < a.length; i++) {
			sum1+=a[i];
		}
		System.out.println(sum1);
		int sum = sum(a,0,a.length-1);
		System.out.println(sum);
	}

	private static int sum(int[] a, int i, int j) {
		if (i < j) {
			int sum = a[i] + a[j];
			return sum + sum(a, ++i, --j);
		} else {
			return 0;
		}
	}
}
