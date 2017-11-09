class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp[k] = nums1[i];
                k++;
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        int[] result = new int[k];
        
        for (int n = 0; n < k; ++n) {
            result[n] = temp[n];
        }
        
        return result;
    }
}
