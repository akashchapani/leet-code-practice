package com.sprint1.wf;

public class ConsecutiveAproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Given a string, you have to insert 'a' into it, subject to the condition that the string cannot contain 3 consecutive a's. Return the maximum number of a's that can be inserted. For eg: dog: return 8, as you can make aadaaoaagaa.
		String input1= "dog";
		String input2 = "apple";
		String input3 = "";
		System.out.println("Result for Test case 1 " +findCount(input1));
		System.out.println("Result for Test case 2 " +findCount(input2));
		System.out.println("Result for Test case 3 " +findCount(input3));
	}

	
	 /*
    Approach:
        - Count of characters which is not a or A
        - Mutiply the count by 2 and 2 (as you can have 2 a's before any non 'a' and 2 at the end of the word)
        - Subtract the total from the number of a's available and return the result
    T - O(n) 
    S - O(1)
*/
	private static int findCount(String input1) {
		// TODO Auto-generated method stub
		//dog --aadaaoaagaa
		int result;
		int countA = 0;
		int countNonA = 0;
		if(input1.length() ==0)
			return -1;
		
		for(int i=0 ; i<input1.length(); i++)
		{
			if(input1.charAt(i) =='a' || input1.charAt(i)=='A')
			{	
				countA++;
				
			}else 
			{
				countNonA ++;
				
			}
		}
		System.out.println("Count of non a char:" +countNonA);
		System.out.println("Count of  a char:" +countA);
		
		return 2*(countNonA + 1) - countA;
	}

}
