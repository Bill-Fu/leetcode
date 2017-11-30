class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length < 2) {
            return true;
        }
        else {
            int i;
            
            for (i = 0; i < bits.length - 1; ++i) {
                switch (bits[i]) {
                    case 0:
                        break;
                    case 1:
                        i++;
                        break;
                }
            }
            
            return i == bits.length - 1;
        }
    }
}
