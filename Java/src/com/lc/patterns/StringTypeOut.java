package com.lc.patterns;

import java.util.ArrayList;
import java.util.Stack;

public class StringTypeOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //Input String S1: ab#c and T1 :ad#c   should return true considering # as backspace
		String S1= "ab##";
		String T1 = "c#d#";
		
		System.out.println ("Optimal Solution Equal tru or false : " +backspaceCompare(S1,T1));
		//BuildStringMethod to perform trimming
		  S1= BuildStringMethod(S1);
		  T1= BuildStringMethod(T1);
		  if(S1.equals(T1))
		  {
			  System.out.println("Strings are equal");
		  }
		  else 
			  System.out.println("Strings are NOT equal");
		  
 
	}
	
	//Optimal Solution  traverse back to identify back space
	  public static boolean backspaceCompare(String S, String T) {
	        int i = S.length() - 1, j = T.length() - 1;
	        int skipS = 0, skipT = 0;

	        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
	            while (i >= 0) { // Find position of next possible char in build(S)
	                if (S.charAt(i) == '#') {skipS++; i--;}
	                else if (skipS > 0) {skipS--; i--;}
	                else break;
	            }
	            while (j >= 0) { // Find position of next possible char in build(T)
	                if (T.charAt(j) == '#') {skipT++; j--;}
	                else if (skipT > 0) {skipT--; j--;}
	                else break;
	            }
	            // If two actual characters are different
	            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
	                return false;
	            // If expecting to compare char vs nothing  //Edge case 
	            if ((i >= 0) != (j >= 0))
	                return false;
	            i--; j--;
	        }
	        return true;
	    }
	

		
		// O(M+N)  time with O(M+N) space 
	private static String BuildStringMethod(String s1) {
		//Character []chArray = new Character[s1.length()];
		Stack charArray =new Stack();
		int j=0;
		// TODO Auto-generated method stub
		for(int i=0; i<s1.length(); i++)
			if(s1.charAt(i) !='#')
				charArray.push(s1.charAt(i));
			else 
				charArray.pop();
		return charArray.toString();
	}

}
