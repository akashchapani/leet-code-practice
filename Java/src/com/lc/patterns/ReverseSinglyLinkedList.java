package com.lc.patterns;

public class ReverseSinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 //  1 -> 2- > 3-> 4 ->5->NULL
	//head
		LinkedList list = new LinkedList(); 

		// 
		// ******INSERTION****** 
		// 

		// Insert the values 
		list = list.insert(list, 1); 
		list = list.insert(list, 2); 
		list = list.insert(list, 3); 
		list = list.insert(list, 4); 
		list = list.insert(list, 5); 
		list = list.insert(list, 6); 
		list = list.insert(list, 7); 
		list = list.insert(list, 8); 

		// Print the LinkedList 
		list.printList(list); 
		LinkedList.Node cur =list.head;
		LinkedList.Node prev=null,next;
			
		try
		{
			while(cur!=null )
			{
				next= cur.next;  // 2       1 2 3  4 5  6 7 8  
				cur.next= prev;
				prev= cur;
				cur= next;
				
			}
			list.head= prev;
			list.printList(list);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	} 
	
	
	public static ListNode reverseList(ListNode head) {
		ListNode prev=null;
		ListNode cur=head;
		ListNode tempNext;
		 
		while(cur !=null)
		{  
			tempNext = cur.next;
			cur.next =prev;
			prev= cur;
			cur = tempNext;	
		
		}
		
		return prev;
	    
	}

}



//Singly Linked List
  class ListNode {
   int val;
   ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

