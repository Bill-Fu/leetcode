class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        
        paragraph = paragraph.replaceAll("\\W+", " ");
        
        for (String ban: banned) {
            paragraph = paragraph.replaceAll(ban, " ");
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: paragraph.split("\\s+")) {
            if (word.equals("") == false) {
                if (map.containsKey(word) == false) {
                    map.put(word, 0);
                }

                map.put(word, map.get(word) + 1);                
            }
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        
        Collections.sort(words, (String word1, String word2) -> (map.get(word2).compareTo(map.get(word1))));
        
        return words.get(0);
    }
}
