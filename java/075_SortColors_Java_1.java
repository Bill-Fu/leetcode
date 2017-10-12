// Two pass
class Solution {
    public void sortColors(int[] nums) {
        int table[] = new int[3];
        int i, j;
        
        table[0] = table[1] = table[2] = 0;
        
        for (i = 0; i < nums.length; ++i) {
            table[nums[i]]++;
        }
        
        
        for (i = 0, j = 0; i < nums.length; ++i) {
            while (table[j] <= 0) {
                j++;
            }
            nums[i] = j;
            table[j]--;
        }
    }
}
