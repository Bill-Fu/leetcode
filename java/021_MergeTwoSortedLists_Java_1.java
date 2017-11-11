/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else {
            if (l2 == null) {
                return l1;
            }
            else {
                ListNode head;
                ListNode cur;
                
                if (l1.val < l2.val) {
                    head = l1;
                    l1 = l1.next;
                    
                }
                else {
                    head = l2;
                    l2 = l2.next;
                }
                
                cur = head;
                while (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        cur.next = l1;
                        l1 = l1.next;
                    }
                    else {
                        cur.next = l2;
                        l2 = l2.next;
                    }
                    cur = cur.next;
                }
                
                if (l1 == null) {
                    cur.next = l2;
                }
                else {
                    cur.next = l1;
                }
                
                return head;
            }
        }
    }
}
