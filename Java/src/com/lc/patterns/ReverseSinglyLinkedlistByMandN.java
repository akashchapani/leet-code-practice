package com.lc.patterns;

import com.lc.patterns.LinkedList.Node;

public class ReverseSinglyLinkedlistByMandN {
	


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
			
			// 1 ,2 ,3, 4 , 5, 6,7, 8
			
			// M=2 and N=5
			
			//result should be  1, 5 ,4,3,2,6,7,8
			list.head=reverseBetween(list.head,1,5);
			list.printList(list); 
			
			

}
		 public static Node reverseBetween(Node head, int m, int n) {
			   Node prev=null;
				 Node current= head;
				 Node start=head;
				 int possitionCounter=1;
				 Node next;
			 
			
			 while( possitionCounter < m)
			 {    start=current;
				 current= current.next;
				 possitionCounter++;
			 }
			 
				// 3,5 
			     //  1
			 
			 Node tail=current;
			 while (possitionCounter>=m && possitionCounter <= n)
			 {
				 //2 ,3, 4 , 5  6
				 next=current.next;
				 current.next= prev;
				 prev=current ;
				 current =next;
				 possitionCounter++;
			 }
			 start.next=prev;
			 tail.next =current;
		
			 
		
			 
			  if(m > 1) {
				    return head;
				  } else {
				    return prev;
				  }
		        
		    }
}