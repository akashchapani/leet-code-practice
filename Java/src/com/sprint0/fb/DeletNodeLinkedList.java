package com.sprint0.fb;

public class DeletNodeLinkedList {
	public static void main(String args[])
	{
		ListNode ln = new ListNode(1);
		ListNode ln1 = new ListNode(2);
		ListNode ln2 = new ListNode(3);
		ListNode ln3 = new ListNode(4);
		ln.next =ln1;
		ln1.next =ln2;
		ln2.next =ln3;
		ln3.next =null;
	 ListNode cur = ln;
	 while(cur !=null)
	 {
		 System.out.println("List item "+ cur.val);
		 cur =cur.next;
	 }
	 System.out.println("------------------------------");
	 cur = ln;
	 new DeletNodeLinkedList().deleteNode(ln2);
	 while(cur !=null)
	 {
		 System.out.println("List item "+ cur.val);
		 cur =cur.next;
	 }
	}
    public void deleteNode(ListNode node) {
    	
       ListNode temp= new ListNode(node.next.val);
       temp = node.next;
       node.next = temp.next;
       node.val =temp.val;
       
    }

}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val =val;
	}
}
