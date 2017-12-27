class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        
        for (int i = 1; i < result.length; ++i) {
            result[i] = result[i - (int) (Math.pow(2, (int) (Math.log10(i) / Math.log10(2))))] + 1;
        }

        return result;
    }
}
