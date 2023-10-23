package com.sprint0.fb;
//Please not need to use root.left ot root.right to ensure the value is cleared when we delete. Also remember to delet the prdecessor or successor based on root.left or root.right not null condition
public class DeleteNodeBST {
	TreeNode root;
	public static void main(String args[])
	{
		DeleteNodeBST tree = new DeleteNodeBST();
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
		System.out.println("before deleting  tree is -->");
		tree.printInorder(tree.root);
		tree.deleteNode(tree.root, 3);
		System.out.println("after deleting  tree is -->");
		tree.printInorder(tree.root);
		
	}
	
public void printInorder(TreeNode root)
{
	if(root == null)
		return;
	printInorder( root.left);
	System.out.println(" "+root.val);
	printInorder( root.right);
}
public TreeNode deleteNode(TreeNode root, int key) {
	TreeNode temp;  
	
	if (root==  null)
		return null ;
	if(key<root.val)
		root.left= deleteNode(root.left, key);
	else if( key >root.val)
		root.right= deleteNode(root.right,key);
	else {
		//root is key to be removed 
		if(root.left == null && root.right == null)
			root=null;
		else if(root.left != null)
			{ temp =findmax(root.left);
			  System.out.println("temp.val is :"+temp.val);
			  System.out.println("root.val is :"+root.val);
			  root.val= temp.val;
			  System.out.println( "root.left.val   and root.val :"+root.left.val + "  " +root.val);
			   root.left= deleteNode(root.left,root.val);
			}
		else 
			{
			temp= findmin(root.right);
			 root.val= temp.val;
			 root.right= deleteNode(root.right,root.val);
			}
	} 
	
	return root;
        
    }



public TreeNode findmin(TreeNode root) {
	// TODO Auto-generated method stub
	while(root.left !=null)
		root = root.left;
	return root;
	
}

public TreeNode findmax(TreeNode root) {
	// TODO Auto-generated method stub
	while(root.right !=null)
		root = root.right;
	return root;
}

}
