/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (tmp.val + l1.val + l2.val >= 10) {
                    tmp.next = new ListNode(1);
                    tmp.val = (tmp.val + l1.val + l2.val) % 10;
                    l1 = l1.next;
                    l2 = l2.next;
                    tmp = tmp.next;
                }
                else {
                    tmp.val = tmp.val + l1.val + l2.val;
                    if (l1.next != null || l2.next != null) {
                        tmp.next = new ListNode(0);
                        l1 = l1.next;
                        l2 = l2.next;
                        tmp = tmp.next;
                    }
                    else {
                        l1 = l1.next;
                        l2 = l2.next;
                    }
                }

            }
            else if (l1 != null && l2 == null) {
                if (tmp.val + l1.val >= 10) {
                    tmp.next = new ListNode(1);
                    tmp.val = (tmp.val + l1.val) % 10;
                    l1 = l1.next;
                    tmp = tmp.next;
                }
                else {
                    tmp.val = tmp.val + l1.val;
                    if (l1.next != null) {
                        tmp.next = new ListNode(0);
                        l1 = l1.next;
                        tmp = tmp.next;
                    }
                    else {
                        l1 = l1.next;
                    }
                }
            }
            else if (l1 == null && l2 != null) {
                if (tmp.val + l2.val >= 10) {
                    tmp.next = new ListNode(1);
                    tmp.val = (tmp.val + l2.val) % 10;
                    l2 = l2.next;
                    tmp = tmp.next;
                }
                else {
                    tmp.val = tmp.val + l2.val;
                    if (l2.next != null) {
                        tmp.next = new ListNode(0);
                        l2 = l2.next;
                        tmp = tmp.next;
                    }
                    else {
                        l2 = l2.next;
                    }
                }
            }
        }
        
        return result;
    }
}
