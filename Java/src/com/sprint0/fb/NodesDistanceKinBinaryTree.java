package com.sprint0.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodesDistanceKinBinaryTree {
    Map<TreeNode,List<TreeNode>> nodeMap = new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //Build the undirected graph for given Binary tree
        buildMap(root,null);
        
        System.out.println("My Map is :" +nodeMap.toString());
        List<Integer> result = new ArrayList();
        Set<TreeNode> visited = new HashSet();
        Queue<TreeNode> myqueue = new LinkedList();
        
        if(root == null)
            return result;
       
             myqueue.add(target);
       
             visited.add(target);
        while( !myqueue.isEmpty())
        {
            int size = myqueue.size();
            
             if(K==0)
            {
                for(int i=0; i <size; i++)
                    result.add(myqueue.poll().val);
                 
                 return result;
            }
            
        for (int i = 0; i < size; i++) {
            TreeNode node= myqueue.poll();
            
           
            for(TreeNode neighbour:nodeMap.get(node))
            {
               if(visited.contains(neighbour))
                   continue;
                visited.add(neighbour);
                myqueue.add(neighbour);
                 
            }
            
        }
            K--;
        }
        
        
       return result; 
    }
    
    public void buildMap(TreeNode node , TreeNode parent)
    {
        if(node == null)
            return;
        
        if(!nodeMap.containsKey(node))
        {
            nodeMap.put(node, new ArrayList<TreeNode>());
            if(parent !=null )
            {
                nodeMap.get(node).add(parent);
                nodeMap.getOrDefault(parent, new ArrayList<TreeNode>()).add(node);
            }  
            
            buildMap(node.left,node);// for left branch
            buildMap(node.right,node); // for right branch 
        }
    }
    
    
}
