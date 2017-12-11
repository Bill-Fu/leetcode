class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        else {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            
            if (nums[left] > target) {
                return left;
            }
            else if (nums[right] < target) {
                return right + 1;
            }
            else {
                while (left <= right) {
                    mid = (left + right) / 2;

                    if (nums[mid] == target) {
                        return mid;
                    }
                    else if (nums[mid] < target) {
                        left = mid + 1;
                        if (nums[left] > target) {
                            return left;
                        }
                    }
                    else {
                        right = mid - 1;
                        if (nums[right] < target) {
                            return right + 1;
                        }
                    }
                }
                
                return -1;
            }

        }
    }
}
