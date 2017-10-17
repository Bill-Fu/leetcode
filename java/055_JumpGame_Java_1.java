class Solution {
    public boolean canJump(int[] nums) {
        boolean[] table = new boolean[nums.length];
        
        table[0] = true;
        
        for (int i = 0; i < table.length; ++i) {
            if (table[i] == true) {
                for (int j = nums[i]; j >= 1; --j) {
                    if (i + j < nums.length){
                        if (table[i + j] == false){
                            table[i + j] = true;   
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        return true;
                    }
                }
            }
        }
        
        return table[table.length - 1];
    }
}
