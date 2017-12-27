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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left < right) {
            int idx = findMaxIndex(nums, left, right);
            TreeNode node = new TreeNode(nums[idx]);
            node.left = constructMaximumBinaryTree(nums, left, idx);
            node.right = constructMaximumBinaryTree(nums, idx + 1, right);
            return node;
        }
        else {
            return null;
        }
    }
    
    public int findMaxIndex(int[] nums, int left, int right) {
        int result = left;
        
        for (int i = left + 1; i < right; ++i) {
            if (nums[i] > nums[result]) {
                result = i;
            }
        }
        
        return result;
    }
}
