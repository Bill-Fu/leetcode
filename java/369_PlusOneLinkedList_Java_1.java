/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (plusOneCarry(head) == 0) {
            return head;
        }
        else {
            ListNode result = new ListNode(1);
            
            result.next = head;
            
            return result;
        }
    }
    
    public int plusOneCarry(ListNode head) {
        if (head == null) {
            return 1;
        }
        else {
            int carry = plusOneCarry(head.next);
            if (carry == 1) {
                head.val = (head.val + carry) % 10;
                return head.val == 0? 1: 0;
            }
            else {
                return 0;
            }
        }
    }
}
