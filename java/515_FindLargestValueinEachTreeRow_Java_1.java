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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        largestValues(root, 0, result);
        
        return result;
    }
    
    public void largestValues(TreeNode root, int level, List<Integer> result) {
        if (root != null) {
            if (result.size() <= level) {
                result.add(root.val);
            }
            else {
                result.set(level, Math.max(root.val, result.get(level)));
            }
            
            largestValues(root.left, level + 1, result);
            largestValues(root.right, level + 1, result);
        }
    }
}
