class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        
        if (nums.length != 0) {
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIdx = i;
                }
            }

            Stack<Integer> stack = new Stack<>();
            result[maxIdx] = -1;
            stack.push(max);

            for (int i = nums.length - 1; i > 0; --i) {
                while (stack.empty() == false && stack.peek() <= nums[(i + maxIdx) % nums.length]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    stack.push(nums[(i + maxIdx) % nums.length]);
                    result[(i + maxIdx) % nums.length] = -1;
                }
                else {
                    result[(i + maxIdx) % nums.length] = stack.peek();
                    stack.push(nums[(i + maxIdx) % nums.length]);
                }
            }        
        }
        
        return result;
    }
}
