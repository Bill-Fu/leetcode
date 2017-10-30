class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        else {
            Stack<Integer> stack = new Stack<>();
            int x, y;
            
            for (int i = 0; i < tokens.length; ++i) {
                switch (tokens[i]) {
                    case "+":
                        y = stack.pop();
                        x = stack.pop();
                        stack.push(x + y);
                        break;
                    case "-":
                        y = stack.pop();
                        x = stack.pop();
                        stack.push(x - y);
                        break;
                    case "*":
                        y = stack.pop();
                        x = stack.pop();
                        stack.push(x * y);
                        break;
                    case "/":
                        y = stack.pop();
                        x = stack.pop();
                        stack.push(x / y);
                        break;
                    default:
                        stack.push(Integer.parseInt(tokens[i]));
                        break;
                }
            }
            
            return stack.pop();
        }
    }
}
