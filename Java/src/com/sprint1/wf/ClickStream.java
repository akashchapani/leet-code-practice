package com.sprint1.wf;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class ClickStream {
	    public static void main(String[] argv) {
	        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
	        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
	        String[] user2 = {"a", "/one", "/two"};
	        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
	        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
	        String[] user5 = {"a"};
	        String[] user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};

	        System.out.println(findContiguousHistory(user0, user1));
	        System.out.println(findContiguousHistory(user0, user2));
	        System.out.println(findContiguousHistory(user2, user1));
	        System.out.println(findContiguousHistory(user5, user2));
	        System.out.println(findContiguousHistory(user3, user4));
	        System.out.println(findContiguousHistory(user4, user3));
	        System.out.println(findContiguousHistory(user3, user6));
	        System.out.println(findContiguousHistory(user5, user6));
	        System.out.println("------------------------------------");
	         
	        System.out.println(findContiguousHistoryDynamicProgram(user0, user1));
	        System.out.println(findContiguousHistoryDynamicProgram(user0, user2));
	        System.out.println(findContiguousHistoryDynamicProgram(user2, user1));
	        System.out.println(findContiguousHistoryDynamicProgram(user5, user2));
	        System.out.println(findContiguousHistoryDynamicProgram(user3, user4));
	        System.out.println(findContiguousHistoryDynamicProgram(user4, user3));
	        System.out.println(findContiguousHistoryDynamicProgram(user3, user6));
	        System.out.println(findContiguousHistoryDynamicProgram(user5, user6));


	    }

	    //Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both
	    //Longest contiguous sequence of URL is the key 
	    public static List<String> findContiguousHistory(String [] array1 , String [] array2)
	    {
	    	List<String> result = new ArrayList<String>();
	    	String[] longArray; String[] shortArray;
	    	Map<String, Integer> keyMap =new HashMap<String,Integer>();
	    	
	    	if( array1.length ==0  || array2.length ==0)
	    		return result;
	    	if(array1.length >array2.length)
	    	{
	    		longArray = array1;
	    	    shortArray= array2;	
	    	}
	    	else 
	    	{
	    		longArray = array2;
	    	    shortArray= array1;	
	    	}
	    	
	    	for(int i=0; i<longArray.length; i++)
	    	{
	    		keyMap.put(longArray[i],i);
	    	}
	    	
	    	for(int j=0; j<shortArray.length; j++)
	    	{
	    	  List<String> cur = new ArrayList();
	    	//	 String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
	 	      //  String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
	    	    String str= shortArray[j];
	    	    if(keyMap.containsKey(str))
	    	    {
	    		int index = keyMap.get(str);
	    		int k = j;
	    		while( index<longArray.length  && k <shortArray.length && longArray[index] == shortArray [k])
	    		{
	    			cur.add(longArray[index] );
	    			index++;
	    			k++;
	    		}
	    	   if(result.size() <cur.size() )
	    		   result =cur;
	    			
	    	    }
	    	}
	    	return result;
	    }
	    
	    // Key is to reverse travers the for loop from len-1 .
	    // dp[i][j] =dp[i+1][j+1]+1; 
	    
	    public static List<String> findContiguousHistoryDynamicProgram(String [] array1 , String [] array2)
	    {
	    	List<String> result = new ArrayList<String>();
	    	
	    	if(array1.length==0 || array2.length ==0)
	    		return result;
	    	int [][]dp=new int[array1.length+1][array2.length+1];
	    	int maxlen=0;
	    	int start=0;
	    	for(int i=array1.length-1; i>=0; i--)
	    	{
	    		for(int j=array2.length-1; j>=0; j--)
	    		{
	    			if(array1[i] ==array2[j])
	    			{
	    				dp[i][j] =dp[i+1][j+1]+1;
	    				if(dp[i][j] >maxlen)
	    				{
	    					maxlen=dp[i][j];
	    					start=i;
	    				}
	    				
	    			}
	    		}
	    	}
	    	for(int x=start; x<start+maxlen; x++)
	    	{
	    		result.add(array1[x]);
	    	}
	    	return result;
	    }
	   
	
	}
	    
	    


