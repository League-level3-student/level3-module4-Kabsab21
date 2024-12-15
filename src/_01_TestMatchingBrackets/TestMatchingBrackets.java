package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	boolean com = false;
    	Stack<String> ending = new Stack<String>();
    	String one;
    	String two;
    	String first;
    	String last;
    	
    	if( b.length()%2 != 1) {
    		return false;
    	}
    	
    	for( int i = 0; i < b.length(); i++) {
    		String ring = Character.toString( b.charAt(i));
    		System.out.println(ring);
    		ending.push( ring );
    		}
    	
    	
    	while( ending.size() > 1){
    		
    		if( ending.size() == 1) {
	    		last = ending.pop();
	    		first = ending.pop();
	    		
	    		
	    		if( first.equals("{")&& last.equals("}")) {
	    			com = true;
	    			
	    		} else if( last.equals("{") && first.equals("}")) {
	    			com = true;
	    			
	    		}
	    		
    		} else if( ending.size() == 3) {
        		last = ending.pop();
        		one = ending.pop();
        		two = ending.pop();
        		first = ending.pop();
        		
        		
        		if( first.equals("{")&& last.equals("}")) {
        			com = true;
        			
        		} else if( last.equals("{") && first.equals("}")) {
        			com = true;
        			
        		}
        		if( one.equals("{")&& two.equals("}")) {
        			com = true;
        			
        		} else if( two.equals("{") && one.equals("}")) {
        			com = true;
        			
        		}
      	}
        		
    		
    	}
    System.out.println(com);
        return com;
    }
}