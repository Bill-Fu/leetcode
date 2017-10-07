class Solution {
    public int[] constructArray(int n, int k) {
        int result[] = new int[n];
        int i, min, max;
        
        result[0] = 1;
        min = 2;
        max = n;
        
        for (i = 1; i < k; ++i) {
            if (i%2 == 1) {
                result[i] = max;
                max--;
            }
            else {
                result[i] = min;
                min++;
            }
        }
        
        if (i%2 == 1) {
            for (; i < n; ++i) {
                result[i] = min;
                min++;
            }
        }
        else {
            for (; i < n; ++i) {
                result[i] = max;
                max--;
            }
        }
        
        return result;
    }
}
