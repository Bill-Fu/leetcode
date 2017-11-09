class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> first = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int[] resultArray;
        
        for (int i = 0; i < nums1.length; ++i) {
            if (first.containsKey(nums1[i]) == true) {
                first.put(nums1[i], first.get(nums1[i]) + 1);
            }
            else {
                first.put(nums1[i], 1);
            }
        }
        
        for (int i = 0; i < nums2.length; ++i) {
            if (first.containsKey(nums2[i]) && first.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                first.put(nums2[i], first.get(nums2[i]) - 1);
            }
        }
        
        resultArray = new int[result.size()];
        
        for (int i = 0; i < result.size(); ++i) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}
