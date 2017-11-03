class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int ptr1 = 0;
        int ptr2 = 0;
        
        for (int i = 0; i < result.length; ++i) {
            if (ptr1 == m) {
                result[i] = nums2[ptr2];
                ptr2++;
            }
            else if (ptr2 == n) {
                result[i] = nums1[ptr1];
                ptr1++;
            }
            else if (nums1[ptr1] < nums2[ptr2]) {
                result[i] = nums1[ptr1];
                ptr1++;
            }
            else {
                result[i] = nums2[ptr2];
                ptr2++;
            }
        }
        
        for (int i = 0; i < result.length; ++i) {
            nums1[i] = result[i];
        }
    }
}
