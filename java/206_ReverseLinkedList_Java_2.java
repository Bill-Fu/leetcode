/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }
    
    private ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        else {
            ListNode cur = new ListNode(head.val);
            cur.next = prev;
            return reverseList(head.next, cur);
        }
    }
}
