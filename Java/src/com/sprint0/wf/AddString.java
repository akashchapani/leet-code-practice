package com.sprint0.wf;

public class AddString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addStrings("123","232");

	}

	  public static String addStrings(String num1, String num2) {
		  
		  StringBuilder res= new StringBuilder();
		  int p1 = num1.length()-1;
	      int p2 = num2.length()-1;
	      int carry=0;
	      while(p1 >=0 || p2 >=0)
	      { 
	    	

	    	  int x=p1 >= 0 ? num1.charAt(p1) - '0' :0;
	    	 
	    	  int y =p2 >=0 ? num2.charAt(p2) -'0' :0 ;
	    	
	    	  int value = (x+y+carry) %10;
	    	  carry=  (x+y+carry) / 10;
	    	  res.append(value);
	    	  p1--;
	    	  p2--;
	      }
	       if (carry != 0)
	            res.append(carry);
		   res.reverse();
		  return res.toString();
	        
	    }
}
