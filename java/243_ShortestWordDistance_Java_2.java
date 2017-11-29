class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int result = words.length;
        
        for (int i = 0; i < words.length; ++i) {
            if (word1.equals(words[i])) {
                pos1 = i;
                if (pos2 != -1 && pos1 - pos2 < result) {
                    result = pos1 - pos2;
                }
            }
            
            if (word2.equals(words[i])) {
                pos2 = i;
                if (pos1 != -1 && pos2 - pos1 < result) {
                    result = pos2 - pos1;
                }
            }
        }
        
        return result;
    }
}
