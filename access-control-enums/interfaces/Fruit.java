package interfaces ;

import java.io.IOException;

public class Fruit {
    
    protected int x = 2; //default access
	
	public void print() throws IOException  {
		System.out.println("This is a fruit's print method.");
		throw new IOException();
	}

	public static void main(String[] args) throws Exception {
	    
	    //any local variable must be initialized before it is used!
	    
	    final int i;
	    i = 40;
	    System.out.println(i);
	    
	    final int j = 10;
	    
    }
}

