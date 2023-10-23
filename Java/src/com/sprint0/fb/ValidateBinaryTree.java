package com.sprint0.fb;

import java.util.Arrays;

//https://leetcode.com/problems/validate-binary-tree-nodes/
//  return  root != -1 &&  dfs(  checking if root doesnt exist and multiple roos is important

public class ValidateBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
			int n=4;
			int[] leftChild= {1,0,3,-1};
			int[] rightChild= {-1,-1,-1,-1};
			ValidateBinaryTree bt= new ValidateBinaryTree();
			bt.validateBinaryTreeNodes(n, leftChild, rightChild);

	}
	
	   public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
	        
	       int[] inDegree =new int[n];
	        int count =0;
	        for( int i=0; i<n; i++)
	        {
	            if(leftChild[i] != -1 && inDegree[leftChild[i]]++==1 )
	            {    
	                 return false;
	                 
	            }
	        }
	        
	         for( int i=0; i<n; i++)
	        {
	       
	        	 if(rightChild[i] != -1 && inDegree[rightChild[i]]++==1)        
	        		 	return false;
	            
	        }
	         int root =-1;
	         for( int i=0; i<n; i++)
	         {  
	             
	             if(inDegree[i]==0) 	            		 
	             {
	            	 if(root != -1)
	            		 return false ;
	            	 root =inDegree[i];
	             }
	         }
	         
	         boolean[] visited = new boolean[n];
	       
	         	    
	       return  root != -1 &&  dfs(root,leftChild,rightChild,visited);
	         
	    }

	private boolean dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
		// TODO Auto-generated method stub
		if(root== -1)
			return true;
		if(visited[root])
			return false ;
		visited[root]=true;
		return dfs(leftChild[root],leftChild,  rightChild,  visited)
				&& dfs(rightChild[root],leftChild,  rightChild,  visited);
		
		
		
	}

}
