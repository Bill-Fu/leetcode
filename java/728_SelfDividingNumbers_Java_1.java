class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = left; i <= right; ++i) {
            int tmp = i;
            
            int j;
            for (j = 0; j <= (int) Math.log10(i); ++j) {
                if (tmp % 10 == 0 || i % (tmp % 10) != 0) {
                    break;
                }
                tmp /= 10;
            }
            
            if (j == (int) Math.log10(i) + 1) {
                result.add(i);
            }
        }
        
        return result;
    }
}
