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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return result;
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int left = height(root.left);
            int right = height(root.right);
            
            if (left + right > result) {
                result = left + right;
            }
            
            return Math.max(left, right) + 1;
        }
    }
}
