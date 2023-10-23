package com.sprint0.fb;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class WorkBreak {
	/*
	 *** 140. Word Break II**
	 * 
	 *  Given a string s and a dictionary of strings wordDict, add
	 * spaces in s to construct a sentence where each word is a valid dictionary
	 * word. Return all such possible sentences in any order.
	 * 
	 * Note that the same word in the dictionary may be reused multiple times in the
	 * segmentation.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"] Output:
	 * ["cats and dog","cat sand dog"] Example 2:
	 * 
	 * Input: s = "pineapplepenapple", wordDict =
	 * ["apple","pen","applepen","pine","pineapple"] Output:
	 * ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
	 * Explanation: Note that you are allowed to reuse a dictionary word.
	 */
	
    public List<String> wordBreak(String s, List<String> wordDict) {
    	List<String> result = new ArrayList<String>();
    	Map <String , List<String>> wordMap= new HashMap<String, List<String>>(); //Memoize;
    
    	result = wordBreakHelper(s,wordDict,wordMap);
    	return result;
        
    }
    
    public List<String> wordBreakHelper(String s, List<String> wordDict,Map<String, List<String>> wordMap)
    {
    	List<String> result = new ArrayList<String>();
    	
    	if(s.length() ==0)
    	{	result.add("");
    	    return result;
    	}
    	
    	if(wordMap.get(s) != null)
    	{
    		return wordMap.get(s);
    	}
    	
    	for(String word : wordDict)
    	{
    		if(s.startsWith(word))
    		{
    			String subString= s.substring(word.length());
    			
    			List<String> recSubString = wordBreakHelper(subString,wordDict,wordMap);
    			for(String recString: recSubString)
    			{  
    				String OptionalSpace = (recString.isEmpty() ? "" : " ");
    				result.add( word + OptionalSpace + recString );
    			}
    		}
    	}
    	
    	wordMap.put(s, result);
    	return result;
    }
    
    public static void main (String args[])
    {
    	WorkBreak wb = new WorkBreak();
       String s = "catsanddog";
       String[] wordDict = {"cat","cats","and","sand","dog"};
       List<String> result= wb.wordBreak(s,Arrays.asList(wordDict));
       result.forEach(System.out::println);
       
    	
    }

}
