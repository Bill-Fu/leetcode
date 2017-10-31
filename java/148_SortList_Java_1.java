/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode pivot = head;
            ListNode pivot_cur = head;
            ListNode less = null;
            ListNode greater = null;
            ListNode less_cur = null;
            ListNode greater_cur = null;
            
            
            head = head.next;
            
            while (head != null) {
                if (head.val < pivot.val) {
                    if (less == null) {
                        less = head;
                        less_cur = less;
                    }
                    else {
                        less_cur.next = head;
                        less_cur = less_cur.next;
                    }
                }
                else if (head.val > pivot.val) {
                    if (greater == null) {
                        greater = head;
                        greater_cur = greater;
                    }
                    else {
                        greater_cur.next = head;
                        greater_cur = greater_cur.next;
                    }
                }
                else {
                    pivot_cur.next = head;
                    pivot_cur = pivot_cur.next;
                }
                head = head.next;
            }
            
            pivot_cur.next = null;
            if (less != null) {
                less_cur.next = null;
            }
            if (greater != null) {
                greater_cur.next = null;
            }
            
            return concat(sortList(less), pivot, sortList(greater));
        }
    }
    
    private ListNode concat(ListNode less, ListNode pivot, ListNode greater) {
        ListNode head;
        if (less == null) {
            head = pivot;
            while (pivot.next != null) {
                pivot = pivot.next;
            }
            pivot.next = greater;
            return head;
        }
        else {
            head = less;
            while (less.next != null) {
                less = less.next;
            }
            less.next = pivot;
            while (less.next != null) {
                less = less.next;
            }
            less.next = greater;
            return head;
        }
    }
}
