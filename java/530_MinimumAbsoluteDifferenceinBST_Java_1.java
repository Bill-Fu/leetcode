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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inorder(root, list);
        
        Integer[] intArr = list.toArray(new Integer[list.size()]);
        
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < intArr.length - 1; ++i) {
            if (intArr[i + 1] - intArr[i] < result) {
                result = intArr[i + 1] - intArr[i];
            }
        }
        
        return result;
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
