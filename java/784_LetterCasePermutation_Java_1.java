class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        
        letterCasePermutation(S, 0, result);
        
        return result;
    }
    
    public void letterCasePermutation(String S, int pos, List<String> result) {
        if (pos < S.length()) {
            if ('0' <= S.charAt(pos) && S.charAt(pos) <= '9') {
                letterCasePermutation(S, pos + 1, result);
            }
            else {
                letterCasePermutation(S, pos + 1, result);
                
                if ('a' <= S.charAt(pos) && S.charAt(pos) <= 'z') {
                    letterCasePermutation(S.substring(0, pos) + (char)(S.charAt(pos) - 'a' + 'A') + S.substring(pos + 1, S.length()), pos + 1, result);
                }
                else {
                    letterCasePermutation(S.substring(0, pos) + (char)(S.charAt(pos) - 'A' + 'a') + S.substring(pos + 1, S.length()), pos + 1, result);
                }
            }
        }
        else {
            result.add(S);
        }
    }
}
