package com.sprint0.wf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 long[] res= fib(10);
		 long[] prime = new long[res.length];
		 List<Long>primlist= new ArrayList<Long>();
		 int k = 0;
		 for (int i=3 ; i<res.length; i++)
			{   if(isPrime(res[i]))
				
				{prime[k]=res[i];
			     primlist.add(res[i]);
				}
			System.out.println(res[i] +":" +prime[k]);
			 k++;
			     
			}
        System.out.println( Arrays.toString(prime) );
        Long[] resprime = new Long[primlist.size()];
        resprime= primlist.toArray(resprime);
        for(Long x:resprime)
        	System.out.println(x);
        	
	
	}
 //0 1 1 2 3 5 8 13 21 
	  public static  long[] fib(int N) {
		  long[] result =new long[N+1];int k=0 ;
		  if (N <= 1) {
	             result[k++]=N;
	             return result ;
	        }
	        return memoize(N,result);
	        
	    }
private static long[] memoize(int n, long[] result) {
	// TODO Auto-generated method stub
	 int[] cache = new int[n + 1];
     cache[1] = 1;
     result[1] =1 ;
     

     for (int i = 2; i <= n; i++) {
         cache[i] = cache[i-1] + cache[i-2];
         result[i]=cache[i] ;
     }
     return result;
}


static boolean isPrime(long res)
{
    // Corner case
    if (res <= 1) return false;
 
    // Check from 2 to n-1
    for (int i = 2; i < res; i++)
        if (res % i == 0)
            return false;
 
    return true;
}
}
