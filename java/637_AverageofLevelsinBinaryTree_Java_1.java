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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<long[]> list = new ArrayList<>();
        
        averageOfLevels(root, 0, list);
        
        for (int i = 0; i < list.size(); ++i) {
            result.add(((double) list.get(i)[0]) / list.get(i)[1]);
        }
        
        return result;
    }
    
    public void averageOfLevels(TreeNode root, int level, List<long[]> list) {
        if (root != null) {
            if (list.size() <= level) {
                list.add(new long[2]);
            }
            list.get(level)[0] += root.val;
            list.get(level)[1] += 1;
            averageOfLevels(root.left, level + 1, list);
            averageOfLevels(root.right, level + 1, list);
        }
    }
}
