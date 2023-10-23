package com.sprint0.wf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"],
		//keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
	//			Output: ["daniel"]
	}
	
	  public static List<String> alertNames(String[] keyName, String[] keyTime) {
		List <String>result =new ArrayList<String>();
		Map <String,List<Integer>> KeyNametoTimeMap= new HashMap<String, List<Integer>>();
		int derivedtime=0;
		for(int i=0 ; i <keyName.length; i ++)
		{
			
		List timeline=	KeyNametoTimeMap.getOrDefault(keyName[i], new ArrayList<Integer>());
			derivedtime=getDerivedTime(keyTime[i]);
			timeline.add(derivedtime);
			KeyNametoTimeMap.put(keyName[i],timeline);
			
		}
		
		for(String key :KeyNametoTimeMap.keySet() )
		{
			List<Integer> keylist = KeyNametoTimeMap.get(key);
			Collections.sort(keylist);
			for(int i=2; i<keylist.size(); i ++)
			{
				if(keylist.get(i)- keylist.get(i-2) <= 60 ) {
					result.add(key);
				break;
				}
			}
		}
		Collections.sort(result);
		return result;
		  
	        
	    }

	private static int getDerivedTime(String string) {
		// TODO Auto-generated method stub
		String [] time = string.split(":");
		
		return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
	}

}
