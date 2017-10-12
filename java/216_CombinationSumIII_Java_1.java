class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        combination(k, n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void combination(int k, int n, List<Integer> cur, List<List<Integer>> res) {
        int i;
        if (k == 0 && n == 0) {
            // This is the most important part 
            res.add(new ArrayList<Integer>(cur));
        }
        else if (k > 0 && n > 0) {
            if (cur.size() == 0) {
                i = 1;
            }
            else {
                i = cur.get(cur.size() - 1) + 1;
            }
            for (; i < 10; ++i) {
                cur.add(i);
                combination(k - 1, n - i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
