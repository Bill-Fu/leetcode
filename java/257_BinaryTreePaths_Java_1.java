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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        binaryTreePaths(root, result, "");
        
        return result;
    }
    
    public void binaryTreePaths(TreeNode root, List<String> result, String cur) {
        if (root != null) {
            if (cur.length() != 0) {
                cur += "->" + Integer.toString(root.val);
            }
            else {
                cur += Integer.toString(root.val);
            }
            
            if (root.left == null && root.right == null) {
                result.add(cur);
            }
            else {
                binaryTreePaths(root.left, result, new String(cur));
                binaryTreePaths(root.right, result, new String(cur));
            }
        }
    }
}
