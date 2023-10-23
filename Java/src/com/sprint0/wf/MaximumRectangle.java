package com.sprint0.wf;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=0;
//		char [][]matrix =new char[][] {
//			{1,0,1,0,0},
//			{1,0,1,1,1},
//			{1,1,1,1,1},
//			{1,0,0,1,0},
//			
//		};
	//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
		char [][]matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},	{'1','1','1','1','1'},	{'1','0','0','1','0'}	};
		result= maximalRectangle(matrix);
		System.out.println("Result is "+ result);

	}

	
	//Need to review Stack logic 
	
// Create DP array to cache the count for each rowloevel
	
	  public static int maximalRectangle(char[][] matrix) {
          if(matrix.length == 0)
         return 0;

     int dp[] = new int[matrix[0].length];

     int maximalRectangleArea = 0;

     for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
        	 System.out.println("matrix[i][j]:"+i+","+j+":"+matrix[i][j] );
             if (matrix[i][j] == '0')
                 dp[j] = 0;
             else
                 dp[j] = dp[j] + 1;
         }
        
       

         int currentHeight = 0;

         Stack<Integer> stack = new Stack<>();
         stack.push(-1);

         for (int j = 0; j < dp.length; j++) {
             currentHeight = dp[j];
             while (stack.peek() != -1 && currentHeight <= dp[stack.peek()]) {
                 int height = dp[stack.pop()];
                 int width = j - stack.peek() - 1;
                 maximalRectangleArea = Math.max(maximalRectangleArea, height * width);
             }
             stack.push(j);
         }

         while (stack.peek() != -1) {
             int height = dp[stack.pop()];
             int width = dp.length - stack.peek() - 1;
             maximalRectangleArea = Math.max(maximalRectangleArea, height * width);
         }

     }
      System.out.println("Dp Array is :"+Arrays.toString(dp));
     return maximalRectangleArea;
     
 }
}
