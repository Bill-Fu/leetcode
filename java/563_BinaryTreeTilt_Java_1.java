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
    public int findTilt(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int[] result = new int[1];
        
        findTilt(root, map);
        
        findTilt(root, map, result);
        
        return result[0];
    }
    
    public void findTilt(TreeNode root, Map<TreeNode, Integer> map) {
        if (root != null) {
            findTilt(root.left, map);
            findTilt(root.right, map);
            int sum = 0;
            if (root.left != null) {
                sum += map.get(root.left);
            }
            
            if (root.right != null) {
                sum += map.get(root.right);
            }
            
            sum += root.val;
            
            map.put(root, sum);
        }
    }
    
    public void findTilt(TreeNode root, Map<TreeNode, Integer> map, int[] result) {
        if (root != null) {
            int left = 0;
            int right = 0;
            if (root.left != null) {
                left = map.get(root.left);
            }
            
            if (root.right != null) {
                right = map.get(root.right);
            }
            
            result[0] += Math.abs(left - right);
            
            findTilt(root.left, map, result);
            findTilt(root.right, map, result);
        }
    }
}
