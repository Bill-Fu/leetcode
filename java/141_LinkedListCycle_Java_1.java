/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        else {
            ListNode ptr1 = head;
            ListNode ptr2 = head;
            
            do {
                ptr2 = ptr2.next;
                if (ptr2 != null) {
                    ptr2 = ptr2.next;
                }
                ptr1 = ptr1.next;
            } while (ptr2 != null && ptr2 != ptr1);
            
            if (ptr2 == null) {
                return false;
            }
            else {
                return true;
            }
        }
    }
}
