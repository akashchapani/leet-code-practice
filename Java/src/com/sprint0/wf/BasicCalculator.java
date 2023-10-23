package com.sprint0.wf;

import java.util.Stack;

import com.lc.patterns.LongestSubStringNotrepeatingCharecter;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //Input: s = "(1+(4+5+2)-3)+(6+8)"
		String  s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println("Result is :"+calculate(s));
	}
	  public static int calculate(String s) {
	        int result=0;
	        int number=0;
	        int sign =1;
	        Stack stackdata=new Stack<>();
	        for(int i=0; i<s.length(); i++)
	        { 
	        	char ch= s.charAt(i);
	        	if(Character.isDigit(ch))
	        	{
	        		number = number*10 + (int) (ch -'0');
	        	}
	        	else if(ch == '(')
	        		
	        	{ 
	        		stackdata.push(result);
	        		stackdata.push(sign);
	        		
	        		sign= 1;
	        		result=0;
	        		
	        	}else if( ch == ')')
	        	{
	        		result += sign * number;  
	                number = 0;
	                result *= (int)stackdata.pop();
	                result += (int)stackdata.pop(); 
	        		
	        	}else if( ch == '+')
	        	{
	        		
	        		result = result+ number*sign;
	        		number=0;
	        		sign =1;
	        	}else if( ch == '-')
	        	{
	        		
	        		result = result+ number*sign;
	        		number=0;
	        		sign = -1;
	        	}
	        }
	        if(number != 0) result += sign * number;
	        return result;
	    }
}
