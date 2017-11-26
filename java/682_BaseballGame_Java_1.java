class Solution {
    public int calPoints(String[] ops) {
        int result = 0;
        int cur;
        Stack<Integer> valid = new Stack<>();
        
        for (int i = 0; i < ops.length; ++i) {
            switch(ops[i]) {
                case "C":
                    result -= valid.pop();
                    break;
                case "D":
                    cur = 2 * valid.peek();
                    result += cur;
                    valid.push(cur);
                    break;
                case "+":
                    int val1, val2;
                    val2 = valid.pop();
                    val1 = valid.pop();
                    cur = val1 + val2;
                    result += cur;
                    valid.push(val1);
                    valid.push(val2);
                    valid.push(cur);
                    break;
                default:
                    cur = Integer.parseInt(ops[i]);
                    result += cur;
                    valid.push(cur);
                    break;
            }
        }
        
        return result;
    }
}
