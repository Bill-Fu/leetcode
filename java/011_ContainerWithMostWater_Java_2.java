// Two Pointers
class Solution {
    public int maxArea(int[] height) {
        int left, right, max;
        
        left = 0;
        right = height.length - 1;
        max = (Math.min(height[left], height[right]) * (height.length - 1));
        
        while (left != right) {
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
            if ((Math.min(height[left], height[right]) * (right - left)) > max) {
                max = Math.min(height[left], height[right]) * (right - left);
            }
        }
        
        return max;
    }
}
