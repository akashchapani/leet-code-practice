	package com.sprint1.wf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



public class BadgeSecuritySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * We want to find employees who badged into our secured room unusually often.
		 * We have an unordered list of names and entry times over a single day. Access
		 * times are given as numbers up to four digits in length using 24-hour time,
		 * such as "800" or "2250".
		 * 
		 * Write a function that finds anyone who badged into the room three or more
		 * times in a one-hour period, and returns each time that they badged in during
		 * that period. (If there are multiple one-hour periods where this was true,
		 * just return the first one.)
		 * 
		 * badge_times = [ ["Paul", 1355], ["Jennifer", 1910], ["John", 830], ["Paul",
		 * 1315], ["John", 1615], ["John", 1640], ["John", 835], ["Paul", 1405],
		 * ["John", 855], ["John", 930], ["John", 915], ["John", 730], ["Jennifer",
		 * 1335], ["Jennifer", 730], ["John", 1630], ] Expected output (in any order)
		 * John: 830 835 855 915 930 Paul: 1315 1355 1405
		 */
		
		String [] []badge_times = {
				{"Paul", "1355"},
				{"Jennifer", "1910"},
				{"John", "830"},
				{"Paul", "1315"},
				{"John", "1615"},
				{"John", "1640"},
				{"John", "835"},
				{"Paul", "1405"},
				{"John", "855"},
				{"John", "930"},
				{"John", "915"},
				{"John", "730"},
				{"Jennifer", "1335"},
				{"Jennifer", "730"},
				{"John", "1630"},
		};
		
		 Map<String, Set<Integer>> result= findMultiEntrynames(badge_times);
		System.out.println("Result is -->" +result);
		
	 result= findMultiEntrynames(null);
			System.out.println("Result for null is -->" +result);
	
	}

	private static  Map<String, Set<Integer>> findMultiEntrynames(String[][] badge_times) {
		// TODO Auto-generated method stub
		Map<String,Set<Integer>> result= new HashMap<String,Set<Integer>>();
		
        Map<String,List<Integer>> nametoEntryMap= new HashMap<String,List<Integer>>();
        String name="";
        int time=0;
        List<Integer> timeList= new ArrayList<Integer>();
        
        if(badge_times == null || badge_times[0].length ==0 || badge_times.length ==0)
        	return result;
        	
        for(int i=0; i<badge_times.length; i++)
        {
        
         name = badge_times[i][0];
         time =Integer.parseInt(badge_times[i][1]);
     	
         timeList= nametoEntryMap.getOrDefault(name, new ArrayList<Integer>());
         timeList.add(time);
       
         nametoEntryMap.put(name, timeList);
        }
        
       System.out.println("Map is : " +nametoEntryMap);
        
       
		
        for(String namekey:nametoEntryMap.keySet())
        {  
        	Set<Integer> resulttielist= new TreeSet<Integer>();
        	timeList =	nametoEntryMap.get(namekey);
        	Collections.sort(timeList);
        	System.out.println(" Name is : " +namekey);
        	System.out.println(" timeList is : " +timeList);
        	for(int i=2; i<timeList.size(); i++)
        	{ 
        		if(timeList.get(i) - timeList.get(i-2) <=100 && timeList.get(i) - timeList.get(i-2) <=100 )
        		{
        			
        			resulttielist.add(timeList.get(i-2));
        			resulttielist.add(timeList.get(i-1));
        			resulttielist.add(timeList.get(i));
        			result.put(namekey,resulttielist);
        			
        		}
        	}
        }
		
        return result;
		
	}

}
