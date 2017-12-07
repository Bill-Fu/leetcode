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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        List<List<Integer>> tmp = new ArrayList<>();
        
        for (int i = 0; i < result.size(); ++i) {
            tmp.add(result.get(result.size() - 1 - i));
        }
        
        return tmp;
    }
    
    public void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root != null) {
            if (result.size() == level) {
                result.add(new ArrayList<Integer>());
            }
            result.get(level).add(root.val);
            levelOrder(root.left, level + 1, result);
            levelOrder(root.right, level + 1, result);
        }
    }
}
