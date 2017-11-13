class Solution {
    public int trap(int[] height) {
        int result = 0;
        
        for (int i = 1; i < height.length - 1; ++i) {
            int leftMax = 0, rightMax = 0;
            
            for (int j = i; j < height.length; ++j) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }
            
            for (int j = i; j >= 0; --j) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            
            result += Math.min(leftMax, rightMax) - height[i];
        }
        
        return result;
    }
}
