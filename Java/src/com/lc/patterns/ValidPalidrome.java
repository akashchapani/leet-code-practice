package com.lc.patterns;

public class ValidPalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String inputString="A man, a plan, a canal: Panama";
		String inputString="asdsa";
		System.out.println(" Is Palndrome:"+isPalindrome(inputString));
	}
 
	   public static boolean isPalindrome(String s) {
		   boolean isPalindrome=true;
		  // Input: "A man, a plan, a canal: Panama"
			 //  Output: true
		  // Input: "race a car"
			//   Output: false
		  
		  String inputString= s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		   System.out.println("inputString: " +inputString);
		   //AmanaplanacanalPanama
		     int leftPointer=0;
		     int rightPointer =inputString.length() -1;
		     while(leftPointer <= rightPointer)
		     {
		    	 if(inputString.charAt(leftPointer)== inputString.charAt(rightPointer))
		    	 {  leftPointer++;
		    	  rightPointer--; 
		    	 }
		    	 else
		    	 {
		    		 return false ;
		    	 }
		     }
		return isPalindrome;
	        
	    }
}
