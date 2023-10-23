package com.lc.playground;

import java.util.HashSet;
import java.util.Set;

public class SubSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	You are working on a logic game made up of a series of puzzles. The first type of puzzle you settle on is "sub-Sudoku", a game where the player has to position the numbers 1..N on an NxN matrix.

		Your job is to write a function that, given an NxN matrix, returns true if every row and column contains the numbers 1..N
		*/
		
		
		/* 
		 * 
		 * [[1, 2, 3],
[3, 1, 2],
[2, 3, 1]] -> True
		 */
		
		int[][] matrix = {   {1 ,2,3},
							 {3,1,2},
							 {2,3,1}};
		

		int[][] matrix1 = {   {1 ,2,3},
							 {1,2,3},
							 {1,2,3}};
		
		int n= 3;
		System.out.println( "Result of matrix is   " +isitSubSudoku(matrix,n));
		System.out.println( "Result of matrix1 is   " +isitSubSudoku(matrix1,n));
	}

	
	///Please not Ordering of COntains all is very important expected Data is superset. we should always check if row and column contains all in ExpectedData
	private static boolean isitSubSudoku(int[][] matrix, int n) {
		// TODO Auto-generated method stub
		
		Set<Integer> expectedData= new HashSet<Integer>();
		Set<Integer> rowSet= new HashSet<Integer>();
		Set<Integer> colSet= new HashSet<Integer>();
		if(matrix.length ==0)
			return false;
		
		for(int i=1; i<=n; i++)
			expectedData.add(i);
		
		for(int i=0; i< matrix.length; i++)
		{
			 rowSet= new HashSet<Integer>();
			for(int j=0; j<matrix[0].length; j++)
			{
				rowSet.add(matrix[i][j]);
			}
			
			if(!rowSet.containsAll(expectedData))
				return false;
		
		}
		
		for(int j=0; j<matrix[0].length; j++)
		{    colSet= new HashSet<Integer>();
			for( int i=0; i <matrix.length; i++)
			{
				colSet.add(matrix[i][j]);
			}
			if(!colSet.containsAll(expectedData))
				return false;
		}
		
		
		
	    return true;
		
	}

}
