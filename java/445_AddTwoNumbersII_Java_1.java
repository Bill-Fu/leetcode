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
        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);
        
        int carry = 0;
        
        ListNode resl = null;
        
        while (newl1 != null || newl2 != null || carry != 0) {
            ListNode tmp = resl;
            int l1val = 0;
            int l2val = 0;
            
            if (newl1 != null) {
                l1val = newl1.val;
            }
            
            if (newl2 != null) {
                l2val = newl2.val;
            }
            
            
            resl = new ListNode ((l1val + l2val + carry) % 10);
            resl.next = tmp;
            
            carry = (l1val + l2val + carry) / 10;
            
            if (newl1 != null) {
                newl1 = newl1.next;
            }
            
            if (newl2 != null) {
                newl2 = newl2.next;
            }
        }
        
        return resl;
    }
    
    public ListNode reverse(ListNode preL) {
        ListNode newL = null;
        
        while (preL != null) {
            ListNode tmp = newL;
            newL = new ListNode(preL.val);
            newL.next = tmp;
            preL = preL.next;
        }
        
        return newL;
    }
}
