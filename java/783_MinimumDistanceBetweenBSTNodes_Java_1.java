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
    long prev;
    long result;
    
    public int minDiffInBST(TreeNode root) {
        prev = Integer.MIN_VALUE;
        result = Integer.MAX_VALUE;
        
        inOrder(root);
        
        return (int)result;
    }
    
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            result = Math.min(result, root.val - prev);
            prev = root.val;
            inOrder(root.right);
        }
    }
}
