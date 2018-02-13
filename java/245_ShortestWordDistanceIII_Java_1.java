class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        
        if (word1.equals(word2)) {
            int pos = -words.length;
            
            for (int i = 0; i < words.length; ++i) {
                if (words[i].equals(word1)) {
                    result = Math.min(result, i - pos);
                    pos = i;
                }
            }
        }
        else {
            int pos1 = -words.length;
            int pos2 = -words.length;
            
            for (int i = 0; i < words.length; ++i) {
                if (words[i].equals(word1)) {
                    result = Math.min(result, i - pos2);
                    pos1 = i;
                }
                else if (words[i].equals(word2)) {
                    result = Math.min(result, i - pos1);
                    pos2 = i;
                }
            }
        }
        
        
        return result;
    }
}
