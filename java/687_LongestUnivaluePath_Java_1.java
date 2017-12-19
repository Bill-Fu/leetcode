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
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            longestUnivaluePathPack(root);
        }
        
        return result;
    }
    
    public void longestUnivaluePathPack(TreeNode root) {
        if (root != null) {
            result = Math.max(result, traverse(root.left, root.val) + traverse(root.right, root.val));
            longestUnivaluePathPack(root.left);
            longestUnivaluePathPack(root.right);
        }
    }
    
    public int traverse(TreeNode root, int val) {
        if (root == null || root.val != val) {
            return 0;
        }
        else {
            return Math.max(traverse(root.left, val), traverse(root.right, val)) + 1;
        }
    }
}
