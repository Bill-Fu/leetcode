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
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        levelOrder(root, 0, list);
        
        return list.get(list.size() - 1).get(0);
    }
    
    public void levelOrder(TreeNode root, int level, List<List<Integer>> list) {
        if (root != null) {
            if (list.size() == level) {
                list.add(new ArrayList<Integer>());            
            }
            
            list.get(level).add(root.val);
            
            levelOrder(root.left, level + 1, list);
            levelOrder(root.right, level + 1, list);
        }
    }
}
