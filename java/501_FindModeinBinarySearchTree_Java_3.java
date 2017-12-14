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
    int count;
    int maxfre;
    int cur;
    List<Integer> list;
    
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        else {
            TreeNode tmp = root;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            cur = tmp.val;
            count = 0;
            maxfre = 0;
            list = new ArrayList<>();
            
            inOrder(root);
            
            if (count > maxfre) {
                list.clear();
                list.add(cur);
                maxfre = count;
            }
            else if (count == maxfre) {
                list.add(cur);
            }
            
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        
    }
    
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (root.val == cur) {
                count++;
            }
            else {
                if (count > maxfre) {
                    list.clear();
                    list.add(cur);
                    maxfre = count;
                }
                else if (count == maxfre) {
                    list.add(cur);
                }
                
                cur = root.val;
                count = 1;
            }
            inOrder(root.right);
        }
    }
}
