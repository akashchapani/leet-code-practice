package com.sprint1.fb.dynamic;

import java.util.List;

public class WordBreak {
	
	  
    public boolean wordBreak(String s, List<String> wordDict) {
       //  Map<String,boolen> memoMap=newHashMap();
        return recursiveWordBreak ( s,wordDict,0);
        
    }
    
    public boolean recursiveWordBreak ( String s, List<String> wordDict,int index)
    {
       boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
   
        for(int i=1 ; i<=s.length(); i++)
        {
            for(int j=index; j<i; j++)
            {
                String substring= s.substring(j,i);
                if(wordDict.contains(substring) && dp[j])
                   {
                       dp[i] = true;
                       break;
                   }
            }
        }
        return dp[s.length()];
        
    }

}
