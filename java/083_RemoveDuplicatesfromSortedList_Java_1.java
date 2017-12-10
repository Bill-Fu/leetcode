/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        else {
            ListNode tmp = head;
            
            while (tmp.next != null) {
                if (tmp.val == tmp.next.val) {
                    tmp.next = tmp.next.next;
                }
                else {
                    tmp = tmp.next;
                }
            }
            
            return head;
        }
    }
}
