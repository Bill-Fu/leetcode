class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        else {
            int[] tmp = new int[nums.length];
            
            if (k >= 0) {
                if (k % nums.length != 0) {
                    for (int i = 0; i < nums.length; ++i) {
                        tmp[(i + (k % nums.length)) % nums.length] = nums[i];
                    }
                    
                    for (int i = 0; i < nums.length; ++i) {
                        nums[i] = tmp[i];
                    }
                }
            }
            else {
                long K = -k;
                
                if (K % nums.length != 0) {
                    for (int i = 0; i < nums.length; ++i) {
                        tmp[((i - (int)(K % nums.length)) + nums.length) % nums.length] = nums[i];
                    }
                    
                    for (int i = 0; i < nums.length; ++i) {
                        nums[i] = tmp[i];
                    }
                }
            }
        }
    }
}
