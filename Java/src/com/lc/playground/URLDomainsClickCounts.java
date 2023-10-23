package com.lc.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class URLDomainsClickCounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * You are in charge of a display advertising program. Your ads are displayed on
		 * websites all over the internet. You have some CSV input data that counts how
		 * many times that users have clicked on an ad on each individual domain. Every
		 * line consists of a click count and a domain name, like this: counts = [
		 * "900,google.com", "60,mail.yahoo.com", "10,mobile.sports.yahoo.com",
		 * "40,sports.yahoo.com", "300,yahoo.com", "10,stackoverflow.com",
		 * "20,overflow.com", "5,com.com", "2,en.wikipedia.org", "1,m.wikipedia.org",
		 * "1,mobile.sports", "1,google.co.uk" ]
		 */
   String []counts = {
			"900,google.com",
			"60,mail.yahoo.com",
			"10,mobile.sports.yahoo.com",
			"40,sports.yahoo.com",
			"300,yahoo.com",
			"10,stackoverflow.com",
			"20,overflow.com",
			"5,com.com",
			"2,en.wikipedia.org",
			"1,m.wikipedia.org",
			"1,mobile.sports",
			"1,google.co.uk"
   			};
		
  /* Sample output (in any order/format):
	   calculateClicksByDomain(counts) =>
	   com: 1345
	   google.com: 900
	   */
     List<String> result=  calculateClicksByDomain(counts);
     result.forEach(object->System.out.println(object));
	}

	private static List<String> calculateClicksByDomain(String[] counts) {
		// TODO Auto-generated method stub
		
		List<String> result = new ArrayList<String>();
		String [] subdomainArray;
		String[] domainArray;
		String domainName;
		int currentCount;
		String prevDomainname;
		Map<String,Integer> domainMap=new HashMap<String, Integer>();
		int count=0;
		if(counts.length ==0 )
		return result;
	   for(int i=0; i< counts.length ; i ++)
	   {
		     //900,google.com
		   domainArray= counts[i].split("\\,");
		   count= Integer.parseInt(domainArray[0]);
		   subdomainArray=domainArray[1].split("\\.");
		   prevDomainname="";
		   for(int j=subdomainArray.length-1; j>=0; j--)
		   {  
			   
			   domainName = subdomainArray[j] + (j<subdomainArray.length-1 ?  ".":"") + prevDomainname ;
			   currentCount =  domainMap.getOrDefault(domainName, 0);
			   currentCount = currentCount+count;
			   domainMap.put(domainName, currentCount);
			   prevDomainname = domainName;
		   }
	   }
	   
	   for(String domainkey: domainMap.keySet())
		   result.add(domainkey  +" "+ domainMap.get(domainkey));
		return result;
	}

}
