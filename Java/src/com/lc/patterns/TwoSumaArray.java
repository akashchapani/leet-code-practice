package com.lc.patterns;

import java.util.HashMap;
import java.util.Map;

public class TwoSumaArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test cases
		
		//[1,3,7,9,2]    t =11   result [3, 4] /Indices of numbers whose sum is 11 
		//[1,3,7,9,2]    t =25    null
		//[]         t=1  null
		//[5]     t=5 null
		//[1,6]  t=7    [0,1]

		//Figure out solution
		int resulArray[] =new int[2];
		int intArray[] = {1,3,7,9,2}; 
		int target =12;
		//Two pointer Technique
		//resulArray =findTwoSum(target,intArray);
		resulArray =findTwoSumOptimize1(target,intArray);
		if (resulArray !=null)
		{
			System.out.println("Result is "+ resulArray[0] +","+resulArray[1]);
		}else
		{
			System.out.println("Result is null");
		}
		
	
		

	}

	//Brute force Solution  Time-> O (n^2)	  Space =>O(1)
	 static int[] findTwoSum(int target, int[] intArray)
	 {
		 int numbertoFind;
			
			int resulArray[] =new int[2];
			
			for(int i=0; i<intArray.length; i++ )
			{    numbertoFind=target-intArray[i]; 
				for(int j=i+1; j<intArray.length; j++)
				{
					if(intArray[j] == numbertoFind)
					{
					
					  resulArray[0]=i;
					  resulArray[1]=j;
					 
					  return resulArray;
					}
				}
			}
			return null;
	 }
	 
	 //optimized approach  t=>O(n)  space => O(n)
	 
	 static int[] findTwoSumOptimize(int target, int[] intArray)
	 {
		 int complement;
			
	     Map numberMap = new HashMap();
	     for(int i=0 ; i<intArray.length; i++)
	     {
	    	 numberMap.put(intArray[i],i);
	    	 
	     }
	     for(int i=0 ; i<intArray.length; i++)
	     {  
	    	 complement= target-intArray[i];
	    	 if( numberMap.containsKey(complement) && numberMap.get(complement) !=(Integer) i )
	    	 {
	    		 return new int[] { i,(int)numberMap.get(complement)};
	    	 }
	    	 
	     }
	     
	     throw new IllegalArgumentException("No two sum solution");
	     
	     
	 }
	 
	 //Best solution
	 static int[] findTwoSumOptimize1(int target, int[] intArray)
	 {
		 int complement;
			
	     Map numberMap = new HashMap();
	     
	     for(int i=0 ; i<intArray.length; i++)
	     {  
	    	 complement= target-intArray[i];
	    	 if( numberMap.containsKey(complement) && numberMap.get(complement) !=(Integer) i )
	    	 {
	    		 return new int[] { i,(int)numberMap.get(complement)};
	    	 }
	    	
	    		 numberMap.put(intArray[i],i);
	    	 
	    	 
	     }
	     
	     throw new IllegalArgumentException("No two sum solution");
	     
	     
	 }
}
