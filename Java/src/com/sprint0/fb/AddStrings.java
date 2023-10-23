package com.sprint0.fb;

public class AddStrings {

	
//	Input: num1 = "11", num2 = "123"
//			Output: "134"
	
	 public String addStrings(String num1, String num2) {
		 String result ="";
		 StringBuilder sb = new StringBuilder();
		 int sum,carry = 0,val;
		 if (num1== null && num2 ==null )
			 return result;
		 int l1= num1.length()-1;
		 int l2 = num2.length()-1;
		 while(l1 >=0  || l2>=0)
		 {
			 int p1 = l1>=0 ? num1.charAt(l1) - '0' :0;
			 int p2 = l2>=0   ?num2.charAt(l2) - '0' :0;
			 sum = p1+p2+carry;
			 val= sum%10;
			 carry=sum/10;
			 sb.append(val);
			 l1--;
			 l2--;
		 }
		 if(carry != 0)
			 sb.append(carry);
		 result= sb.reverse().toString();
		 return result;
	 }
}
