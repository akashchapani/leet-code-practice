package com.sprint1.wf;

import java.util.HashSet;
import java.util.Set;

public class SubSudoku {

/*	You are working on a logic game made up of a series of puzzles.
	The first type of puzzle you settle on is "sub-Sudoku", 
	a game where the player has to position the numbers 1..N 
	on an NxN matrix.*/
	
	
	 public static void main(String[] args) {
	        int n = 3;
	        int[][] f = {{1, 3, 2},
	                {3, 1, 2},
	                {2, 3, 1}};
	        System.out.println("Result f : " + checkBlock(f, n));
	        int[][] f1 = {{1, 2, 3},
	                {3, 1, 2},
	                {2, 3, 1}};
	        System.out.println("Result f1 : " +checkBlock(f1, n));
	        int[][] f2 = {{1, 2, 3},
	                {3, 1, 2},
	                {2, 3, 1}};
	        System.out.println("Result f2 : " + checkBlock(f2, n));
	        int[][] f3 = {{3, 2, 3, 2},
	                {2, 3, 2, 3},
	                {3, 2, 3, 2},
	                {2, 3, 2, 3}};
	        System.out.println("Result f3 : " + checkBlock(f3, n));
	        int[][] f4 = {{1000, -1000, 6},
	                {2, 3, 1},
	                {3, 1, 2}};
	        System.out.println("Result f4 : " + checkBlock(f4, n));
	    }

	private static boolean checkBlock(int[][] f, int n) {
		// TODO Auto-generated method stub
		int sum=0,columnSum=0,rowSum=0;
		Set <Integer> expectedSet = new HashSet<Integer>();
		Set <Integer> columnSet = new HashSet<Integer>();
		Set <Integer> rowset = new HashSet<Integer>();
		for(int x=1; x<=n; x++)
		{
			//sum += x;
			expectedSet.add(x);
			
		}
		for(int i=0; i<f.length; i++)
		{
			columnSet=new HashSet<Integer>();
			for(int j=0; j<f.length; j++)
			{
				columnSet.add(f[i][j]);
			}
			if(!columnSet.containsAll(expectedSet))
			{
				return false;
			}
		}
		
		for(int i=0; i<f.length; i++)
		{ rowset=new HashSet<Integer>();
			for(int j=0; j<f.length; j++)
			{
				rowset.add(f[j][i]);
			}
			if(!rowset.containsAll(expectedSet) )
				return false;
		}
		for(int k:expectedSet)
		{
			System.out.println("Expected Elements are :" +k);
		}
		return true;
	}
}
