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
    List<Integer> result;
    
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        
        preorder(root);
        
        return result;
    }
    
    public void preorder(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
