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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        
        preorder(root, res);
        
        return res;
    }
    
    public void preorder(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            
            for (Node child: root.children) {
                preorder(child, res);
            }
        }
    }
}
