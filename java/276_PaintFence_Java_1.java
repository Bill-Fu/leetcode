class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return k;
        }
        else {
            int same = k;
            int diff = k * (k - 1);
            
            for (int i = 2; i < n; ++i) {
                int presame = same;
                int prediff = diff;
                same = prediff;
                diff = presame * (k - 1) + prediff * (k - 1);
            }
            
            return same + diff;
        }
    }
}
