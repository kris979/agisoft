package interview;

public class StringQ {

	public static void reverse(char[] a, int i, int j) {
		if (i < j) {
			char tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			reverse(a, ++i, --j);
		}
	}
	
	public static void main(String[] args) {
		String s = "super";
		char[] charArray = s.toCharArray();
		System.out.println(charArray);
		reverse(charArray, 0, charArray.length-1);
		System.out.println(charArray);
	}
}
