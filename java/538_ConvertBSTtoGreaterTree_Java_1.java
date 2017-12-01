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
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inorderTraverse(root, list);
        
        Integer[] array = list.toArray(new Integer[list.size()]);
        
        if (array.length < 2) {
            return root;
        }
        else {
            Map<Integer, Integer> map = new HashMap<>();

            int cum = 0;
            
            for (int i = array.length - 1; i >= 0; --i) {
                map.put(array[i], cum);
                cum += array[i];
            }
            
            convertBST(root, map);
            
            return root;
        }
        
    }
    
    public void convertBST(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            root.val += map.get(root.val);
            convertBST(root.left, map);
            convertBST(root.right, map);
        }
    }
    
    public void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraverse(root.left, list);
            list.add(root.val);
            inorderTraverse(root.right, list);
        }
    }
}
