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
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        else {
            hasPathSum(root, sum, 0);
            
            return result;
        }
    }
    
    public void hasPathSum(TreeNode root, int sum, int cur) {
        if (root != null && result == false) {
            cur += root.val;
            if (root.left == null && root.right == null) {
                if (cur == sum) {
                    result = true;
                }
            }
            else {
                hasPathSum(root.left, sum, cur);
                hasPathSum(root.right, sum, cur);
            }
        }
    }
}
