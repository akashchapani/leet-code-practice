/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 *
 */
var middleNode = function(head) {
  let singlePointer = head;
  let doublePointer = head;

  while(doublePointer && doublePointer.next){
    singlePointer = singlePointer.next;
    doublePointer = doublePointer.next.next;
  }

  return singlePointer;
};
