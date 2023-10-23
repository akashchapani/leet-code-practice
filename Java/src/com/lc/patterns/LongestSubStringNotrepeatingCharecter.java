package com.lc.patterns;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNotrepeatingCharecter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input: s = "abcabcbb"
		//		Output: 3
		
		String  s = "abcabcbbxxxxxfghijklm";
		System.out.println( "Length of String is :"+lengthOfLongestSubstring(s));
		System.out.println( "Length of String is :"+lengthOfLongestSubstring_option2(s));
     
	}
	
	// Space O(1) and time O(n^2)
    public static int lengthOfLongestSubstring(String s) {
    	
     int maxlen=0;
     int len= s.length();
     int countlen;
     Set set = null;
     for(int i=0; i<len; i++)
     {   set =new HashSet<>();
      
        set.add(s.charAt(i));
        countlen=1;
    	 for(int j=i+1; j<len;  j++)
    	 { 
    		if(set.contains(s.charAt(j)))
    		{System.out.println("charecter is:"+s.charAt(j)+" Of String:"+s);
    			break;
    			
    		}
    		else 
    			{ set.add(s.charAt(j));
    			countlen++;
    			}
    		 
    	 }
    	 maxlen =Math.max(maxlen, countlen);
     }
    	return maxlen;
        
    }
    
    public static int lengthOfLongestSubstring_option2(String s) {
    	
    	int maxlen=0;
    	int leftPointer=0;
    	int rightPointer=0;
    	int strLength= s.length();
    	Set charSet ;
    	//Input: s = "abcabcbb"
    	 
    
    	              
    	  // check if char(r) is same as char(l)
    	charSet =new HashSet();
    	while(leftPointer<strLength && rightPointer <strLength)  //abcabcbb   3<8
    	{  
    		if(!charSet.contains(s.charAt(rightPointer)))
    		{
    			charSet.add(s.charAt(rightPointer++));
    			maxlen= Math.max(maxlen,rightPointer-leftPointer);
    		}
    		else {
    			charSet.remove(s.charAt(leftPointer++));
    		}
    	}
    	
    	return maxlen;
    	
    }


}
