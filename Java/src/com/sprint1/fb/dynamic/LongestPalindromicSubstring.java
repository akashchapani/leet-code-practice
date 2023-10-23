package com.sprint1.fb.dynamic;

public class LongestPalindromicSubstring {
	   int maxLen=0;
	    int start=0;
	    
	    public String longestPalindrome(String s) {
	        //babad
	        
	        if(s==null || s.length()==0)
	        {
	            return null;
	        }
	        //"cbbd"
	        for( int i=0; i<s.length(); i++)
	        {
	            expandAroundCenter(i,i,s);
	            expandAroundCenter(i,i+1,s);
	        }
	        return s.substring(start,start+maxLen);
	    }
	    
	    public void expandAroundCenter( int i, int j ,String s)
	    {
	        while(i>=0 && j< s.length() && s.charAt(i)== s.charAt(j))
	        {
	            i--;
	            j++;
	        }
	      
	      
	        
	        if(maxLen<j-i-1)
	        {
	            start = i+1;
	            maxLen =j-i -1 ;
	        }
	                
	    }
}
