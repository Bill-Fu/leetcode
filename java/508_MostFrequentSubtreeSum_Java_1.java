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
    Map<Integer, Integer> map;
    int maxFre;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        maxFre = 0;
        int cnt = 0;
        
        traverse(root);
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maxFre) {
                cnt++;
            }
        }
        
        int[] result = new int[cnt];
        int pos = 0;
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maxFre) {
                result[pos++] = entry.getKey();
            }
        }
        
        return result;
    }
    
    public int traverse(TreeNode root) {
        if (root != null) {
            int result = traverse(root.left) + traverse(root.right) + root.val;
            
            if (map.containsKey(result)) {
                map.put(result, map.get(result) + 1);
            }
            else {
                map.put(result, 1);
            }
            
            maxFre = Math.max(maxFre, map.get(result));
            
            return result;
        }
        else {
            return 0;
        }
    }
}
