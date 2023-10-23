package com.sprint0.wf;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Input: chars = ["a","a","b","b","c","c","c"]
		//		 should be 6 : ["a","2","b","2","c","3"]
		char[] chars= {'a','a','b','b','c','c','c'};
		System.out.println("Compress :"+compress(chars));

	}
	  public static int compress(char[] chars) {
		  int index=0,ansIndex=0;
		 
		  
		  while(index < chars.length)
		  {
			  char current =chars[index];
			 int count =0 ;
			 while(index<chars.length && current==chars[index])
			 {
				 count++;
				 index++;
				 
			 }
	        
			 chars[ansIndex++]= current;
			 if(count>1)
			 {
				 for(char ch : Integer.toString(count).toCharArray())
				     chars[ansIndex++]= ch;
			 }
			 
			 }
	     
		  
		   return ansIndex;
	}

}
