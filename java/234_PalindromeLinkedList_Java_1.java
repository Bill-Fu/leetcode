/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        else {
            int length = 0;
            for (ListNode i = head; i != null; i = i.next) {
                length++;
            }
            
            int[] array = new int[length];
            
            for (int i = 0; i < length; ++i) {
                array[i] = head.val;
                head = head.next;
            }
            
            for (int i = 0; i < length / 2; ++i) {
                if (array[i] != array[length - 1 -i]) {
                    return false;
                }
            }
            
            return true;
        }
    }
}
