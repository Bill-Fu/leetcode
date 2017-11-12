/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        else {
            int lenA, lenB;
            lenA = lenB = 0;
            
            for (ListNode tmp = headA; tmp != null; tmp = tmp.next) {
                lenA++;
            }
            
            for (ListNode tmp = headB; tmp != null; tmp = tmp.next) {
                lenB++;
            }
            
            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; ++i) {
                    headA = headA.next;
                }
            }
            else {
                for (int i = 0; i < lenB - lenA; ++i) {
                    headB = headB.next;
                }
            }
            
            while (headA != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            
            return headA;
        }
    }
}
