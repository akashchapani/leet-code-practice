package com.sprint0.fb;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
	
	public static void main(String args[])
	{
		ProductofArrayExceptSelf pae= new ProductofArrayExceptSelf();
		int[] nums= {1,2,3,4};
		int[] result = pae.productExceptSelf(nums);
		System.out.println("Arrays Result is  :" +Arrays.toString(result));
	}
	  public int[] productExceptSelf(int[] nums) {
	        int[] result = new int[nums.length];
	        
	        int left=1 ,right =1 ;
	        
	        if(nums.length ==0)
	        	return result;
	        
	        //Make Sure you have it has 1 for left product pointer .
	        result[0] = 1;
	        for(int i=1 ; i<nums.length; i++)
	        {
	        	//left product   capture only product up to i-1 
	        	
	        	result[i] =nums[i-1]*result[i-1];
	        }
	        
	        System.out.println("After left product" +Arrays.toString(result));
	        
	        for(int i=nums.length-1 ; i>=0; i--)
	        {
	        	//for i-1 product captured from left multiply it by right product
	        	result[i] = result[i]*right;
	        	right *= nums[i];
	        }
	
	        return result;
	    }

}
