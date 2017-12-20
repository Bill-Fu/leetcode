class Solution {
    public int lengthOfLastWord(String s) {
        String[] result = s.trim().split("\\s++");
        
        return result.length == 0? 0: result[result.length - 1].length();
    }
}
