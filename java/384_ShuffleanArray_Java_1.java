class Solution {
    int[] origin;
    
    public Solution(int[] nums) {
        origin = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[origin.length];
        List<Integer> rand = new ArrayList<>();
        
        for (int i = 0; i < result.length; ++i) {
            rand.add(i);
        }
        
        for (int i = 0; i < result.length; ++i) {
            int idx = (int) (Math.random() * rand.size());
            
            result[i] = origin[rand.get(idx)];
            
            rand.remove(idx);
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
