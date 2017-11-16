class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || k == 0) {
            return nums;
        }
        else {
            int[] result = new int[nums.length - k + 1];
            int[] table = new int[nums.length];
            
            Arrays.fill(table, Integer.MIN_VALUE);
            
            table[k - 1] = nums[k - 1];
            for (int i = k - 2; i >= 0; --i) {
                if (nums[i] > table[i + 1]) {
                    table[i] = nums[i];
                }
                else {
                    table[i] = table[i + 1];
                }
            }
            
            result[0] = table[0];
            for (int i = 1; i < nums.length - k + 1; ++i) {
                table[i + k - 1] = nums[i + k - 1];
                for (int j = i + k - 2; j >= i; --j) {
                    if (table[j] < table[j + 1]) {
                        table[j] = table[j + 1];
                    }
                    else {
                        break;
                    }
                }
                result[i] = table[i];
            }
            
            return result;
        }
    }
}
