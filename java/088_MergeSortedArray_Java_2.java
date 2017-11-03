ass Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1;
        
        for (int k = m + n - 1; k >= 0; --k) {
            if (ptr1 < 0) {
                nums1[k] = nums2[ptr2];
                ptr2--;
            }
            else if (ptr2 < 0) {
                nums1[k] = nums1[ptr1];
                ptr1--;
            }
            else if (nums1[ptr1] > nums2[ptr2]) {
                nums1[k] = nums1[ptr1];
                ptr1--;
            }
            else {
                nums1[k] = nums2[ptr2];
                ptr2--;
            }
        }
    }
}
