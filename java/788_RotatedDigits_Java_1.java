class Solution {
    public int rotatedDigits(int N) {
        int result = 0;
        boolean sign = false;
        
        N = N + 1;
        
        while (N != 0) {
            for (int i = 0; i < (int)(N / (int)Math.pow(10, (int)Math.log10(N))); ++i) {
                switch (i) {
                    case 0:
                    case 1:
                    case 8:
                        if (sign == false) {
                            result += (int)(Math.pow(7, (int)Math.log10(N)) - Math.pow(3, (int)Math.log10(N)));
                        }
                        else {
                            result += (int)Math.pow(7, (int)Math.log10(N));
                        }

                        break;
                    case 2:
                    case 5:
                    case 6:
                    case 9:
                        result += (int)Math.pow(7, (int)Math.log10(N));
                        break;
                    default:
                        break;
                }
            }
            
            switch (N / (int)Math.pow(10, (int)Math.log10(N))) {
                case 0:
                case 1:
                case 8:
                    break;
                case 2:
                case 5:
                case 6:
                case 9:
                    sign = true;
                    break;
                default:
                    return result;
            }
            
            N = N % ((int)Math.pow(10, (int)Math.log10(N)));
        }
        
        
        
        return result;
    }
}
