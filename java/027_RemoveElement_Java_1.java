class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        
        while (ptr1 < ptr2) {
            if (nums[ptr1] == val) {
                if (nums[ptr2] != val) {
                    nums[ptr1] = nums[ptr2];
                    nums[ptr2] = val;
                    ptr1++;
                    ptr2--;
                }
                else {
                    ptr2--;
                }
            }
            else {
                ptr1++;
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                return i;
            }
        }
        
        return nums.length;
    }
}
