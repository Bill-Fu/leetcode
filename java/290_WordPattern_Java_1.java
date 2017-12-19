class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> revmap = new HashMap<>();
        
        String[] strArr = str.split("\\s+");
        char[] charArr = pattern.toCharArray();
        
        if (strArr.length != charArr.length) {
            return false;
        }
        else {
            for (int i = 0; i < charArr.length; ++i) {
                if (map.containsKey(charArr[i])) {
                    if (strArr[i].equals(map.get(charArr[i])) == false) {
                        return false;
                    }
                }
                else if (revmap.containsKey(strArr[i]) == true){
                    return false;
                }
                else {
                    map.put(charArr[i], strArr[i]);
                    revmap.put(strArr[i], charArr[i]);
                }
            }
            
            return true;
        }
    }
}
