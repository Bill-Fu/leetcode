class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        
        char[] charS = S.toCharArray();
        
        int cnt = 1;
        for (int i = 1; i < charS.length; ++i) {
            if (charS[i] != charS[i - 1]) {
                if (cnt >= 3) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i - cnt);
                    tmp.add(i - 1);
                    result.add(tmp);
                }
                
                cnt = 0;
            }
            
            cnt++;
        }
        
        if (cnt >= 3) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(charS.length - cnt);
            tmp.add(charS.length - 1);
            result.add(tmp);
        }
        
        return result;
    }
}
