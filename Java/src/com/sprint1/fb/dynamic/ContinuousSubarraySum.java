package com.sprint1.fb.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
//leftSumMap.put(0,-1);  condition is critical 
public class ContinuousSubarraySum {
	//Input: nums = [23,2,4,6,7], k = 6
	// 23 25 29 35 42 
	// 5  1   5  5   0
	//		Output: true
	  public boolean checkSubarraySum(int[] nums, int k) {
		  
		  int sum=0;
		  Map<Integer, Integer> leftSumMap = new HashMap<>();
		  leftSumMap.put(0,-1);
		  for(int i=0; i<nums.length; i++)
		  {
			  sum +=nums[i]; // get the left sum.
			  if(k!=0)
			  {
				  sum %=k;
			  }
			  if(leftSumMap.containsKey(sum)  )
			  { 
				  if(i- leftSumMap.get(sum) >=2 )
					  return true;
			  }else {
				  leftSumMap.put(sum, i);
			  }
		  }
		  
		  return false;
	  }
	  
}
