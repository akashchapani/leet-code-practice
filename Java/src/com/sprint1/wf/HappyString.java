package com.sprint1.wf;

public class HappyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//A4  b3 c2
        // AABBAABCC
		int A=4,B=3,C=2;
		System.out.println("Output for the TC1 is   "+getStringfor(A,B,C));
		
		System.out.println("Output for the TC1 is   "+getStringfor(10,10,10));
		
		System.out.println("Output for the TC1 with for loop is   "+getHappyString(10,10,10));
	}
	
	
	//For oope approach, Restting count in exclusive if block is important .also >= to be used against counter
 private static String getHappyString(int a, int b, int c) {
		// TODO Auto-generated method stub
	 
	 String result="";
	 int A=0,B=0,C=0;
	 int size = a+b+c;
	 for(int i=0; i<size;i++)
	 {
		 if((a>=b && a>=c && A !=2) || (B==2 && a>0 )  || (C==2 && a>0))
		 {
			 result+="a";
			 A++;
			 B=0;
			 C=0;
			 a--;
		 }else  if((b>=a && b>=c && B !=2) || (A==2 && b>0 )  || (C==2 && b>0))
		 {
			 result+="b";
			 B++;
			 A=0;
			 C=0;
			 b--;
		 }else  if((c>=b && c>=b && C !=2) || (B==2 && c>0 )  || (B==2 && c>0))
		 {
			 result+="c";
			 C++;
			 A=0;
			 B=0;
			 c--;
		 }
	 }
	 
	 
		return result;
	}
	//at max I can have 2 aa , 2 bb and 2 cc
	private static String getStringfor(int a, int b, int c) {
		// TODO Auto-generated method stub
		String result = "";
		if (a ==0 && b==0 && c==0)
			return result;
		int totalLength = a+b+c;
		int A= a, B=b,C=c;
		
		int counterA=0; int counterB=0; int counterC=0;
		
		while(totalLength >0)
		{
			System.out.println("Total length:  "+totalLength);

		if( (a>=b && a >=c && counterA<2)  || (counterB==2 && a>0) || (counterC ==2 && a>0) ) //4 3  2   =8 3
		{
			result =result+'a';
			counterA +=1;
			counterB =0;
			counterC=0;
			totalLength--;
			a--;
		}else if( (b>=a && b >=c && counterB<2)  || (counterC==2 && b>0) || (counterA ==2 && b>0) )
		{
			result =result+'b';
			counterB +=1;
			counterA =0;
			counterC=0;
			totalLength--;
			b--;
		}else if( (c>=a && c >=b && counterC<2)  || (counterB==2 && c>0) || (counterA ==2 && c>0) )
		{
			result =result+'c';
			counterC +=1;
			counterA =0;
			counterB=0;
			totalLength--;
			c--;
		}
		
		
		
		}
		
		return result;
	}

}
