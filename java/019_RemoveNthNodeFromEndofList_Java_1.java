/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head, ptr2 = head;
        
        for (int i = 0; i < n; ++i) {
            ptr1 = ptr1.next;
        }
        
        if (ptr1 == null) {
            return head.next;
        }
        else {
            while (ptr1.next != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            ptr2.next = ptr2.next.next;

            return head;            
        }
    }
}
