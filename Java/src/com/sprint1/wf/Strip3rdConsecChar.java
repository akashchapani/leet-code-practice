package com.sprint1.wf;

import java.util.Stack;

	public class Strip3rdConsecChar {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		// No 3 consecutive charecter in string 
			String input1= "abcssssff";
			
			System.out.println(" Result is : " +stripString(input1));
		}
	
		private static String stripString(String input1) {
			// TODO Auto-generated method stub
			String result="";
			StringBuilder sb= new StringBuilder();
			sb.append(input1.charAt(0));
			sb.append(input1.charAt(1));
			for(int i=2; i<input1.length(); i++)
			{
				if(input1.charAt(i) != input1.charAt(i-1)  || input1.charAt(i) !=  input1.charAt(i-2))
					sb.append(input1.charAt(i));
						
					
			}
			
			return sb.toString();
		}
	
	}
