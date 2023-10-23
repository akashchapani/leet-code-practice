package com.sprint0.wf;

public class Baloon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
	}

	  public static int maxNumberOfBalloons(String text) {
	        int result=0;
	        int[] count= new int[26];
	        int min;
	        for(char c:text.toCharArray())
	        {
	        	count[c - 'a']++;
	        }
	     //  a,b,c,d,e,f,g,h,i,j,k, l, m, n, o, p,q,r,s,t,u,v,w,x,y,z
	     //  0,1,2,3,4,5,6,7,8,9,10,11,12,13,14
	        //balloon
	        min=Math.min(count[1], count[0]);
	        min= Math.min(min, count[11]/2);
	        min=Math.min(min, count[14]/2);
	        min= Math.min(min, count[13]);
	        return min ;
	    }
}
