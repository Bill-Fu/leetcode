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
        int l1len = 0;
        int l2len = 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        ListNode tmp = l1;
        
        while (tmp != null) {
            l1len++;
            tmp = tmp.next;
        }
        
        tmp = l2;
        
        while (tmp != null) {
            l2len++;
            tmp = tmp.next;
        }
        
        tmp = l1;
        
        while (tmp != null) {
            map1.put(l1len--, tmp.val);
            tmp = tmp.next;
        }
        
        tmp = l2;
        
        while (tmp != null) {
            map2.put(l2len--, tmp.val);
            tmp = tmp.next;
        }
        
        ListNode result = null;
        int carry = 0;
        int count = 1;
        
        while (map1.containsKey(count) || map2.containsKey(count) || carry != 0) {
            tmp = result;
            
            result = new ListNode ((map1.getOrDefault(count, 0) + map2.getOrDefault(count, 0) + carry) % 10);
            
            result.next = tmp;
            
            carry = (map1.getOrDefault(count, 0) + map2.getOrDefault(count, 0) + carry) / 10;
            
            count++;
        }
        
        return result;
    }
}
