class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> tmp;
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> table;
        
        for (int i = 0; i < strs.length; ++i) {
            table = new ArrayList<>();
            
            for (int j = 0; j < 26; ++j) {
                table.add(0);
            }
            
            for (int j = 0; j < strs[i].length(); ++j) {
                table.set(strs[i].charAt(j) - 'a', table.get(strs[i].charAt(j) - 'a') + 1);
            }
            if (map.containsKey(table) == false) {
                tmp = new ArrayList<>();
                tmp.add(strs[i]);
                result.add(tmp);
                map.put(table, result.size() - 1);
            }
            else {
                result.get(map.get(table)).add(strs[i]);
            }
        }
        
        return result;
    }
}
