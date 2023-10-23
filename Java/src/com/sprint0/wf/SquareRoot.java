package com.sprint0.wf;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 // 4 -> 2    9 -> 3  16 ->4 
		int num =80;
		System.out.println("Sqrt is :"+ mySqrt(num));
	}
	
	// Formula mid = low + (high-low)/2; critical to get the sqrt
	// Low start from 2 and max keep it x/2 
	  public static  int mySqrt(int x) {
		  
		  if (x < 2)
			  return x;
		  
		  int low=2;
		  int high = x/2;
		  int mid = 0;
		  long num = 0;
		  System.out.println((low+high)/2);
		  while(low  <= high)
		  { mid = low + (high-low)/2;
		   num= (long) mid *mid;
		   
		   System.out.println(" low , high , mid ,num:" +low+":"+high +":"+mid +":"+num);
			
           if(num > x)
				  	high= mid-1;
			  else if(num < x)
			       low =mid+1;
			  else return mid; 
			  
			
			}
        return high;
	    }

}
