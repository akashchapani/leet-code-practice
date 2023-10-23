package com.sprint0.fb;



public class BinaryTree {
	

	TreeNode root;
	

	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		tree.root =n1 ;
		n1.left =n2;
		n1.right=n3;
		n2.left= n4;
		n2.right=n5;
		
	//	1
	//2		3	
 //4     5
		
	//   pre order 12453
		System.out.println("preOrder->");
		tree.preOrder(n1);
		System.out.println("---------");
		System.out.println("inOrder->");
		tree.inOrder(n1);
		System.out.println("---------");
		System.out.println("postOrder->");
		tree.postOrder(n1);
		System.out.println("---------");
		tree.flatten(n1);
		System.out.println("inOrder after flatten->");
		tree.inOrder(n1);
		
	}
	
	void preOrder(TreeNode root)
	{
		if (root== null)
			return ;
		
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	void inOrder(TreeNode root)
	{
		if (root== null)
			return ;
		
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
	}
	void postOrder(TreeNode root)
	{
		if (root== null)
			return ;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val);
	}
	
	  public TreeNode flatten(TreeNode root) {
		  
		  if(root==null)
			  return root;
		  if(root.left== null && root.right ==null)
			  return root;
	       TreeNode nodeleft= flatten(root.left);
	       TreeNode noderight= flatten(root.right);
	       if(nodeleft !=null)
	       {
	    	   nodeleft.right = root.right;
	    	   root.right = root.left;
	    	   root.left =null;
	       }
	       
		  return (noderight==null ? nodeleft:noderight);
	    }

}

