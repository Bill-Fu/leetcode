class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        else {
            String result = "";
            boolean minus = false;
            
            if (num < 0) {
                minus = true;
                num = -num;
            }
            
            while (num != 0) {
                result = Integer.toString(num % 7) + result;
                num /= 7;
            }
            
            if (minus) {
                result = "-" + result;
            }
            
            return result;
        }
        
        
    }
}
