class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();
        
        if (trimmed.equals("")) {
            return 0;
        }
        else {
            return trimmed.split("\\s+").length;
        }
    }
}
