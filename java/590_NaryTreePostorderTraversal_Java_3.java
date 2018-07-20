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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stackNode = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        
        if (root != null) {
            stackNode.push(root);
            
            while (stackNode.empty() == false) {
                Node tmp = stackNode.pop();
                
                if (tmp == null) {
                    res.add(stackInt.pop());
                }
                else {
                    stackInt.push(tmp.val);
                    stackNode.push(null);
                    for (int i = tmp.children.size() - 1; i >= 0; --i) {
                        stackNode.push(tmp.children.get(i));
                    }
                }
            }
        }
        
        return res;
    }
}
