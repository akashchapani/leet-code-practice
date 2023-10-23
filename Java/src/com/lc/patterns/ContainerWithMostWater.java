package com.lc.patterns;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //[1, 8, 2, 7, 9, 5]
		
		int height[]= {1, 8, 2, 7, 3, 5};
		System.out.println ("Result from Brute force  "+maxArea(height));
		System.out.println ("Result from Optimize "+maxArea2(height));
	}
	
	//brute force approach
	 public static int maxArea(int[] height) {
		 
		 int maxarea=0;
		 
		 for(int i=0; i<height.length; i++)
		 {
			 for( int j=i+1; j<height.length; j++)
			 {
				 maxarea= Math.max(maxarea, Math.min(height[i],height[j])* (j-i));
				 
			 }
		 }
		 
		 return maxarea;
	        
	    }
	 
	//  option 2
	 public static int maxArea2(int[] height) {
		 int max=0;
		 int l=0,r=height.length-1;
		 while (l<r)
		 {
			 max=Math.max(max, Math.min(height[l], height[r])*(r-l));
			 if(height[r]>height[l])
				 l++;
			 else 
				 r--;
				 
		 }
		 return max;
	 }

}
