class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        else {
            String result = strs[0];
            
            for (int i = 1; i < strs.length; ++i) {
                int j;
                for (j = 0; j < result.length() && j < strs[i].length(); ++j) {
                    if (result.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                
                result = result.substring(0, j);
            }
            
            return result;
        }
    }
}
