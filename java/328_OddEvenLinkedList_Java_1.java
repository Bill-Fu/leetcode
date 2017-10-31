/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        else {
            ListNode tail = head;
            while (tail.next != null && tail.next.next != null) {
                tail = tail.next.next;
            }
            
            ListNode ptr1 = head;
            ListNode ptr2 = tail;
            ListNode tmp;
            
            while (ptr1 != tail) {
                tmp = ptr1.next.next;
                ptr1.next.next = ptr2.next;
                ptr2.next = ptr1.next;
                ptr2 = ptr2.next;
                ptr1.next = tmp;
                ptr1 = ptr1.next;
            }
            
            return head;
        }
    }
}
