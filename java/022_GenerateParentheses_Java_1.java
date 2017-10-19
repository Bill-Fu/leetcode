class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        if (n <= 0) {
            return result;
        }
        
        String tmp = "";
        
        generateParenthesis(n, n, tmp, result);
        
        return result;
    }
    
    private void generateParenthesis(int cnt_left, int cnt_right, String tmp, List<String> result) {
        if (cnt_left == 0 && cnt_right == 0) {
            result.add(tmp);
        }
        else {
            if (cnt_left == cnt_right) {
                generateParenthesis(cnt_left - 1, cnt_right, tmp + "(", result);
            }
            else {
                if (cnt_left != 0) {
                    generateParenthesis(cnt_left - 1, cnt_right, tmp + "(", result);
                }
                
                generateParenthesis(cnt_left, cnt_right - 1, tmp + ")", result);
            }
        }
    }
}
