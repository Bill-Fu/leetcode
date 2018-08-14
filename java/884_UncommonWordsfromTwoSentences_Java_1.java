class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> res = new ArrayList<>();
        
        String[] wordsA = A.split("\\s+");
        String[] wordsB = B.split("\\s+");
        
        Map<String, Integer> wordsMapA = new HashMap<>();
        Map<String, Integer> wordsMapB = new HashMap<>();
        
        for (String word: wordsA) {
            if (wordsMapA.containsKey(word) == false) {
                wordsMapA.put(word, 0);
            }
            
            wordsMapA.put(word, wordsMapA.get(word) + 1);
        }
        
        for (String word: wordsB) {
            if (wordsMapB.containsKey(word) == false) {
                wordsMapB.put(word, 0);
            }
            
            wordsMapB.put(word, wordsMapB.get(word) + 1);
        }
        
        for (String word: wordsMapA.keySet()) {
            if (wordsMapA.get(word) == 1 && wordsMapB.containsKey(word) == false) {
                res.add(word);
            }
        }
        
        for (String word: wordsMapB.keySet()) {
            if (wordsMapB.get(word) == 1 && wordsMapA.containsKey(word) == false) {
                res.add(word);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
}
