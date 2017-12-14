class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        
        result.add(1);
        
        for (int i = 0; i < rowIndex; ++i) {
            tmp.clear();
            tmp.add(1);
            for (int j = 1; j < result.size(); ++j) {
                tmp.add(result.get(j - 1) + result.get(j));
            }
            tmp.add(1);
            result = new ArrayList<>(tmp);
        }
        
        return result;
    }
}
