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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root != null) {
            stack.push(root);
            
            while (stack.empty() == false) {
                TreeNode tmp = stack.pop();
                
                result.add(tmp.val);
                
                if (tmp.right != null) {
                    stack.push(tmp.right);
                }
                
                if (tmp.left != null) {
                    stack.push(tmp.left);
                }
            }
        }
        
        return result;
    }
}
