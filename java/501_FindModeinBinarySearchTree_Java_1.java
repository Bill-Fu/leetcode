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
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        inOrder(root, list);
        
        if (list.size() == 0) {
            return new int[0];
        }
        else {
            int count = 1;
            int cur = list.get(0);
            int maxfre = 0;
                    
            for (int i = 1; i < list.size(); ++i) {
                if (list.get(i) == cur) {
                    count++;
                }
                else {
                    if (count > maxfre) {
                        result.clear();
                        result.add(cur);
                        maxfre = count;
                    }
                    else if (count == maxfre) {
                        result.add(cur);
                    }
                    
                    cur = list.get(i);
                    count = 1;
                }
            }

            if (count > maxfre) {
                result.clear();
                result.add(cur);
                maxfre = count;
            }
            else if (count == maxfre) {
                result.add(cur);
            }            
            
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        

    }
    
    public void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
