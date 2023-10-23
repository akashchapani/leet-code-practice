package com.sprint0.wf;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		n = 15,
//
//				Return:
//				[
//				    "1",
//				    "2",
//				    "Fizz",
//				    "4",
//				    "Buzz",
		fizzBuzz(15).forEach(e->System.out.println(e));

	}
	
	   public static List<String> fizzBuzz(int n) {
		   List<String> result= new ArrayList<String>();
		   for (int i=1; i <=n ; i++)
		   {
			   if (i % 3 == 0  && i%5 ==0)
				   result.add("FizzBuzz");
			   else if(i % 5 == 0)
				   result.add("Buzz");
			   else if(i% 3 == 0)
				   result.add("Fizz");
			   else result.add(Integer.toString(i));
				   		
		   }
		     return result;
	        
	    }

}
