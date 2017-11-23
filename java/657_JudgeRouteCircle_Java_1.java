class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;

        char[] Moves = moves.toCharArray();
        
        for (int i = 0; i < Moves.length; ++i) {
            switch(Moves[i]) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    down++;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
            }
        }
        
        return left == right && up == down;
    }
}
