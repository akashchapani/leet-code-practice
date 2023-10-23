package com.sprint0.fb;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTHelper(root,Long.MAX_VALUE,Long.MIN_VALUE);
            
        
    }
    
    public boolean isValidBSTHelper(TreeNode node, long max, long min)
    {
        if(node == null)
            return true;
        if( node.val<=min || node.val>=max)
            return false;
        //for Left branch
         boolean left=   isValidBSTHelper(node.left,node.val,min );
        
        //For right branch
         boolean right =  isValidBSTHelper(node.right,max,node.val);
        
        return( left && right );
    }
}
