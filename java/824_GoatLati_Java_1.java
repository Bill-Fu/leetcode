class Solution {
    public String toGoatLatin(String S) {
        StringBuilder SB = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        
        String[] words = S.split("\\s+");
        for (int i = 0; i < words.length; ++i) {
            if (vowels.contains(words[i].charAt(0))) {
                SB.append(words[i]);
            }
            else {
                SB.append(words[i].substring(1, words[i].length()));
                SB.append(words[i].substring(0, 1));
            }
            
            SB.append("ma");
            
            for (int j = 0; j < i + 1; ++j) {
                SB.append("a");
            }
            
            if (i != words.length - 1) {
                SB.append(" ");
            }
        }
        
        return new String(SB);
    }
}
