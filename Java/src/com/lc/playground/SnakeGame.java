package com.lc.playground;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*

		We have a two-dimensional board game involving snakes. The board has two types of squares on it: +'s represent impassable squares where snakes cannot go, and 0's represent squares through which snakes can move. Snakes can only enter on the edges of the board, and each snake can move in only one direction. We'd like to find the places where a snake can pass through the entire board, moving in a straight line.

		Here is an example board:

		col-->        0  1  2  3  4  5  6
		           +----------------------
		row      0 |  +  +  +  0  +  0  0
		 |       1 |  0  0  0  0  0  0  0
		 |       2 |  0  0  +  0  0  0  0
		 v       3 |  0  0  0  0  +  0  0
		         4 |  +  +  +  0  0  0  +  */
		char[][]	straight_board_1 = {{'1', '1', '1', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1', '0', '0'},
                {'1', '1', '1', '0', '0', '0', '1'}} ;
		
		List <List<String>> result = findStartingPoints(straight_board_1);
		result.forEach(obj->System.out.println(obj));
		
		
			System.out.println("ROWS  :" +result.get(0));
			System.out.println("COLUMNS : " +result.get(1));
		

	}

	private static List<List<String>> findStartingPoints(char[][] straight_board_1) {
		// TODO Auto-generated method stub
		
		List<List<String>> result= new ArrayList<List<String>>();
		List<String> rowIndex =new ArrayList<String>();
		List<String> colIndex =new ArrayList<String>();
		
		int RowIndex=0;
		int ColumnIndex=0;
		
		if(straight_board_1.length ==0 )
			return result;
		for(int i=0; i<straight_board_1.length; i++)
		{
			if(findrowIndices(straight_board_1,i, ColumnIndex))
				rowIndex.add(String.valueOf(i)) ;
			  
		}
		
		for(int j=0; j<straight_board_1[0].length; j++)
		{
			if(findColumnIndices(straight_board_1,j, RowIndex))
				colIndex.add(String.valueOf(j));
			
		}
		result.add(rowIndex);
		result.add(colIndex);
		
		return result;
	}

	private static boolean findrowIndices(char[][] straight_board_1, int i, int columnIndex) {
		// TODO Auto-generated method stub
		
		while(columnIndex<straight_board_1[0].length)
		{
			if(straight_board_1[i][columnIndex] == '0')
				columnIndex++;
			else 
				return false;
		}
		
		return true ;
	}
	
	private static boolean findColumnIndices(char[][] straight_board_1, int j, int RowIndex) {
		// TODO Auto-generated method stub
		
		while(RowIndex<straight_board_1.length)
		{
			if(straight_board_1[RowIndex][j] == '0')
				RowIndex++;
			else 
				return false;
		}
		
		return true ;
	}

}
