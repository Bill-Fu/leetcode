class Solution {
    public String boldWords(String[] words, String S) {
        boolean[] bolded = new boolean[S.length()];
        
        for (String str: words) {
            for (int i = 0; i <= S.length() - str.length(); ++i) {
                if (str.equals(S.substring(i, i + str.length()))) {
                    for (int j = i; j < i + str.length(); ++j) {
                        bolded[j] = true;
                    }
                }
            }
        }
        
        String result = "";
        
        for (int i = 0; i < S.length(); ++i) {
            if (bolded[i] == true && (i == 0 || bolded[i - 1] == false)) {
                result += "<b>";
            }
            
            result += S.charAt(i);
            
            if (bolded[i] == true && (i == S.length() - 1 || bolded[i + 1] == false)) {
                result += "</b>";
            }
        }
        
        return result;
    }
}
