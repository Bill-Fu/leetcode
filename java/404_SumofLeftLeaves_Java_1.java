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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] result = new int[1];

        sumOfLeftLeaves(root, result);

        return result[0];
    }
    
    public void sumOfLeftLeaves(TreeNode root, int[] result) {
        if (root != null) {
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    result[0] += root.left.val;
                }
                else {
                    sumOfLeftLeaves(root.left, result);
                }
            }
            
            sumOfLeftLeaves(root.right, result);
        }
    }
}
