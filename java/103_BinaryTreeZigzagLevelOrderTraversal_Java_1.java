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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> levelQueue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        else {
            nodeQueue.add(root);
            levelQueue.add(0);
            while (nodeQueue.peek() != null) {
                TreeNode tmpNode = nodeQueue.poll();
                int tmpLevel = levelQueue.poll();
                
                if (result.size() <= tmpLevel) {
                    result.add(new ArrayList<Integer>());
                }
                
                result.get(tmpLevel).add(tmpNode.val);
                
                if (tmpNode.left != null) {
                    nodeQueue.add(tmpNode.left);
                    levelQueue.add(tmpLevel + 1);
                }
                if (tmpNode.right != null) {
                    nodeQueue.add(tmpNode.right);
                    levelQueue.add(tmpLevel + 1);
                }
            }
            
            for (int i = 1; i < result.size(); i = i + 2) {
                Collections.reverse(result.get(i));
            }
            
            return result;
        }
    }
}
