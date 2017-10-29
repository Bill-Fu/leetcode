class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        if (s.length() != 0) {
            partition(s, res, new ArrayList<String>());        
        }
        
        return res;
    }
    
    private void partition(String s, List<List<String>> res, List<String> cur) {
        if (s.length() != 0) {
            for (int i = 0; i < s.length(); ++i) {
                if (isPalindrome(s.substring(0, i + 1))) {
                    List<String> tmp = new ArrayList<>(cur);
                    tmp.add(s.substring(0, i + 1));
                    partition(s.substring(i + 1, s.length()), res, tmp);
                }
            }
        }
        else {
            res.add(cur);
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        else {
            for (int i = 0; i < s.length() / 2; ++i) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            
            return true;
        }
    }
}
