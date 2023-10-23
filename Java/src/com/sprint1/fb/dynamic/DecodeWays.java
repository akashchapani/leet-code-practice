package com.sprint1.fb.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
 //Leetcode 91 
	/*'A' -> "1"
'B' -> "2"
...
'Z' -> "26" */
	//Given a string s containing only digits, return the number of ways to decode it.
	
/*	Enter recursion with the given string i.e. start with index 0.

	For the terminating case of the recursion we check for the end of the string. If we have reached the end of the string we return 1.

	Every time we enter recursion it's for a substring of the original string. For any recursion if the first character is 0 then terminate that path by returning 0. Thus this path won't contribute to the number of ways.

	Memoization helps to reduce the complexity which would otherwise be exponential. We check the dictionary memo to see if the result for the given substring already exists.

	If the result is already in memo we return the result. Otherwise the number of ways for the given string is determined by making a recursive call to the function with index + 1 for next substring string and index + 2 after checking for valid 2-digit decode. The result is also stored in memo with key as current index, for saving for future overlapping subproblems.
*/		
	  Map<Integer,Integer> memoMap =new HashMap();
	    public int numDecodings(String s) {
	        
	     return   decodeRecursion(0, s);
	        
	    }
	    //Topdown DP solution 
	    public int decodeRecursion(int index, String s)
	    {   //System.out.println("Index Value is :"+ index);
	       
	        if(memoMap.containsKey(index))
	        {
	            return memoMap.get(index);
	        }
	    // Check if index hitting upper limit
	         if(index == s.length())
	        {
	            return 1;
	        
	        }
	      //   System.out.println("charAt Value is :"+ s.charAt(index));
	         
	      //If 0 then return 0
	       if(s.charAt(index) == '0')
	        {
	            return 0;
	        }
	        // not 0 value return 1 possibility 
	        if(index == s.length()-1)
	        {
	            return 1;
	        
	        }
	       
	         
	        int ans = decodeRecursion(index+1,s);
	        
	        if( Integer.parseInt(s.substring(index, index+2)) <=26)
	        {
	            ans +=decodeRecursion(index+2,s);
	        }
	        
	        memoMap.put(index,ans);
	         return ans;
	    }
	    
	    public static void main(String args[])
	    { 
	    	DecodeWays DW= new DecodeWays();
	  //  System.out.println("For 12:"+  DW.numDecodings("12"));
	    System.out.println("For 326:"+  DW.numDecodings("0"));
	    System.out.println("For 326 iterativDecode:"+  DW.iterativDecode("326"));
	    }
	    
	    //bottomUp SOlution
	    public int iterativDecode(String s)
	    {
	    	
	    	int []dp =new int[s.length()+1];
	    	dp[0] =1;
	    	dp[1] = s.charAt(0)=='0' ? 0:1; 
	    	
	    	for(int i=2; i<=s.length(); i++)
	    	{
	    		System.out.println("s.substring(i-1, i) :"+s.substring(i-1, i));
	    		System.out.println("s.substring(i-2, i) :"+s.substring(i-2, i));
	    		int oneDigit = Integer.parseInt(s.substring(i-1, i));
	    		int TwoDigit = Integer.parseInt(s.substring(i-2, i));
	    		
	    		if(oneDigit >=1)
	    		{
	    			dp[i] += dp[i-1];
	    		}
	    		if(TwoDigit >=10 && TwoDigit <= 26)
	    		{
	    			dp[i] += dp[i-2];
	    		}
	    	}
	    	System.out.println("DP Array is :" +Arrays.toString(dp));
	    	return dp[s.length()];
	    }
	    
	
}
