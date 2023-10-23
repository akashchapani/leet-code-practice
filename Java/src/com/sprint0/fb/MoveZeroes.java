package com.sprint0.fb;

import java.util.Arrays;

public class MoveZeroes {
	
	/*
	 * 283. Move Zeroes Given an integer array nums, move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * Note that you must do this in-place without making a copy of the array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
	 */
	
    public void moveZeroes(int[] nums) {
        int numberPos=0;
        int len = nums.length;
        for(int num : nums)
        {
        	if(num !=0)
        		nums[numberPos++]=num;
        }
        
        while(numberPos <len)
        {
        	nums[numberPos++]=0;
        }
    }
    
    public static void main(String args[])
    {
    	int[] nums = {0,1,0,3,12,0 ,0, 9,3,4};
         new MoveZeroes().moveZeroes(nums);
         System.out.println(" Result is " + Arrays.toString(nums));
    }
}
