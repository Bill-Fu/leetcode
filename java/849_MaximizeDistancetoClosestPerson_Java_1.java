class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;

        int prev = -1;
        
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    res = Math.max(res, i);
                }
                else {
                    res = Math.max(res, (i - prev) / 2);                    
                }

                prev = i;
            }
        }
        
        res = Math.max(res, seats.length - 1 - prev);
        
        return res;
    }
}
