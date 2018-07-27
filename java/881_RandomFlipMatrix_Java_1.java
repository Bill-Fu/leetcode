class Solution {
    Set<Integer> used;
    int n_rows;
    int n_cols;
    public Solution(int n_rows, int n_cols) {
        this.used = new HashSet<>();
        this.n_rows = n_rows;
        this.n_cols = n_cols;
    }
    
    public int[] flip() {
        int pos = (int)(Math.random() * (n_rows * n_cols));
        
        while (used.contains(pos)) {
            pos = (int)(Math.random() * (n_rows * n_cols));
        }
        
        used.add(pos);
        return new int[]{pos / n_cols, pos % n_cols};
    }
    
    public void reset() {
        used.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
