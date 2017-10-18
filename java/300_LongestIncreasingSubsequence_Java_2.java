ass Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else {
            int[] table = new int[nums.length];
            int tmp, result = 0;
            
            table[0] = 1;
            
            for (int i = 1; i < nums.length; ++i) {
                tmp = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        if (table[j] + 1 > tmp) {
                            tmp = table[j] + 1;
                        }
                    }
                }
                table[i] = tmp;
            }
        
            for (int i = 0; i < table.length; ++i) {
                if (table[i] > result) {
                    result = table[i];
                }
            }
            
            return result;
        }
    }
}
