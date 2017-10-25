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
    public boolean isValidBST(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        
        boolean tmp = isValidBST(root, array);
        
        return tmp;
    }
    
    public boolean isValidBST(TreeNode root, List<Integer> array) {
        if (root != null) {
            boolean tmp = isValidBST(root.left, array);
            
            if (tmp == false) {
                return false;
            }
            
            if (array.size() == 0 || root.val > array.get(array.size() - 1)) {
                array.add(root.val);
            }
            else {
                return false;
            }
            
            tmp = isValidBST(root.right, array);
            
            return tmp;
        }
        else {
            return true;
        }
    }
}
