package com.sprint0.wf;

public class LogestPalndromeSubstring {
	static int maxlength;
	static int beginIndexGlobal;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="babad";
		System.out.println(" Output with Bruteforce is "+longestPalindrome(input));
		System.out.println(" Output with O(N^2) is "+longestPalindromeOption2(input));

	}

	public static String longestPalindrome(String s) {

		// babad
		String result = null;
		// Edge case
		if (s == null)
			return s;
		if (s.length() == 1)
			return s;

		// Brute force
		String tempString = null;
		int maxsize = 0;

		for (int i = 0; i < s.length(); i++) {
			// tempString=Character.toString( s.charAt(i));
			for (int j = i; j < s.length(); j++) {
				// tempString =tempString+s.charAt(j); bb
				tempString = s.substring(i, j + 1);
				if (isPalindrome(tempString) && tempString.length() > maxsize) { // maxsize=Math.max(tempString.length(),
																					// maxsize)

					result = tempString;
					maxsize = tempString.length();

				}
			}
		}

		return result;

	}

	public static boolean isPalindrome(String s) {

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	//Optimal o(n^2)
	//return s.substring(beginIndexGlobal, beginIndexGlobal+maxlength);
	
	
	public static String longestPalindromeOption2(String s) {
		
		if(s.length() <2)
			return s ;
		///abcacab
		for(int i=0; i<s.length(); i++)
		{
			expandAroundCentre(s,i,i);
			expandAroundCentre(s,i,i+1);
		}
		return s.substring(beginIndexGlobal, beginIndexGlobal+maxlength);
	}
	
	// end-begin-1 as 0 indexed .  begin+1 to get back to the correct counter as it was decremented
  
	
	
	private static void expandAroundCentre(String s, int begin, int end) {
		// TODO Auto-generated method stub
     //babad
		while(begin >=0 && end<s.length() && s.charAt(begin) == s.charAt(end))
		{
			begin --;
			end ++;
		}
		
		if(end-begin -1 > maxlength)
			{ 
			maxlength= end-begin-1;
			beginIndexGlobal =begin+1;
			}
	}
	}


