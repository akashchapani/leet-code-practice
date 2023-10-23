package com.sprint0.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeDiameter {
//https://leetcode.com/problems/tree-diameter/  
	int diameter=0;
	
	public static void main(String args[])
	{
		int [][]edges = { {0,1},{1,2},{1,4},{2,3},{4,5}};
		TreeDiameter td = new TreeDiameter();
		
		System.out.println("Diameter is:  " +td.treeDiameter(edges));
		
		 
	}
	
	public int treeDiameter(int[][] edges) {
		 int result =0; 
		Map <Integer,List<Integer>> graphMap = new HashMap<Integer,List<Integer>>();
		
		for(int[] edge :edges)
		{   List l1 = graphMap.getOrDefault(edge[0], new ArrayList<Integer>());
              l1.add(edge[1]);
			graphMap.put(edge[0],l1 );
			
			List l2 = graphMap.getOrDefault(edge[1], new ArrayList<Integer>());
            l2.add(edge[0]);
            
            graphMap.put(edge[1],l2 );
		}
		
		
		System.out.println("graphMap is  :"+ graphMap);
		System.out.println("edges[0][0] is  :"+ edges[0][0]);
		result = dfs(edges[0][0], -1 ,graphMap );
		 return result;
	 }

	private int dfs(int node, int parent, Map<Integer, List<Integer>> graphMap) {
		// TODO Auto-generated method stub
		int depth1 = 0, depth2 = 0; //depth1: 1st deepest depth, depth2: 2nd deepest depth
		for (int child : graphMap.get(node))
		{
			System.out.println(" child is : "+node +" parent is : "+parent);
			if (child == parent )
				continue ;
			int d= dfs(child,node,graphMap);
			
		//	System.out.println(" Node is : "+node);
			
	System.out.println("Before assignments d is : "+d +" depth1 is : "+depth1 +" depth2 is : "+depth2);
		
			if(d>depth1 )
			{
				depth2 =depth1;
				depth1 = d;
				
			}else if( d>depth2)
			{
				depth2=d;
			}
			System.out.println(" d is : "+d +" depth1 is : "+depth1 +" depth2 is : "+depth2);
		
		}
		 diameter = Math.max(diameter, depth1 + depth2);
		return depth1+1;
	}
}
