/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        else {
            return mergeKLists(lists, 0, lists.length);
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (right - left == 0) {
            return null;
        }
        else if (right - left == 1) {
            return lists[left];
        }
        else {
            ListNode leftNode = mergeKLists(lists, left, (left + right) / 2);
            ListNode rightNode = mergeKLists(lists, (left + right) / 2, right);
            
            if (leftNode == null) {
                return rightNode;
            }
            else if (rightNode == null) {
                return leftNode;
            }
            else {
                ListNode head, result;
                if (leftNode.val < rightNode.val) {
                    head = leftNode;
                    leftNode = leftNode.next;
                }
                else {
                    head = rightNode;
                    rightNode = rightNode.next;
                }
                
                result = head;
                
                while (leftNode != null && rightNode != null) {
                    if (leftNode.val < rightNode.val) {
                        head.next = leftNode;
                        leftNode = leftNode.next;
                    }
                    else {
                        head.next = rightNode;
                        rightNode = rightNode.next;
                    }
                    head = head.next;
                }
                
                if (leftNode != null) {
                    head.next = leftNode;
                }
                else {
                    head.next = rightNode;
                }
                
                return result;
            }
        }
    }
}
