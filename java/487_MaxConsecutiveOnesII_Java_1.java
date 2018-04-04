class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        
        int cnt1 = 0;
        int cnt2 = Integer.MIN_VALUE;
        
        boolean sign = false;
        
        for (int num: nums) {
            if (num == 0) {
                result = Math.max(result, cnt2);
                cnt2 = cnt1 + 1;
                cnt1 = 0;
            }
            else {
                cnt1++;
                cnt2++;
            }
        }
        
        result = Math.max(result, cnt2);
        result = Math.max(result, cnt1);
        
        return result;
    }
}
