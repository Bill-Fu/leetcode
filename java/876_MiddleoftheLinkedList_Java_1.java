/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        
        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }
        
        ListNode res = head;
        
        for (int i = 0; i < length / 2; ++i) {
            res = res.next;
        }
        
        return res;
    }
}
