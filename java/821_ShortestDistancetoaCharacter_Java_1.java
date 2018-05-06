class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        
        List<Integer> list = new ArrayList<>();
        
        char[] charS = S.toCharArray();
        
        for (int i = 0; i < charS.length; ++i) {
            if (charS[i] == C) {
                list.add(i);
            }
        }
        int cnt = 0;
        while (list.size() != 0) {
            List<Integer> tmp = new ArrayList<>();
            
            for (int pos: list) {
                if (pos >= 0 && pos < charS.length && result[pos] == Integer.MAX_VALUE) {
                    result[pos] = cnt;
                    tmp.add(pos - 1);
                    tmp.add(pos + 1);
                }
            }
            
            cnt++;
            
            list = new ArrayList<>(tmp);
        }
        
        return result;
    }
}
