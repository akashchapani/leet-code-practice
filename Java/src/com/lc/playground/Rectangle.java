package com.lc.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle {
       static int maxr=0;
       static  int maxc=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] image1 = {
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 0, 0, 0, 1},
				  {1, 1, 1, 0, 0, 0, 1},
				  {1, 1, 1, 1, 1, 1, 1}
				};

			int[][] image2 = {
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 0}
			};

			int[][] image3 = {
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 0, 0},
			  {1, 1, 1, 1, 1, 0, 0}
			};

			int[][] image4 = {
			  {0, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1},
			  {1, 1, 1, 1, 1, 1, 1}
			};

			int[][] image5 = {
			  {0}
			};
			
			List<List<List<Integer>>> result =	getRectangles(image1);
		result.forEach(obj->System.out.println(obj));

	}

	private static List<List<List<Integer>>> getRectangles(int[][] image1) {
		// TODO Auto-generated method stub
		
		
		 List<List<List<Integer>>> result = new ArrayList<List<List<Integer>>>();
		int rowlength= image1.length;
		int columnlength = image1[0].length;
		
		for(int i=0; i <rowlength; i++)
		{
			for(int j=0; j<columnlength; j++)
			{
				if(image1[i][j]==0)
				{
					List <Integer>startrec= Arrays.asList(i,j);  //[1,2]
					List <List<Integer>>tempList = new ArrayList<List<Integer>>();    // 
					tempList.add(startrec);
					
					dfs(image1,i,j);
					
					List<Integer> endrec = Arrays.asList(maxr,maxc);
					
					
					tempList.add(endrec);
					
					result.add(tempList);
					
				      // reset max for multiple rectangles
			          maxr = 0;
			          maxc = 0;
					
				}
			}
		}
		return result;
		
		
	}

	private static void dfs(int[][] image1, int i, int j) {
		// TODO Auto-generated method stub
	 
		if(i>=image1.length || j >=image1[0].length || image1[i][j]==1)
		{
			return;
		}
		
		   if (i > maxr) {
		        maxr = i;
		      }
		      if (j > maxc) {
		        maxc = j;
		      }
		
		image1[i][j]=1;
		dfs(image1,i+1,j);
		dfs(image1,i,j+1);
	}

}
