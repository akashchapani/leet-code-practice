package com.sprint0.wf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		//subdomainVisits(input);
		List<String> resultList = subdomainVisits(input);
		for(String str:resultList)
			System.out.println("str is "+ str);
	   
	}
// Make sure . seprated on are traversed in reverse order .
// Lenght -1 check for ternery operation is Key .
	// Nulling Current value to ensure different hosts are not cascaded .so for each domain need to null it
 public static List<String> subdomainVisits(String[] cpdomains) {
	 String[] subDomainInfo;
	 String[] subDomainArray;
	 Integer count;
	 String subDomain;
	 String current = "";
	 Map<String, Integer> sdMap= new HashMap();
	 for(String domain:cpdomains)
	 {
		 subDomainInfo= domain.split("\\s+");  //900 google.mail.com
		 count=		 Integer.valueOf(subDomainInfo[0]);
		 subDomain= subDomainInfo[1];
		 subDomainArray= subDomain.split("\\.");
		 current = "";
		 for(int i=subDomainArray.length-1; i>=0; i--)
		 { 
		  current= subDomainArray[i] + (i<subDomainArray.length -1?".":"")+current ;
		 sdMap.put(current, sdMap.getOrDefault(current, 0) + count);
			 
		 }
	 }
	 List<String> ans = new ArrayList();
     for (String dom: sdMap.keySet())
         ans.add("" + sdMap.get(dom) + " " + dom);
     return ans;
	
        
    }

}
