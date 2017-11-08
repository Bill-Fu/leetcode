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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        else {
            int mid = left + (right - left) / 2;
            TreeNode result = new TreeNode(nums[mid]);
            result.left = sortedArrayToBST(nums, left, mid);
            result.right = sortedArrayToBST(nums, mid + 1, right);
            return result;
        }
    }
    
}
