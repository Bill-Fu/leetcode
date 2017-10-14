class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        subset(result, new ArrayList<Integer>(), nums, -1);
        
        return result;
    }
    
    private void subset(List<List<Integer>> res, List<Integer> cur, int[] table, int pos) {
        List<Integer> push = new ArrayList<>(cur);
        res.add(push);
        
        for (int i = pos + 1; i < table.length; ++i) {
            cur.add(table[i]);
            subset(res, cur, table, i);
            cur.remove(cur.size() - 1);
        }
    }
}
