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
    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root != null) {
            pathSum(root, sum, 0);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, int cur) {
        if (root != null) {
            if (cur + root.val == sum) {
                result++;
            }
            pathSum(root.left, sum, cur + root.val);
            pathSum(root.right, sum, cur + root.val);
        }
    }
}
