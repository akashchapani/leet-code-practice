package com.lc.playground;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   
	    int[][] parentChildPairs1 = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
	        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
	        {15, 13}
	    };
	    
	    int[][] parentChildPairs2 = new int[][] {
	        {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
	        {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
	    };
	    
//	 / System.out.println("TC1 "+  hasCommonAncestor(parentChildPairs2, 4, 12));
	  System.out.println("TC1 "+  hasCommonAncestor(parentChildPairs2, 4, 12));
	  System.out.println("TC2 "+  hasCommonAncestor(parentChildPairs2, 1, 6));
	  System.out.println("TC3 "+  hasCommonAncestor(parentChildPairs2, 1, 12));
	}
	
	public static boolean hasCommonAncestor( int[][] parentChildPairs , int node1, int node2)
	  { 
	    Map <Integer, List<Integer>> parentChildMap= new HashMap<Integer,List<Integer>>();
	    
	    Map <Integer, List<Integer>> resultMap= new HashMap<Integer,List<Integer>>();
	    int [] nodepair;
	    int parentnode=0 ,childnode=0;
	    List<Integer> parentList,gpList,tmpList;
	     for(int i=0; i <parentChildPairs.length; i++)
	     {
	       nodepair= parentChildPairs[i];
	       parentnode= parentChildPairs[i][0];  //parent
	       childnode= parentChildPairs[i][1];  //child
	       
	       parentList= parentChildMap.getOrDefault(childnode, new ArrayList<Integer>());
	       parentList.add(parentnode);
	       parentChildMap.put(childnode,parentList);
	     }
	    
	     System.out.println("May Map is "+parentChildMap);
	   
			/* Bellow block I tried for iterative which worked only for 2 levels
			 * //4 -3 1 2 for(int key: parentChildMap.keySet()) { //2-10 -- //2 -10-11
			 * parentList= parentChildMap.get(key); //--10--11 tmpList =new
			 * ArrayList<Integer>(parentList);
			 * 
			 * 
			 * for(int grandparent:parentList) {
			 * 
			 * gpList=parentChildMap.get(grandparent);
			 * System.out.println("grandparent key and value : "+grandparent +"  "+gpList);
			 * if (gpList != null) { for( int gpnode: gpList) { tmpList.add(gpnode); //10
			 * -11 } }else { continue; } } //
			 * tmpList.forEach(obj->System.out.println("Tmplist item: " +obj));
			 * resultMap.put(key,tmpList);
			 * 
			 * 
			 * }
			 */
	    	    
	    List <Integer> list1=new ArrayList<Integer>();
	    List <Integer> list2=new ArrayList<Integer>();
	    
	    
	    dfs(list1,node1,parentChildMap);
	    dfs(list2,node2,parentChildMap);
	    

	   
	   for(int i=0; i<list1.size(); i++)
	   {
		   for(int j=0; j<list2.size(); j++)
		   {
			   if(list1.get(i) == list2.get(j))
			   {
				   return true ;
			   }
		   }
	   }
	    return false ;
	     
	  }

	private static void dfs(List<Integer> list1, int node1, Map<Integer, List<Integer>> parentChildMap) {
		// TODO Auto-generated method stub
		List<Integer> parentList= new ArrayList<Integer>();
		parentList =parentChildMap.get(node1);
		if(parentList == null || parentList.size()==0)
			 return;
		
		for(int i=0;i <parentList.size(); i++)
		{  list1.add(parentList.get(i));
			dfs(list1,parentList.get(i),parentChildMap);
		}
	}
	}


