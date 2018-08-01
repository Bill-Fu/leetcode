/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int res = 0;
        boolean flag = false;
        Set<Integer> set = new HashSet<>();
        
        for (int val: G) {
            set.add(val);
        }
        
        
        while (head != null) {
            if (set.contains(head.val)) {
                flag = true;
            }
            else {
                if (flag) {
                    res++;
                    flag = false;
                }
            }
            
            head = head.next;
        }
        
        if (flag) {
            res++;
        }
        
        return res;
    }
}
