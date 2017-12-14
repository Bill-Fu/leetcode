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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        
        inOrder(root, map);
        
        List<Integer> result = new ArrayList<>();
        int maxfre = 0;
        
        for (int key: map.keySet()) {
            if (map.get(key) > maxfre) {
                result.clear();
                result.add(key);
                maxfre = map.get(key);
            }
            else if (map.get(key) == maxfre) {
                result.add(key);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void inOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            inOrder(root.left, map);
            if (map.containsKey(root.val)) {
                map.put(root.val, map.get(root.val) + 1);
            }
            else {
                map.put(root.val, 1);
            }
            inOrder(root.right, map);
        }
    }
}
