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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode result = new TreeNode(v);
            
            result.left = root;
            
            return result;
        }
        else {
            levelTraverse(root, 1, d - 1, v);
            
            return root;
        }
    }
    
    public void levelTraverse(TreeNode root, int dep, int targetDep,int val) {
        if (root != null) {
            if (dep == targetDep) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                
                root.left = new TreeNode(val);
                root.left.left = left;
                
                root.right = new TreeNode(val);
                root.right.right = right;
            }
            else {
                levelTraverse(root.left, dep + 1, targetDep, val);
                
                levelTraverse(root.right, dep + 1, targetDep, val);
            }
        }
    }
}
