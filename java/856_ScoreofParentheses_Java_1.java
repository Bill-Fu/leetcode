class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c: S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            }
            else {
                int tmp = 0;
                
                while (stack.peek() != 0) {
                    tmp += stack.pop();
                }
                
                stack.pop();
                if (tmp == 0) {
                    stack.push(1);
                }
                else {
                    stack.push(2 * tmp);
                }
            }
        }
        
        int res = 0;
        
        while (stack.empty() == false) {
            res += stack.pop();
        }
        
        return res;
    }
}
