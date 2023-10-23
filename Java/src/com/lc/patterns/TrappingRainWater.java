package com.lc.patterns;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[0,3,4,6,0,7,5,0,2]
		
		int[] height = {0,1,0,2,1,0,3,1,0,1,2};
		System.out.println("Brute force Result is :"+trap(height));
		System.out.println("Option 2  Result is :"+trapOption2(height));
	}
	// time : O(n2)   space O(1)	
	  public static int trap(int[] height) {
		  int maxleft=0;
		  int maxright=0;
		  //min(max left,maxright)- height[pointer]
		  int totalwater=0;
		  int currentwater;
		  int pointer=0,leftp=0,rightp=0;
		  
		  for( pointer=0; pointer<height.length; pointer++)
		   {  maxleft=0;
		      maxright=0;
			  leftp=pointer;
			  rightp=pointer;
			  currentwater=0;
			  
			 while(leftp>=0)
			 {
				 //get the Max left for each element 
				
				 maxleft=Math.max(maxleft, height[leftp]); 
				 leftp--;
			 }
			 while(rightp < height.length) // {0,1,2,3,4,5}
			 {
				 //get the Max left for each element 
				 
				 maxright=Math.max(maxright, height[rightp]);
				 rightp++;
			 }
			 currentwater= Math.min(maxright, maxleft)- height[pointer];
			 if (currentwater>0)
			 {
				 totalwater+= currentwater;
			 }
		  }
		  return totalwater;
	        
	    }
	  
	  //Optimal Solution  time:O(n)   Space :O(1)
	  
	  public static int trapOption2(int[] height) {
		  int totalriver = 0;
		  int leftp=0,rightp=height.length-1; //Pointers for right and left
		  int maxleft=0,maxright=0;
		  
		  while(leftp<rightp)  //Inward check with 2 pointer approach
		  {
			  if(height[leftp] <= height[rightp])   // left pointer is smaller
			  {
			  if(height[leftp]>=maxleft)
				  maxleft=height[leftp];
			  else 
				  totalriver+=maxleft-height[leftp];
			  
			 leftp++;
			  }else {
				  if (height[rightp] >=maxright)
				    maxright=height[rightp];
				  else 
					   totalriver+= maxright-height[rightp];
				   rightp--;
			  }
		  }
		  
		  return totalriver;
	  }
	  
	  

}
