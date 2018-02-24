class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int[] table = new int[31];
        
        for (int num: nums) {
            for (int i = 0; i < 31; ++i) {
                if (num % 2 == 1) {
                    table[i]++;
                }
                
                num /= 2;
            }
        }
        
        for (int i = 0; i < 31; ++i) {
            result += table[i] * (nums.length - table[i]);
        }
        
        return result;
    }
}
