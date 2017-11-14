/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        String result = "";
        List<TreeNode> queue = new LinkedList<>();
        int num = 1;
        
        queue.add(root);
        
        while (queue.isEmpty() == false && num > 0) {
            TreeNode tmp = queue.get(0);
            queue.remove(0);
            
            if (tmp == null) {
                result += "N ";
            }
            else {
                num--;
                result += Integer.toString(tmp.val);
                result += " ";
                queue.add(tmp.left);
                if (tmp.left != null) {
                    num++;
                }
                queue.add(tmp.right);
                if (tmp.right != null) {
                    num++;
                }
            }
        }
        
        return result;
        
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        else {
            int prev = 0;
            List<TreeNode> queue = new LinkedList<>();
            TreeNode head = null;

            for (int i = 0; i < data.length(); ++i) {
                if (data.charAt(i) == ' ') {
                    if (data.substring(prev, i).equals("N")) {
                        queue.add(null);
                        head = null;
                    }
                    else {
                        TreeNode tmp = new TreeNode(Integer.parseInt(data.substring(prev, i)));
                        queue.add(tmp);
                        head = tmp;
                    }
                    prev = i + 1;
                    break;
                }
            }

            while (queue.isEmpty() == false) {
                TreeNode tmp = queue.get(0);
                queue.remove(0);
                TreeNode left = null, right = null;

                for (int i = prev; i < data.length(); ++i) {
                    if (data.charAt(i) == ' ') {
                        if (data.substring(prev, i).equals("N")) {
                            left = null;
                        }
                        else {
                            left = new TreeNode(Integer.parseInt(data.substring(prev, i)));
                            queue.add(left);
                        }
                        prev = i + 1;
                        break;
                    }
                }

                for (int i = prev; i < data.length(); ++i) {
                    if (data.charAt(i) == ' ') {
                        if (data.substring(prev, i).equals("N")) {
                            right = null;
                        }
                        else {
                            right = new TreeNode(Integer.parseInt(data.substring(prev, i)));
                            queue.add(right);
                        }
                        prev = i + 1;
                        break;
                    }
                }

                if (tmp != null) {
                    tmp.left = left;
                    tmp.right = right;                
                }

            }

            return head;
            
        }
    }
}
