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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            Map<TreeNode, Integer> map = new HashMap<>();
            int result = Integer.MIN_VALUE;
            Queue<TreeNode> queue = new ArrayDeque<>();
            
            maxPathSum(root, map);
            queue.add(root);
            
            while (queue.peek() != null) {
                TreeNode tmp = queue.poll();
                int cur = tmp.val;
                
                if (tmp.left != null) {
                    cur += Math.max(0, map.get(tmp.left));
                    queue.add(tmp.left);
                }
                
                if (tmp.right != null) {
                    cur += Math.max(0, map.get(tmp.right));
                    queue.add(tmp.right);
                }
                
                if (cur > result) {
                    result = cur;
                }
            }
            
            return result;
        }
    }
    
    private int maxPathSum(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        else {
            int max = root.val + Math.max(0, Math.max(maxPathSum(root.left, map), maxPathSum(root.right, map)));
            map.put(root, max);
            return max;
        }
    }
}
