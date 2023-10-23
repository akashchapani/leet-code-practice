package com.sprint1.fb.dynamic;

public class LongestValidParanthesis {

    public int longestValidParentheses(String s) {
        int []dp=new int[s.length()];
        int maxLen=0;
        for(int i=1; i<s.length(); i ++)
        {
           if( s.charAt(i) == ')')
           {
               if(s.charAt(i-1) == '(')
               {
                   dp[i] = (i>2  ? dp[i-2]  : 0) + 2;
               }
               else if(i-dp[i-1] >0 && s.charAt(i-1-dp[i-1]) == '(')
               {
                   int j =  i-1 -dp[i-1];
                   
                       dp[i] = dp[i-1]  + ( j-1 >0 ? dp[j-1] : 0) +2;
                   
               }
           }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen ;       
    }
}
