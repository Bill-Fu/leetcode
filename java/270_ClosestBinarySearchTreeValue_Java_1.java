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
    public int closestValue(TreeNode root, double target) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
            else if (root.val < target) {
                min = root.val;
                root = root.right;
            }
            else {
                max = root.val;
                root = root.left;
            }
        }
        
        if (max - target < target - min) {
            return (int) max;
        }
        else {
            return (int) min;
        }
    }
}
