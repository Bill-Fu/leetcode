class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = S.toCharArray();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < charArr.length; ++i) {
            map.put(charArr[i], i);
        }
        
        int prev = -1;
        int cur = 0;
        
        for (int i = 0; i < charArr.length; ++i) {
            cur = Math.max(cur, map.get(charArr[i]));
            
            if (i == cur) {
                result.add(cur - prev);
                prev = cur;
            }
        }
        
        return result;
    }
}
