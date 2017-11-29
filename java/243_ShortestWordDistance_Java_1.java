class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < words.length; ++i) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            }
            else {
                map.put(words[i], new ArrayList<Integer>());
                map.get(words[i]).add(i);
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        for (int i = 0; i < list1.size(); ++i) {
            for (int j = 0; j < list2.size(); ++j) {
                if (Math.abs(list1.get(i) - list2.get(j)) < result) {
                    result = Math.abs(list1.get(i) - list2.get(j));
                }
            }
        }
        
        return result;
    }
}
