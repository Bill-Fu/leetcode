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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        else {
            if (Math.abs(height(root.left) - height(root.right)) > 1 || isBalanced(root.left) == false || isBalanced(root.right) == false) {
                return false;
            }
            else {
                return true;
            }
        }
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
