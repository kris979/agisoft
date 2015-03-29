package com.agisoft.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sets don't allow duplicates.
 * 
 * HashSet - unordered, unsorted set. It uses a hashCode() of the object being inserted
 * 			 so make it as efficient as possible.
 * 			 Use it when you dont want duplicates and you don't care about the order when
 * 			 you iterate through it.
 *
 *LinkedHashSet - ordered version of HashSet. Maintains doubly-linked list across all elements.
 *				  Use it when you care about the iteration order. It lets you iterate over
 *				  elements in the order they were inserted.
 *
 *TreeSet  - sorted!!! guarantees that the elements will be in ascending order,
 *			 according to natural order. Inserted elements must implement java.lang.Comparable
 *
 */
public class PractiseSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PractiseSets c = new PractiseSets();
		c.testHashSet();
//		c.testLinkedHashSet();
//		c.testTreeSet();
	}

	
	void testHashSet() {
		Set<String> hs = new HashSet<String>();
		//easy 
		hs.add("Krzysztof");   //easy to add stuff to the set
		hs.add("Bliszczak");
		hs.add("Krzysztof");   //this wont be repeated so the size stays 2
//		hs.add(null);          // we can add null to set but will fail while iterating over
//		hs.add(1);             // in java 5 we could add 1 but in 6 with generics <> compiler will produce an error.

		System.out.println(hs.size());

		//we dont know what the order is going to be....
		System.out.println(hs.toString());
		 
		 String s = new String("kupa");
		 hs.add(s);
		 System.out.println(hs.toString());
		 hs.remove(s);
		 System.out.println(hs.toString());
		 
		 //to retrieve we either should use iterator or array 
		 Object[] sa = hs.toArray();
		 System.out.println(sa.length + " " + sa[0]);
		 
		 Iterator<String> i = hs.iterator();
		 while (i.hasNext()) {
		     String s1 = i.next();
		     System.out.println(s1);
		     if (s1.equals("Bliszczak")) i.remove();
		 }
		 while (i.hasNext()) {
             System.out.println(i.next());
		 }
		 
	}
	
	void testLinkedHashSet() {

		System.out.println("LinkedHashSet");
		//HashSet is printing Bliszczak, Krzysztof but LinkedHashSet is printing Krzysztof,Bliszczak
		//exacly the same order as we inserted them
		Set<String> lhs = new LinkedHashSet<String>();
		lhs.add("Krzysztof");
		lhs.add("Bliszczak");
		lhs.add("Anusiak");
		lhs.add("Krzysztof");
		
		System.out.println(lhs.size());
		for (String string : lhs) {
			System.out.println(string);
		}
	}
	
	void testTreeSet() {
		System.out.println("TreeHashSet");
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("Krzysztof");
		treeSet.add("Bliszczak");
		treeSet.add("Anusiak");
		treeSet.add("Krzysztof");
		
		System.out.println(treeSet.size());
		
		for (String string : treeSet) {
			System.out.println(string);
		}
	}
	
}


