class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else {
            int ptr1, ptr2;
            
            for (ptr1 = 0, ptr2 = 1; ptr2 < nums.length; ++ptr2) {
                if (nums[ptr2] != nums[ptr1]) {
                    nums[ptr1 + 1] = nums[ptr2];
                    ptr1++;
                }
            }
            
            return ptr1 + 1;
        }
    }
}
