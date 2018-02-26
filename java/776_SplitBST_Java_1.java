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
    TreeNode[] result;
    TreeNode[] cur;
    
    public TreeNode[] splitBST(TreeNode root, int V) {
        result = new TreeNode[2];
        cur = new TreeNode[2];
        
        split(root, V);
        
        return result;
    }
    
    public void split(TreeNode root, int V) {
        if (root != null) {
            if (root.val > V) {
                if (cur[1] == null) {
                    result[1] = root;
                    cur[1] = result[1];
                }
                else {
                    cur[1].left = root;
                    cur[1] = cur[1].left;
                }

                TreeNode tmp = root.left;

                root.left = null;

                split(tmp, V);
            }
            else {
                if (cur[0] == null) {
                    result[0] = root;
                    cur[0] = result[0];
                }
                else {
                    cur[0].right = root;
                    cur[0] = cur[0].right;
                }
                
                TreeNode tmp = root.right;
                
                root.right = null;
                
                split(tmp, V);
            }            
        }

    }
}
