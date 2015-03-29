        
public class StringReversalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		printOddNumbers(3, 23);
		testStringReversal();
		

	}
	
	static void testStringReversal() {
		String original = "tlusta dupa";
		String reverted = revertString(original);
		System.out.println(reverted);
		String back_to_original = revertString(reverted);
		System.out.println(back_to_original);
		if (original.equals(back_to_original)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
		
		System.out.println(revertString1(original));
	}

	static String revertString(String s) {
		String reverted = "";
		char[] tmp = s.toCharArray();
		for (int x = tmp.length-1; x > -1 ; x--) {
			reverted+=tmp[x];
		}
		return reverted;
	}
	
	static String revertString1(String s) {
		StringBuffer buff = new StringBuffer(s);
		return buff.reverse().toString();
	}
	
	
	static void printOddNumbers(int start, int end) {
		assert(start > end);
		if (start == end) {
			System.out.println("nothing to do");
		}
		for (int i = start; i < end; i++) {
			if (i%2 > 0) {
				System.out.println(i + " is an odd number");
			}
		}
	}
}
