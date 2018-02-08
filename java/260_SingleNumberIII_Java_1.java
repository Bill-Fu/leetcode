class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int tmp = 0;
        
        for (int num: nums) {
            tmp ^= num;
        }
        
        tmp &= -tmp;
        
        for (int num: nums) {
            if ((num & tmp) == 0) {
                result[0] ^= num;
            }
            else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}
