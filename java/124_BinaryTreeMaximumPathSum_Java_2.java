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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int[] result = new int[1];
            result[0] = Integer.MIN_VALUE;
            
            maxPathSum(root, result);
            
            return result[0];
        }
    }
    
    private int maxPathSum(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        else {
            int left = maxPathSum(root.left, result);
            int right = maxPathSum(root.right, result);
            
            if (root.val + Math.max(0, left) + Math.max(0, right) > result[0]) {
                result[0] = root.val + Math.max(0, left) + Math.max(0, right);
            }
            
            int max = root.val + Math.max(0, Math.max(left, right));
            return max;
        }
    }
}
