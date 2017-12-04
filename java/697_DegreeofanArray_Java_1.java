class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
            else {
                int[] tmp = new int[3];
                tmp[0] = 1;
                tmp[1] = i;
                tmp[2] = i;
                map.put(nums[i], tmp);
            }
        }
        
        int time = 0;
        int result = Integer.MAX_VALUE;
        
        for (int num : map.keySet()) {
            int[] tmp = map.get(num);
            if (tmp[0] > time) {
                time = tmp[0];
                result = tmp[2] - tmp[1] + 1;
            }
            else if (tmp[0] == time) {
                result = Math.min(result, tmp[2] - tmp[1] + 1);
            }
        }
        
        return result;
    }
}
