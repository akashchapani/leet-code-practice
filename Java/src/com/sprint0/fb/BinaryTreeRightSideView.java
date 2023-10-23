package com.sprint0.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null)
            return resultList;
        
        Queue<TreeNode> myQueue = new LinkedList();
        int queueSize=0;
        myQueue.add(root);
        while(!myQueue.isEmpty())
        {   
            queueSize=myQueue.size();
            for(int i=0; i<queueSize; i++)
            {
                 TreeNode node = myQueue.poll();
                                
                if(node.left != null)
                  myQueue.add(node.left);
                if (node.right !=null)
                    myQueue.add(node.right);
                
                if(i == queueSize-1)
                    resultList.add(node.val);
                
            }
        }
        
        return resultList;
    
    }

}
