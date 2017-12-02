class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        Set<Integer> set = new HashSet<>();
        
        int pos1 = 0;
        int pos2 = 0;
        
        while (pos1 != nums1.length && pos2 != nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                set.add(nums1[pos1]);
                pos1++;
                pos2++;
            }
            else if (nums1[pos1] < nums2[pos2]) {
                pos1++;
            }
            else {
                pos2++;
            }
        }
        
        int[] result = new int[set.size()];
        int i = 0;
        
        for (int num : set) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}
