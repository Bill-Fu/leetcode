class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = result.length - 1; i >= 0; --i) {
            while (stack.empty() == false) {
                if (temperatures[stack.peek()] > temperatures[i]) {
                    break;
                }
                else {
                    stack.pop();
                }
            }
            
            if (stack.empty()) {
                result[i] = 0;
            }
            else {
                result[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        
        return result;
    }
}
