package com.lc.patterns;

public class ValidPalidromeAlmost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String inputString="A man, a plan, a canal: Panama";
		String inputString="abcdddba";
		System.out.println(" Is Palndrome:"+isPalindromeAlmost(inputString));
	}
 
	
	 public static boolean isPalindromeAlmost(String s) {
		 boolean isPalindrome=true;
		
		 if(isPalindrome(s))
			 return true ;
		 int leftPointer=0;
	     int rightPointer =s.length() -1;
	     while(leftPointer<=rightPointer)
	     {
	    	 if(s.charAt(leftPointer) != s.charAt(rightPointer))
	    	 {
	    		 return isPalindromeSubString(s,leftPointer+1,rightPointer) || isPalindromeSubString(s,leftPointer,rightPointer-1);
	    	 }
	    	 else
	    	 {
	    		 leftPointer++ ;
	    		 rightPointer--;
	    		 
	    	 }
	     }
	 return isPalindrome;
	 }
	 
	 public static boolean isPalindromeSubString(String s,int left, int right ) { 
		
		 while(left<right)
		 {
			 if(s.charAt(left) != s.charAt(right))
					 {
				 		return false;
					 }
			 else 
			 {
				 left++;
				 right --;
			 }
		 }
		 return true;
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
