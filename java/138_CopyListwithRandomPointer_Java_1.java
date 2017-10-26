/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        else {
            RandomListNode result = new RandomListNode(head.label);
            RandomListNode pointer1, pointer2;
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            
            pointer1 = head;
            pointer2 = result;
            pointer2.random = pointer1.random;
            map.put(pointer1, pointer2);
            
            while (pointer1.next != null) {
                pointer1 = pointer1.next;
                pointer2.next = new RandomListNode(pointer1.label);
                pointer2 = pointer2.next;
                pointer2.random = pointer1.random;
                map.put(pointer1, pointer2);
            }
            
            pointer2 = result;
            
            while (pointer2 != null) {
                if (pointer2.random != null) {
                    pointer2.random = map.get(pointer2.random);
                }
                pointer2 = pointer2.next;
            }
            
            return result;
        }
    }
}
