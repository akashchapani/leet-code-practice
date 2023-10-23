package com.lc.playground;

import java.util.ArrayList;
import java.util.List;

public class ClickStream {

	public static void main(String[] args) {
		/*

		We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

		Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

		Sample input:

		user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
		user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
		user2 = ["a", "/one", "/two"]
		user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
		user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
		user5 = ["a"]
		user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]
		*/
	 String []      user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
	 String []		user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
	 String []		user2 = {"a", "/one", "/two"};
	 String []		user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
	 String []		user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
	 String []	    user5 = {"a"};
	 String []		user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};
		
		
		
		   System.out.println("TC1 : " +    findContiguousHistory(user0, user1)) ; //["/pink", "/register", "/orange"]
		   System.out.println("TC2 : " +	findContiguousHistory(user0, user2)); // [] (empty)
		   System.out.println("TC3 : " +	findContiguousHistory(user2, user1)) ;// ["a"] 
		   System.out.println("TC4 : " +	findContiguousHistory(user5, user2)) ;// ["a"]
		   System.out.println("TC5 : " +	findContiguousHistory(user3, user4)) ;// ["/plum", "/blue", "/tan", "/red"]
		   System.out.println("TC6 : " +	findContiguousHistory(user4, user3)) ; //["/plum", "/blue", "/tan", "/red"]
		   System.out.println("TC7 : " +	findContiguousHistory(user3, user6)) ;// ["/tan", "/red", "/amber"]

	}

	private static List<String>   findContiguousHistory(String[] user0, String[] user1) {
		// TODO Auto-generated method stub
		
		List<String> result = new ArrayList<String>() ;
		int[][] dp= new int[user0.length+1][user1.length+1];
		int maxlen=0,startindex=0;
		
		for( int i=user0.length-1;  i>=0;  i--)
		{
			for(int j=user1.length-1; j>=0; j--)
			{
				if (user0[i] == user1[j])
				{
					dp[i][j] =1+dp[i+1][j+1];
					
					if(dp[i][j]>maxlen)
					{
					 startindex=i;
					 maxlen =dp[i][j];
					}
					
				}
			}
		}
		for(int i=startindex; i<startindex+maxlen; i++)
		{
			result.add(user0[i]);
		}
		
		return result;
		
		
	}

}
