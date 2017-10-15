class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        int pos, start, end;
        
        pos = Arrays.binarySearch(nums, target);
        
        if (pos < 0) {
            result[0] = -1;
            result[1] = -1;
        }
        else {
            start = end = pos;
            while (start > 0 && nums[start - 1] == target) {
                start--;
            }
            
            while (end < nums.length -1 && nums[end + 1] == target) {
                end++;
            }
            
            result[0] = start;
            result[1] = end;
        }
        
        return result;
    }
}
