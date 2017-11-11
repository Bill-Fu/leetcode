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
        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode prevNode = null;
            
            while (head != null) {
                ListNode curNode = new ListNode(head.val);
                curNode.next = prevNode;
                prevNode = curNode;
                head = head.next;
            }
            
            return prevNode;
        }
    }
}
