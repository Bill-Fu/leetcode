// Assuming ASCII 128
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[128];
        int result = 0, tmp = 0;
        
        Arrays.fill(table, -1);
        
        for (int i = 0; i < s.length(); ++i) {
            if (i - table[(int) s.charAt(i)] <= tmp) {
                if (tmp > result) {
                    result = tmp;
                }
                tmp = i - table[(int) s.charAt(i)];
            }
            else {
                tmp++;
            }
            table[(int) s.charAt(i)] = i;
        }
        
        if (tmp > result) {
            result = tmp;
        }
        
        return result;
    }
}
