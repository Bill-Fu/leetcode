class Solution {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n <= 3) {
            return 1;
        }
        else {
            int[] magStr = new int[n + 1];
            int pos1 = 4;
            int pos2 = 3;
            int result = 1;

            magStr[1] = 1;
            magStr[2] = 2;
            magStr[3] = 2;

            while (pos1 <= n) {
                if (magStr[pos2++] == 1) {
                    if (magStr[pos1 - 1] == 1) {
                        magStr[pos1++] = 2;
                    }
                    else {
                        magStr[pos1++] = 1;
                        result++;
                    }
                }
                else {
                    if (magStr[pos1 - 1] == 1) {
                        magStr[pos1++] = 2;

                        if (pos1 <= n) {
                            magStr[pos1++] = 2;
                        }
                    }
                    else {
                        magStr[pos1++] = 1;
                        result++;

                        if (pos1 <= n) {
                            magStr[pos1++] = 1;
                            result++;
                        }                    
                    }
                }
            }

            return result;            
        }
    }
}
