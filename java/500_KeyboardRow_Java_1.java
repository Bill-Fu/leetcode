class Solution {
    public String[] findWords(String[] words) {
        char[] line1 = {'q', 'Q', 'w', 'W', 'e', 'E', 'r', 'R', 't', 'T', 'y', 'Y', 'u', 'U', 'i', 'I', 'o', 'O', 'p', 'P'};
        char[] line2 = {'a', 'A', 's', 'S', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L'};
        char[] line3 = {'z', 'Z', 'x', 'X', 'c', 'C', 'v', 'V', 'b', 'B', 'n', 'N', 'm', 'M'};
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < line1.length; ++i) {
            map.put(line1[i], 1);
        }
        
        for (int i = 0; i < line2.length; ++i) {
            map.put(line2[i], 2);
        }
        
        for (int i = 0; i < line3.length; ++i) {
            map.put(line3[i], 3);
        }
        
        for (int i = 0; i < words.length; ++i) {
            if (words.length != 0) {
                int tmp = map.get(words[i].charAt(0));
                int j;
                for (j = 0; j < words[i].length(); ++j) {
                    if (map.get(words[i].charAt(j)) != tmp) {
                        break;
                    }
                }
                if (j == words[i].length()) {
                    result.add(words[i]);
                }
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}
