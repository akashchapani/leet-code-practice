package com.lc.patterns;

public class PrimeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=19;
		getPrimecount(n);

	}

	private static void getPrimecount(int n) {
		boolean[] nonPrime =new boolean[n]; 
		
		// TODO Auto-generated method stub
		nonPrime[0]=true;
		nonPrime[1]=true;
		for (int i=2 ; i< n ; i++)
		{
		   for (int j=i; i*j <n ; j++)
			   nonPrime[i*j] =true;
	}
		int count=0;
		for(int i=0 ; i < nonPrime.length ; i++ )
		{   
			boolean b=nonPrime[i];
			if(!b)
				System.out.println("Index is :" +i+ " Count is :"+ ++count);
				
		}

   }
}
