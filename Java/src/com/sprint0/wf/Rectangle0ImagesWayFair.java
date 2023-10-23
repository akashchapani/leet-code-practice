package com.sprint0.wf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle0ImagesWayFair {
	static int maxr=0, maxc=0;
	
	 public static void main(String[] argv) {
		    int[][] image1 = {
		      {0, 1, 1, 1, 1, 1, 1},
		      {1, 1, 1, 1, 1, 1, 1},
		      {0, 1, 1, 0, 0, 0, 1},
		      {1, 0, 1, 0, 0, 0, 1},
		      {1, 0, 1, 1, 1, 1, 1},
		      {1, 0, 1, 0, 0, 1, 1},
		      {1, 1, 1, 0, 0, 1, 1},
		      {1, 1, 1, 1, 1, 1, 0},
		    };

		    int[][] image2 = {
		      {0},
		    };

		    int[][] image3 = {
		      {1},
		    };

		    int[][] image4 = {
		      {1, 1, 1, 1, 1},
		      {1, 0, 0, 0, 1},
		      {1, 0, 0, 0, 1},
		      {1, 0, 0, 0, 1},
		      {1, 1, 1, 1, 1},
		    };
		    
		 //   List <List <int []>> result=  findRectangles(image1);
		   // result.forEach(e-> System.out.println(Arrays.deepToString(e.toArray())));
		    
		    List <List <int []>> resultRec=  findRectanglesRecursion(image1);
		    resultRec.forEach(e-> System.out.println(Arrays.deepToString(e.toArray())));
		  }

	private static List<List<int[]>> findRectanglesRecursion(int[][] image3) {
		// TODO Auto-generated method stub
		List <List <int[]>> result= new ArrayList<List <int[]>>();
		int startrow=0;
		int startColumn=0;
		List<int []> rec = new ArrayList<int []>();
		
		if(image3.length ==0)
			return result;
		for(int i=0; i<image3.length; i++)
		{
			for(int j=0; j<image3[0].length; j++)
			{
				if(image3[i][j] == 0)
				{
					rec = new ArrayList<int []>();
					startrow=i;
					startColumn =j;
					rec.add(new int[] {startrow,startColumn});
					
					dfs(image3,i,j);
					rec.add(new int[] {maxr,maxc});
					result.add(rec);
					
					maxr=0;
					maxc=0;
				}
			}
			
		}
		return result;
	}

	private static void dfs(int[][] image3, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i>image3.length-1 || j>image3[0].length-1 || image3[i][j] == 1)
			return;
		if(i>maxr)
			maxr=i;
		if(j>maxc)
			maxc=j;
		image3[i][j]=1 ;
		
		dfs(image3,i+1,j);
		
		dfs(image3,i,j+1);
		
		
	}

	private static  List <List <int []>> findRectangles(int[][] image1) {
		// TODO Auto-generated method stub
		 List <List <int []>> result =new ArrayList<List <int[]>>();
		for(int i=0; i <image1.length; i++)
		{
			for(int j=0; j<image1[0].length; j++)
			{
				if(image1[i][j] == 0)
				{
					findCoordinates( i,j ,image1,result);
				}
				else
				{int []myarray = new int[2];
				   Arrays.fill(myarray, 999);
				   List coordListError= new ArrayList<int[]>();
				   coordListError.add(myarray);
				   result.add(coordListError);
				
					 
				}
			}
		}
		
		return result;
	}

	private static void findCoordinates(int i, int j, int[][] image1, List <List <int []> >result) {
		// TODO Auto-generated method stub
		List coordList= new ArrayList<int[]>();
		int[] startcoordinates= new int [2];
		startcoordinates[0]= i;
		startcoordinates[1]= j;
		coordList.add(startcoordinates);
		int prevj=j;
		while(j< image1[0].length && image1[i][j] == 0)
		{
			j++;
		}
		int limit = j;
		System.out.println("Limit is "+limit);
		j=prevj;
		int x,y = 0;
		int previ=0; 
		  outerloop:
		    for(  x= i; x < image1.length; x++)
		    { 	for(  y =j; y<limit; y++)
		    	{
		    	
		    		if(image1[x][y] == 0)
		    			{
		    			System.out.println("X and Y"+x+"and"+y);
		    			image1[x][y] =5;
		    			previ=x;
		    			prevj=y;
		    			}
		    		else 
		    			break  outerloop;
		    		
		    	}
	       }
		   int[] endcoordinates= new int [2];
		   endcoordinates[0]= previ;
		   endcoordinates[1]= prevj;
		   coordList.add(endcoordinates);
		    result.add(coordList);
		 
		    }
		   
		
	

	

}
