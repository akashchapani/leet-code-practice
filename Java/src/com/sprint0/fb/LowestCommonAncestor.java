package com.sprint0.fb;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return  dfs(root,p,q);
         
         
     }
     
     public TreeNode dfs(TreeNode root,TreeNode p,TreeNode q)
     {
         if(root==null || root.val == p.val  || root.val == q.val)
         {
             return root;
         }
         
         TreeNode left = dfs(root.left,p,q);
         TreeNode right = dfs(root.right,p,q);
         
         if(left !=null && right != null)
             return root;
         else if( left!=null && right == null)
             return left;
         else if( right !=null && left ==null)
             return right;
         else return null;
     }

}
