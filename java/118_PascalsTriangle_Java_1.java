class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows != 0) {
            result.add(new ArrayList<Integer>());
            result.get(0).add(1);
            
            for (int i = 1; i < numRows; i++) {
                result.add(new ArrayList<Integer>());
                result.get(result.size() - 1).add(1);
                for (int j = 0; j < i - 1; ++j) {
                    result.get(result.size() - 1).add(result.get(result.size() - 2).get(j) + result.get(result.size() - 2).get(j + 1));
                }
                result.get(result.size() - 1).add(1);
            }
        }
        
        return result;
    }
}
