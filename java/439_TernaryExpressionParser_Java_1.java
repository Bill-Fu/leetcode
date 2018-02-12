class Solution {
    public String parseTernary(String expression) {
        String[] items = expression.split("\\?|:");
        String[] ops = expression.split("\\d+|T|F");
        
        Stack<String> stack = new Stack<>();
        
        stack.push(items[items.length - 1]);
        
        int pos = items.length - 1;
        
        while (pos > 0) {
            if (ops[pos].equals(":")) {
                stack.push(items[pos - 1]);
            }
            else {
                String exp1 = stack.pop();
                String exp2 = stack.pop();
                if (items[pos - 1].equals("T")) {
                    stack.push(exp1);
                }
                else {
                    stack.push(exp2);
                }
            }
            pos--;
        }
        
        return stack.pop();
    }
}
