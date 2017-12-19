/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode result = head;
        
        while (head != null) {
            if (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        
        return result;
    }
}
