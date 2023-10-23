package com.sprint0.fb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializeDeserialize {

    String splitter=",";
    String NN = "X";  //NullNode string representation
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null)
            return NN;
        String  left = serialize(root.left);
        String right = serialize(root.right);
        
        return root.val +splitter+left+splitter+right;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] elemenets = data.split(splitter);
        Queue<String> nodevalueQueue= new LinkedList();
        nodevalueQueue.addAll(Arrays.asList(elemenets));
      TreeNode result=   buildTree(nodevalueQueue);
        return result;
        
    }
    public TreeNode buildTree(Queue<String> nodeList)
    {  String currentItem= nodeList.remove();
        if(currentItem.equals(NN))
            return null;
            
        TreeNode node = new TreeNode(Integer.parseInt(currentItem));
         node.left = buildTree(nodeList);
          node.right = buildTree(nodeList);
     
     return node;
        
    }

}
