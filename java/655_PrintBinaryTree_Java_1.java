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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int height = height(root);
        
        for (int i = 0; i < height; ++i) {
            List<String> tmp = new ArrayList<>();
            
            for (int j = 0; j < (int) Math.pow(2, height) - 1; ++j) {
                tmp.add("");
            }
            
            result.add(tmp);
        }
        
        print(root, 0, 0, result.get(0).size(), result);
        
        return result;
    }
    
    public void print(TreeNode root, int level, int min, int max, List<List<String>> result) {
        if (root != null) {
            result.get(level).set((min + max) / 2, Integer.toString(root.val));
            
            print(root.left, level + 1, min, (min + max) / 2, result);
            
            print(root.right, level + 1, (min + max) / 2 + 1, max, result);
        }
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
