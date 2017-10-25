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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        
        inOrderTraverse(root, list, k);
        
        return list.get( k - 1);
    }
    
    private void inOrderTraverse(TreeNode root, List<Integer> list, int k) {
        if (list.size() < k) {
            if (root != null) {
                inOrderTraverse(root.left, list, k);
                list.add(root.val);
                inOrderTraverse(root.right, list, k);
            }
        }
    }
}
