// Find the possible left border and right border and calculate by brute force.
class Solution {
    public int maxArea(int[] height) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int result = 0;
        
        left.add(0);
        right.add(height.length - 1);
        
        for (int i = 1; i < height.length; ++i) {
            if (height[i] > height[left.get(left.size() - 1)]) {
                left.add(i);
            }
            if (height[height.length - 1 - i] > height[right.get(right.size() - 1)]) {
                right.add(height.length - 1 -i);
            }
        }
        
        for (int i = 0; i < left.size(); ++i) {
            for (int j = 0; j < right.size(); ++j) {
                if (left.get(i) < right.get(j)) {
                    if (Math.min(height[left.get(i)], height[right.get(j)]) * (right.get(j) - left.get(i)) > result) {
                        result = Math.min(height[left.get(i)], height[right.get(j)]) * (right.get(j) - left.get(i));
                    }
                }
                else {
                    continue;
                }
            }
        }
        
        return result;
    }
}
