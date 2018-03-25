class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        
        if (word.length() == 0) {
            result.add(word);
        }
        else {
            boolean[] table = new boolean[word.length()];
            
            generateAbbreviations(word, table, result, 0);
        }
        
        return result;
    }
    
    public void generateAbbreviations(String word, boolean[] table, List<String> result, int idx) {
        if (idx == word.length()) {
            boolean sign = false;
            int cnt = 0;
            String res = "";
            
            for (int i = 0; i < table.length; ++i) {
                if (table[i] == true) {
                    if (sign == true) {
                        cnt++;
                    }
                    else {
                        sign = true;
                        cnt = 1;
                    }
                }
                else {
                    if (sign == true) {
                        res += Integer.toString(cnt);
                        sign = false;
                        cnt = 0;
                    }
                    
                    res += word.charAt(i);
                }
            }
            
            if (sign == true) {
                res += Integer.toString(cnt);
                sign = false;
                cnt = 0;
            }
            
            result.add(res);
        }
        else {
            table[idx] = false;
            
            generateAbbreviations(word, table, result, idx + 1);
            
            table[idx] = true;
            
            generateAbbreviations(word, table, result, idx + 1);            
            
        }
    }
}
