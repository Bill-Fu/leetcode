class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        int ptr1 = 0;
        int ptr2 = nums.length - 1;
        
        Arrays.sort(sorted);
        
        while (ptr1 < nums.length && nums[ptr1] == sorted[ptr1]) {
            ptr1++;
        }
        
        while (ptr2 > -1 && nums[ptr2] == sorted[ptr2]) {
            ptr2--;
        }
        
        return ptr1 < ptr2? ptr2 - ptr1 + 1: 0;
    }
}
