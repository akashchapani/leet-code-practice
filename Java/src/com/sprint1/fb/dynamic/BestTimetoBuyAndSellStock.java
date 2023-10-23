package com.sprint1.fb.dynamic;

public class BestTimetoBuyAndSellStock {
	 public int maxProfit(int[] prices) {
	 
		 int max =0;
		 int min = Integer.MAX_VALUE;
		 for(int i=0 ; i<prices.length; i++)
		 {
			 if(prices[i] <min)
			 {
				 min = prices[i];
			 }else 
			 {
				 max= Math.max(max, prices[i]-min );
			 }
		 }
		 return max;
	 
	 }
}
