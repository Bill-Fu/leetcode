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

        if (root != null) {
            Stack<Node> stack = new Stack<>();
            
            stack.push(root);
            
            while (stack.empty() == false) {
                Node tmp = stack.pop();
                
                res.add(tmp.val);
                
                for (int i = tmp.children.size() - 1; i >=0 ; --i) {
                    stack.push(tmp.children.get(i));
                }
            }
        }
        
        return res;
    }
}
