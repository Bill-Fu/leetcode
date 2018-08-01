class Solution {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        int[][] table = new int[piles.length][piles.length];
        
        for (int pile: piles) {
            sum += pile;
        }
        
        for (int i = 0; i < table.length; ++i) {
            Arrays.fill(table[i], -1);
        }
        
        return stoneGame(piles, table, 0, piles.length - 1) * 2 > sum;
    }
    
    public int stoneGame(int[] piles, int[][] table, int left, int right) {
        if (right - left == 1) {
            if (table[left][right] == -1) {
                table[left][right] = Math.max(piles[left], piles[right]);
            }
        }
        else {
            if (table[left][right] == -1) {
                table[left][right] = Math.max(piles[left] + Math.min(stoneGame(piles, table, left + 1, right - 1), stoneGame(piles, table, left + 2, right)), piles[right] + Math.min(stoneGame(piles, table, left + 1, right - 1), stoneGame(piles, table, left, right - 2)));
            }
        }
        
        return table[left][right];
    }
}
