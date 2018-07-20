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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root != null) {
            levelOrder(res, 1, root);
        }
        
        return res;
    }
    
    public void levelOrder(List<List<Integer>> res, int level, Node root) {
        if (res.size() < level) {
            res.add(new ArrayList<Integer>());
        }
        
        res.get(level - 1).add(root.val);
        
        for (Node child: root.children) {
            levelOrder(res, level + 1, child);
        }
    }
}
