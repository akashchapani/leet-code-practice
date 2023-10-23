package com.sprint0.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestOfEachTreeNode {
	TreeNode root;
	public static void main(String args[])
	{
		FindLargestOfEachTreeNode tree = new FindLargestOfEachTreeNode();
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(8);
		tree.root =n1 ;
		n1.left =n2;
		n1.right=n3;
		n2.left= n4;
		n2.right=n5;
		n3.left = n6;
		n3.right=n7;
		List<Integer> result = tree.largestValues(tree.root);
		result.forEach(System.out::println);
		
	}


	 public List<Integer> largestValues(TreeNode root) {
         List<Integer> levelMaxList =new ArrayList<Integer>();
        if(root ==null)
            return levelMaxList ;
        Queue <TreeNode> myqueue = new LinkedList<TreeNode>() ;
         int count=1;
       
      
        int queuesize =1; //for the root
        myqueue.add(root);
            
        while(queuesize>0)
        {
            int maxValueatLevel= Integer.MIN_VALUE;
            
            for(int i=0; i< queuesize; i++)
            {
                TreeNode node = myqueue.poll();
                maxValueatLevel= Math.max(maxValueatLevel,node.val);
                
                if(node.left != null)
                    myqueue.add(node.left);
                if(node.right != null)
                    myqueue.add(node.right);
                
            }
            
          levelMaxList.add(maxValueatLevel);
            queuesize=myqueue.size();
        }
        
        return levelMaxList;
    }
}
