class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) == true) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        
        for (int i = 0; i < k; ++i) {
            int tmpKey = -1, tmpCount = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > tmpCount) {
                    tmpKey = entry.getKey();
                    tmpCount = entry.getValue();
                }
            }
            result.add(tmpKey);
            map.remove(tmpKey);
        }
        
        return result;
    }
}
