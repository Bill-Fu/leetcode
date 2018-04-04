class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        
        Map<String, Integer> word2bits = new HashMap<>();
        
        for (String word: words) {
            int tmp = 0;
            
            for (char c: word.toCharArray()) {
                tmp |= (int)(Math.pow(2, c - 'a'));
            }
            
            word2bits.put(word, tmp);
        }
        
        for (String word1: words) {
            for (String word2: words) {
                if ((word2bits.get(word1) & word2bits.get(word2)) == 0) {
                    result = Math.max(result, word1.length() * word2.length());
                }
            }
        }
        
        return result;
    }
}
