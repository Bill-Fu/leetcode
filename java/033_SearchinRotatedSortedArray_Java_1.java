class Solution {
    public int search(int[] nums, int target) {
        int min, max, mid, pivot = 0, result;
        min = 0;
        max = nums.length - 1;
        
        while (min <= max) {
            mid = (min + max) / 2;
            if (mid == 0) {
                min = mid + 1;
            }
            else if (nums[mid - 1] >= nums[0] && nums[mid] <= nums[nums.length - 1]) {
                pivot = mid;
                break;
            }
            else if (nums[mid - 1] < nums[0]) {
                max = mid - 1;
            }
            else if (nums[mid] > nums[nums.length - 1]) {
                min = mid + 1;
            }
        }
        
        if (pivot == 0) {
            result = Arrays.binarySearch(nums, target);
            if (result < 0) {
                return -1;
            }
            else {
                return result;
            }
        }
        else {
            result = Arrays.binarySearch(nums, 0, pivot, target);
            if (result < 0) {
                result = Arrays.binarySearch(nums, pivot, nums.length, target);
                if (result < 0) {
                    return -1;
                }
                else {
                    return result;
                }
            }
            else {
                return result;
            }
        }
    }
}
