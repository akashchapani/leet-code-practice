package com.sprint1.wf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//["9001 discuss.leetcode.com"]
		//["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
		//Output: 
//			["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
	String[] input = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
	
	System.out.println("Result for TC 1 is : "+subdomainVisits(input).toString());
	
	}
	
	
	 public static List<String> subdomainVisits(String[] cpdomains) {
	        List<String> result = new ArrayList<String>();
	        Map<String, Integer> domainMap = new HashMap<String,Integer>();
	        if(cpdomains.length ==0 )
	        	return result;
	        System.out.println("I am here");
	        for(int i=0; i<cpdomains.length; i++)
	        {    String current = "";
	        	String [] domains = cpdomains[i].split("\\s+");
	        	int count = Integer.parseInt(domains[0]); //9001
	        	String[] subdomains= domains[1].split("\\.");  //leetcode.com
	        	
	        	for(int j=subdomains.length-1; j>=0; j-- )
	        	{    
	        		current = subdomains[j] + (j<subdomains.length-1? ".":" ") +current;
	        	//	current= (j<subdomains.length-1)? subdomains[j]+"."+current:current;
	        		System.out.println("current is"+current);
	        		domainMap.put(current, domainMap.getOrDefault(current, 0) +count);
	        	}
	        }
	        for(String key:domainMap.keySet())
	        	result.add(" "+key+"  " +domainMap.get(key));
	        return result;
	    }

}
