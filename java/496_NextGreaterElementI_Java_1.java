class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        
        Arrays.fill(result, -1);
        
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], i);
        }
        
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; ++j) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        
        return result;
    }
}
