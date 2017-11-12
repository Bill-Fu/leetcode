class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        
        for (int num : nums) {
            num_set.add(num);
        }
        
        int result = 0;
        
        for (int num : nums) {
            if (num_set.contains(num - 1) == false) {
                int curnum = num;
                int curlen = 1;
                
                while (num_set.contains(curnum + 1)) {
                    curlen++;
                    curnum++;
                }
                
                if (curlen > result) {
                    result = curlen;
                }
            }
        }
        
        return result;
    }
}
