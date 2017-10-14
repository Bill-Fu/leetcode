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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeNode(preorder, inorder, 0, preorder.length, 0, inorder.length);
    
        return root;
    }
    
    private TreeNode buildTreeNode(int[] preorder, int[] inorder, int minPre, int maxPre, int minIn, int maxIn) {
        if (minPre >= maxPre) {
            return null;
        }
        else {
            TreeNode root = new TreeNode(preorder[minPre]);
            int split = 0;
            
            for (int i = minIn; i < maxIn; ++i) {
                if (inorder[i] == preorder[minPre]) {
                    split = i;
                    break;
                }
            }
            
            root.left = buildTreeNode(preorder, inorder, minPre + 1, minPre + 1 + split - minIn, minIn, split);
            root.right = buildTreeNode(preorder, inorder, minPre + 1 + split - minIn, maxPre, split + 1, maxIn);
            
            return root;
        }
    }
}
