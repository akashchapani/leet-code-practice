package com.sprint1.wf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

We have a two-dimensional board game involving snakes. The board has two types of squares on it: 1s represent impassable squares where snakes cannot go, and 0s represent squares through which snakes can move. Snakes can only enter on the edges of the board, and each snake can move in only one direction. Wed like to find the places where a snake can pass through the entire board, moving in a straight line.

Here is an example board:

col-->        0  1  2  3  4  5  6
           1----------------------
row      0 |  1  1  1  0  1  0  0
 |       1 |  0  0  0  0  0  0  0
 |       2 |  0  0  1  0  0  0  0
 v       3 |  0  0  0  0  1  0  0
         4 |  1  1  1  0  0  0  1
         */
public class SnakeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	char[][]	straight_board_1 = {{'1', '1', '1', '0', '1', '0', '0'},
		                    {'0', '0', '0', '0', '0', '0', '0'},
		                    {'0', '0', '1', '0', '0', '0', '0'},
		                    {'0', '0', '0', '0', '1', '0', '0'},
		                    {'1', '1', '1', '0', '0', '0', '1'}} ;

		             //     System.out.println( find_passable_lanes(straight_board_1)); // = Rows: {1}, Columns: {3, 5}
		                  find_passable_lanes(straight_board_1).forEach(e-> System.out.println("Object contents are"+e));
		  int[][]	           straight_board_2 = {{1, 1, 1, 0, 1, 0, 0},
		                    {0, 0, 0, 0, 0, 1, 0},
		                    {0, 0, 1, 0, 0, 0, 0},
		                    {0, 0, 0, 0, 1, 0, 0},
		                    {1, 1, 1, 0, 0, 0, 1}} ;

		//  System.out.println( find_passable_lanes(straight_board_2) ); //# = Rows: {}, Columns: {3}

	}
	private static List<List<String>> find_passable_lanes(char[][] straight_board_1) {
		// TODO Auto-generated method stub
		Set<String> columnSet = new HashSet<String>();
		Set<String> rowSet = new HashSet<String>();
		 List<List<String>> result =new ArrayList<List<String>>(); 
	    int columnindex=0;
	    int rowIndex =0;
	    List<String> rowList = new ArrayList<String>();
	    List<String> columnList = new ArrayList<String>();
		for(int i=0; i<straight_board_1.length; i++)
		{
			
			if(straight_board_1[i][columnindex]== '0')
			 if(checkIfCompleterow(straight_board_1,i,columnindex+1,straight_board_1[0].length))
			 {// rowSet.add(" ROW "+i);
			 rowList.add(" ROW "+i);
			
			 
			 }
			
		}
		 result.add(rowList);
		
		for(int j=0; j<straight_board_1[0].length; j++)
		{
			
			if(straight_board_1[rowIndex][j]== '0')
			{ if(checkIfCompletecolumn(straight_board_1,rowIndex+1,j,straight_board_1.length))
			 { System.out.println("I am here "+rowIndex  +"   "+j  );
				// columnSet.add(" COLUMN "+j);
				 columnList.add(" COLUMN "+j);
			    
			    
			 }
			}
			
		}
		 result.add(columnList);
	
		return result;
	}
	private static boolean checkIfCompletecolumn(char[][] straight_board_1, int j, int i, int length) {
		// TODO Auto-generated method stub
		while(j<length)
		{
			if (straight_board_1[j][i]=='0')
				j++;
			else
				return false;
			
		}
		
		return true;
	}
	private static boolean checkIfCompleterow(char[][] straight_board_1, int i, int j, int length) {
		// TODO Auto-generated method stub
		while(j<length)
		{
			if (straight_board_1[i][j]=='0')
				j++;
			else
				return false;
			
		}
		
		return true;
	}

}

 
