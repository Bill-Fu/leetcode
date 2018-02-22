class Solution {
    public int numRabbits(int[] answers) {
        int result = 0;
        
        Arrays.sort(answers);
        
        int cnt = 0;
         
        for (int i = 0; i < answers.length; ++i) {
            if (i != 0 && answers[i] != answers[i - 1]) {
                if (cnt % (answers[i - 1] + 1) == 0) {
                    result += cnt;
                }
                else {
                    result += ((cnt / (answers[i - 1] + 1)) + 1) * (answers[i - 1] + 1);
                }
                
                cnt = 0;
            }
            
            cnt++;
        }
        
        if (cnt % (answers[answers.length - 1] + 1) == 0) {
            result += cnt;
        }
        else {
            result += ((cnt / (answers[answers.length - 1] + 1)) + 1) * (answers[answers.length - 1] + 1);            
        }
        
        return result;
    }
}
