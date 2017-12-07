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
    long result = Long.MAX_VALUE;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        else {
            min = root.val;
            
            traverse(root);
            
            return result == Long.MAX_VALUE? -1: (int) result;
        }
    }
    
    public void traverse(TreeNode root) {
        if (root.left != null && root.right != null) {
            if (root.left.val == min) {
                traverse(root.left);
            }
            else {
                if (root.left.val < result) {
                    result = root.left.val;
                }
            }
            if (root.right.val == min) {
                traverse(root.right);
            }
            else {
                if (root.right.val < result) {
                    result = root.right.val;
                }
            }
        }
    }
}
