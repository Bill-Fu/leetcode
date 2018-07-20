/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> res;
    
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        
        postorder_wrap(root);
        
        return res;
    }
    
    public void postorder_wrap(Node root) {
        if (root != null) {
            for (Node child: root.children) {
                postorder_wrap(child);
            }
            
            res.add(root.val);
        }
    }
}
