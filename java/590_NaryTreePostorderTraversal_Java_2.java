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
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack();
        List<Integer> res = new ArrayList<>();
        
        if (root != null) {
            stack.push(root);
            
            while (stack.empty() == false) {
                Node tmp = stack.pop();
                
                if (set.contains(tmp)) {
                    res.add(tmp.val);
                }
                else {
                    set.add(tmp);
                    stack.push(tmp);
                    for (int i = tmp.children.size() - 1; i >= 0; --i) {
                        stack.push(tmp.children.get(i));
                    }
                }
                

            }
        }
        
        return res;
    }
}
