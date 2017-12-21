class NumArray {
    int[] table;
    
    public NumArray(int[] nums) {
        table = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; ++i) {
            table[i + 1] = table[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return table[j + 1] - table[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
