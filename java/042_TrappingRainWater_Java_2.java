class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        else {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < leftMax.length; ++i) {
                if (height[i] > max) {
                    max = height[i];
                }
                leftMax[i] = max;
            }
            
            max = Integer.MIN_VALUE;
            for (int i = rightMax.length - 1; i >= 0; --i) {
                if (height[i] > max) {
                    max = height[i];
                }
                rightMax[i] = max;
            }
            
            
            int result = 0;
            for (int i = 1; i < height.length - 1; ++i) {
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            
            return result;
        }
    }
}
