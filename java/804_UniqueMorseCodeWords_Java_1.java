class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        
        for (String word: words) {
            String tmp = "";
            
            for (char c: word.toCharArray()) {
                tmp += table[c - 'a'];
            }
            
            set.add(tmp);
        }
        
        return set.size();
    }
}
