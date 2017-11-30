/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        
        InorderTraverse(root, list);
        
        Integer[] array = list.toArray(new Integer[list.size()]);
        
        int ptr1 = 0;
        int ptr2 = array.length - 1;

        while (ptr1 < ptr2) {
            if (array[ptr1] + array[ptr2] == k) {
                return true;
            }
            else if (array[ptr1] + array[ptr2] < k) {
                ptr1++;
            }
            else {
                ptr2--;
            }
        }

        return false;
    }
    
    public void InorderTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            InorderTraverse(root.left, list);
            list.add(root.val);
            InorderTraverse(root.right, list);
        }
    }
}
