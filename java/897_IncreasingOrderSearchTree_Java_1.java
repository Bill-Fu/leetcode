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
    TreeNode result;
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        result = null;
        cur = null;
        
        inOrder(root);
        
        return result;
    }
    
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            
            if (result == null) {
                result = new TreeNode(root.val);
                cur = result;
            }
            else {
                cur.right = new TreeNode(root.val);
                cur = cur.right;
            }
            
            inOrder(root.right);
        }
    }
}
