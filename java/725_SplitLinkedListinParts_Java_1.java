/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        
        ListNode tmp = root;
        
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        
        int len = length / k;
        int first = length - len * k;
        tmp = root;
        
        for (int i = 0; i < first; ++i) {
            result[i] = tmp;
            
            for (int j = 0; j < len; ++j) {
                tmp = tmp.next;
            }
            
            ListNode tmptmp = tmp.next;
            tmp.next = null;
            tmp = tmptmp;
        }
        
        for (int i = first; i < k; ++i) {
            result[i] = tmp;
            
            if (len != 0) {
                for (int j = 0; j < len - 1; ++j) {
                    tmp = tmp.next;
                }
                
                ListNode tmptmp = tmp.next;
                tmp.next = null;
                tmp = tmptmp;
            }
        }
        
        return result;
    }
}
