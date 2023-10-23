package com.sprint0.fb;

public class BestTimetoBuyAndSell {
	public static void main(String args[])
	{
		BestTimetoBuyAndSell BTBS =new BestTimetoBuyAndSell();
		int []prices= {7,1,5,3,6,4};
		System.out.println("Result is  :" +BTBS.maxProfit(prices));
	}

	 public int maxProfit(int[] prices) {
	        
	        int max =0;
	        int min =Integer.MAX_VALUE;
	        for(int i =0; i<prices.length; i++)
	        {
	            if(prices[i] < min)
	            {
	                min =prices[i];
	            }else
	            {
	                max = Math.max(max,prices[i]-min);
	            }
	        }
	        return max;
	    }
}
