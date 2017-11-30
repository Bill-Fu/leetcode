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
    public String tree2str(TreeNode t) {
        String result = "";
        
        if (t != null) {
            result += Integer.toString(t.val);
            if (t.left != null && t.right != null) {
                result += "(";
                result += tree2str(t.left);
                result += ")(";
                result += tree2str(t.right);
                result += ")";
            }
            else if (t.left != null && t.right == null) {
                result += "(";
                result += tree2str(t.left);
                result += ")";                
            }
            else if (t.left == null && t.right != null) {
                result += "()(";
                result += tree2str(t.right);
                result += ")";
            }            
        }
        
        return result;
    }
}
