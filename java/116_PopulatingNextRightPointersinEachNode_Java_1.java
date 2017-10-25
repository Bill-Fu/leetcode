/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        connect(root, root, 1);
    }
    
    private void connect(TreeLinkNode root, TreeLinkNode cur, int num) {
        if (cur != null) {
            if (Math.pow(2, (int) (Math.log((num + 1)) / Math.log(2))) == num + 1) {
                cur.next = null;
            }
            else {
                cur.next = findNext(root, num + 1);
            }
            connect(root, cur.left, num * 2);
            connect(root, cur.right, num * 2 + 1);
        }
    }
    
    private TreeLinkNode findNext(TreeLinkNode root, int num) {
        if (num > 1) {
            TreeLinkNode tmp = findNext(root, num / 2);
            if (num % 2 == 0) {
                return tmp.left;
            }
            else {
                return tmp.right;
            }
        }
        else {
            return root;
        }
    }
}
