	package stringpractise;


public class PractiseStringAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    testFormatting();
		test1();
		test2();
		test3();
		test4();
	}
	
	static void testFormatting() {
	    StringBuffer b = new StringBuffer("hello");
	    StringBuffer c = b;
	    if (b == c) {
	        System.out.println(true);
	    }
	}
	
	
	static void test1() {
		String s1 = "kris";
		s1.concat("dupa"); //this has no effect on s1 because there is no assignment  and "kris dupa" is lost
		System.out.println(s1);
	}
	
	static void test2() {
		String s1 = "kris";
		int length = s1.length(); //string length() is not array .length 
		
		System.out.println(length);
		
		System.out.println(s1.charAt(3)); //index 3 is character s becasue counting starts from 0
		
		System.out.println(s1.toUpperCase()); //does not assign string back to s1 
		System.out.println(s1); //therefore this print lower case "kris" instead of "KRIS"
		
		s1 = s1.toUpperCase();
		System.out.println(s1);
		
		s1 = s1.toLowerCase();
		System.out.println(s1);
	}
	
	static void test3() {
		//creates real string object instead of a literal in the JVM string pool
		String s = new String("to jest moj before"); //actually it creates two objects: litaral and String 
		System.out.println("before: " + s);
		
		s = s.replace("before", "after");
		System.out.println("after: " + s);
	}

	static void test4() {
		String s = new String("to jest moj before"); 
		s.concat("sdfsdfsfsdfsdfs");
		String s2 = s.substring(2,7); //2 is zero indexed, 7 is not therefore it will return "jest"
		System.out.println(s2);
	}
	
}
