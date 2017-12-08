class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        else {
            long NUM;
            
            if (num < 0) {
                NUM = (long)Math.pow(2, 32) + (long)num;
            }
            else {
                NUM = (long)num; 
            }
            
            String result = "";
            
            while (NUM != 0) {
                switch ((int) (NUM % 16)) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        result = Integer.toString((int) (NUM % 16)) + result;
                        break;
                    case 10:
                        result = "a" + result;
                        break;
                    case 11:
                        result = "b" + result;
                        break;
                    case 12:
                        result = "c" + result;
                        break;
                    case 13:
                        result = "d" + result;
                        break;
                    case 14:
                        result = "e" + result;
                        break;
                    case 15:
                        result = "f" + result;
                        break;
                }
                NUM /= 16;
            }
            
            return result;
        }
    }
}
