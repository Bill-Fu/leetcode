class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] have = new int[prices.length];
        int[] dontHave = new int[prices.length];
        
        have[0] = -prices[0];
        dontHave[0] = 0;
        
        for (int i = 1; i < prices.length; ++i) {
            have[i] = Math.max(have[i - 1], dontHave[i - 1] - prices[i]);
            dontHave[i] = Math.max(dontHave[i - 1], have[i - 1] + prices[i] - fee);
        }
        
        return dontHave[prices.length - 1];
    }
}
