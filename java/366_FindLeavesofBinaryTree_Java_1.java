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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = removeLeaves(root, list);
            result.add(list);
        }
        
        return result;
    }
    
    public TreeNode removeLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return root;
        }
        else if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        else {
            root.left = removeLeaves(root.left, list);
            root.right = removeLeaves(root.right, list);
            return root;
        }
    }
}
