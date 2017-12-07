class Solution {
    public String addStrings(String num1, String num2) {
        char[] charArr1 = num1.toCharArray();
        char[] charArr2 = num2.toCharArray();
        String result = "";
        int digit1, digit2;
        int carry = 0;
        int sum;
        
        for (int i = 0; i < Math.max(charArr1.length, charArr2.length); ++i) {
            if (i < charArr1.length) {
                digit1 = charArr1[charArr1.length - 1 - i] - '0';
            }
            else {
                digit1 = 0;
            }
            if (i < charArr2.length) {
                digit2 = charArr2[charArr2.length - 1 - i] - '0';
            }
            else {
                digit2 = 0;
            }
            
            sum = (digit1 + digit2 + carry) % 10;
            
            result = Integer.toString(sum) + result;
            
            carry = (digit1 + digit2 + carry) / 10;
        }
        
        if (carry != 0) {
            result = Integer.toString(carry) + result;
        }
        
        return result;
    }
}
