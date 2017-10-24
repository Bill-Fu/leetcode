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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode tmp;
        
        if (root != null) {
            stack.push(root);
        }
        
        while (stack.empty() == false) {
            tmp = stack.pop();
            if (tmp.left == null && tmp.right == null) {
                result.add(tmp.val);
            }
            else if (tmp.left == null && tmp.right != null) {
                stack.push(tmp.right);
                result.add(tmp.val);
            }
            else if (tmp.left != null && tmp.right == null) {
                stack.push(new TreeNode(tmp.val));
                stack.push(tmp.left);
            }
            else {
                stack.push(tmp.right);
                stack.push(new TreeNode(tmp.val));
                stack.push(tmp.left);
            }
        }
        
        return result;
    }
}
