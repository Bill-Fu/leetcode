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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        else {
            TreeNode result = new TreeNode(root.val);
            
            while (root.left != null) {
                TreeNode tmp = new TreeNode(root.left.val);
                
                if (root.right != null) {
                    tmp.left = new TreeNode(root.right.val);                    
                }
                
                tmp.right = result;
                
                result = tmp;
                
                root = root.left;
            }
            
            return result;
        }
    }
}
