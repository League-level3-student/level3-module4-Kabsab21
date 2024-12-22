package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<String> ending = new Stack<String>();
  
    	

    	
    	for( int i = 0; i < b.length(); i++) {
    	
    		String ring = Character.toString( b.charAt(i));
    		if( i==0 && ring.equals("}")) {
    			return false;
    		}
    		if( ring.equals("{")) {
    				System.out.println(ring);
    		ending.push( ring );
    		} else if( ring.equals("}")) {
    			System.out.println(ring);
    			ending.pop();
    	
    		}
    	
        	
    	
    }
    	if( ending.size() > 0){
    		System.out.println("false");
    		return false;
    	} else {
    		System.out.println("true");
    	return true;
    	}

    	
}
}