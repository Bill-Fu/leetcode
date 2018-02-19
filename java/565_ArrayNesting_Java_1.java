class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;
        boolean[] used = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            if (used[i] == false) {
                int cnt = 1;
                int cur = i;
                used[cur] = true;
                
                while (used[nums[cur]] == false) {
                    cnt++;
                    cur = nums[cur];
                    used[cur] = true;
                }
                
                result = Math.max(result, cnt);
            }
        }
        
        return result;
    }
}
