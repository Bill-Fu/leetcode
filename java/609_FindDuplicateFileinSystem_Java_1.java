class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str: paths) {
            String[] split = str.split("\\s+");
            
            for (int i = 1; i < split.length; ++i) {
                if (map.containsKey(split[i].split("\\(")[1]) == false) {
                    map.put(split[i].split("\\(")[1], new ArrayList<String>());
                }
                map.get(split[i].split("\\(")[1]).add(split[0] + "/" + split[i].split("\\(")[0]);
            }
        }
        
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());                
            }
        }
        
        return result;
    }
}
