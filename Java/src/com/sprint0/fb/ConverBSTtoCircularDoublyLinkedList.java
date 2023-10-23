package com.sprint0.fb;

public class ConverBSTtoCircularDoublyLinkedList {
	   Node  first =null;
	    Node last = null;
	    Node prev= null;
	    public Node treeToDoublyList(Node root) {
	        
	        
	      
	        dfs(root ) ;
	         if(first !=null && last != null) 
	         {
	              first.left= last;
	       
	              last.right =first;
	         }else if( first !=null && last ==null)
	         {
	             last = first;
	             first.left =last;
	             last.right =first;
	         }
	        
	        return first;
	        
	    }
	     
	    public void dfs(Node node)
	    {
	        if(node == null)
	            return;
	        
	        dfs(node.left);
	        
	        if(prev == null)
	        {
	            first = node;
	             prev=node;
	            
	            
	            
	        }else
	        {
	            prev.right=node;
	            node.left =prev;
	            prev =node ;  
	           
	            last=node;
	            
	        }
	        
	        dfs(node.right);
	      

	       
	     
	        
	    }

}



//Definition for a Node.
class Node {
 public int val;
 public Node left;
 public Node right;

 public Node() {}

 public Node(int _val) {
     val = _val;
 }

 public Node(int _val,Node _left,Node _right) {
     val = _val;
     left = _left;
     right = _right;
 }
};
