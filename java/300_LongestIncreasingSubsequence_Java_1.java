class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0, max;
        List<int[]> table = new ArrayList<>();
        int[] tmp;
        
        for (int i = 0; i < nums.length; ++i) {
            max = -1;
            for (int j = 0; j < table.size(); ++j) {
                if (nums[i] > table.get(j)[1]) {
                    if (table.get(j)[0] > max) {
                        max = table.get(j)[0];
                    }
                }
            }
            
            tmp = new int[2];
            if (max != -1) {
                tmp[0] = max + 1;
            }
            else {
                tmp[0] = 1;
            }
            tmp[1] = nums[i];
            table.add(tmp);
        }
        
        for (int i = 0; i < table.size(); ++i) {
            if (table.get(i)[0] > result) {
                result = table.get(i)[0];
            }
        }
        
        return result;
        
    }
}
