package com.sprint0.wf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.lc.patterns.LinkedList;;
public class CourseShedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//0 n-1 array indexes for n node
		
		//TC1
		int [][] prerequisite = {{1,0},{3,2}};
		int []result;
	//Output should be 0-1-2-3  or 0 2 1 3 
		int numCourses = 4;
		result= findOrder(4,prerequisite);
		System.out.println("Result is  : "+Arrays.toString(result));
     
	}
	
	
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	int []result;
    	Map <Integer, List<Integer>> adjList = new HashMap <Integer, List<Integer>>();
    	// Key is vertex and Values are Edges destination 
    	int [] inDegree= new int[numCourses]; // Capture indegree for each node 
    	int [] topologicalOrder= new int[numCourses];
    	for (int i=0; i<prerequisites.length; i ++)
    	{
    		int dest = prerequisites[i][0];
    		int source = prerequisites[i][1];
    		List<Integer> list = adjList.getOrDefault(source, new ArrayList<Integer>());
    		list.add(dest);
    		adjList.put(source, list); // Adjacency Matrix prepared
    		
    		inDegree[dest]  = inDegree[dest] + 1; //Record Indegree
    		
    		
    	}
    	System.out.println("adjList map  "+adjList);
    	System.out.println("inDegree array"+Arrays.toString(inDegree));
    	
    	
    	Queue<Integer> q= new java.util.LinkedList<Integer>();
    	for (int i=0; i<numCourses; i++)
    	{ 
    		if(inDegree[i] == 0) // If inDegree is 0 then add to queue
    		{
    			q.add(i);
    		}
    		
    	}
    	
    	
    	int i=0;
    	System.out.println("before start " +q.size());
    	while(!q.isEmpty())
    	{
    		int node =q.remove();
    		System.out.println("Node value is " +node);
    		topologicalOrder[i++]= node;
    		
    		if(adjList.containsKey(node))
    		{
    			for(Integer neigbournode : adjList.get(node))
    			{
    				inDegree[neigbournode] --;
    				
    				if (inDegree[neigbournode] == 0)
    					q.add(neigbournode);
    				System.out.println("neigbournode  " + neigbournode + ":" +q.size());
    			}
    		}
    		
    	}
    	
        if (i == numCourses) {
            return topologicalOrder;
          }
        return new int[0];
    }

}
