class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        else {
            int result = 0;
            int min = prices[0];
            
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                else {
                    if (prices[i] - min > result) {
                        result = prices[i] - min;
                    }
                }
            }
            
            return result;
        }
    }
}
