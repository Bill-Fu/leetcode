class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        
        for (char c: J.toCharArray()) {
            set.add(c);
        }
        
        for (char c: S.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }
        
        return result;
    }
}
