class Solution {
    public int[] findPermutation(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[s.length() + 1];
        int cur = 0;
        
        stack.push(1);
        
        for (int i = 2; i <= s.length() + 1; ++i) {
            if (s.charAt(i - 2) == 'D') {
                stack.push(i);
            }
            else {
                while (stack.empty() == false) {
                    result[cur++] = stack.pop();
                }
                
                stack.push(i);
            }
        }
        
        while (stack.empty() == false) {
            result[cur++] = stack.pop();
        }
        
        return result;
    }
}
