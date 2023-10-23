package com.sprint0.fb;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={23,2,4,6,6};
		ContinuousSubarraySum css= new ContinuousSubarraySum();
		System.out.println(css.checkSubarraySum(nums, 7));

	}

	   public boolean checkSubarraySum(int[] nums, int k) {
		    int sum = 0;
	        HashMap < Integer, Integer > map = new HashMap < > ();
	        map.put(0,-1);
	       for(int i=0; i < nums.length ; i++)
	       {
	    	   sum  += nums[i];
	    	   if(k !=0)
	    		   sum= sum%k;
	    	   if(map.containsKey(sum))
	    	   {
	    		   if( i - map.get(sum)  >0)
	    		   {
	    			   return true ;
	    		   }
	    		   
	    	   }else
    		   {
    			   map.put(sum, i);
    		   }
	       }
	        return false;
	    }
}
