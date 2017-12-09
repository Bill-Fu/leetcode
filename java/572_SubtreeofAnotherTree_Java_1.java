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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        else {
            if (check(s, t)) {
                return true;
            }
            else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        }
    }
    
    public boolean check(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            if (s.val != t.val) {
                return false;
            }
            else {
                return check(s.left, t.left) && check(s.right, t.right);
            }
        }
        else if (s == null && t == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
