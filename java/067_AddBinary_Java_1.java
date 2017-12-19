class Solution {
    public String addBinary(String a, String b) {
        char[] charArrA = a.toCharArray();
        char[] charArrB = b.toCharArray();
        String result = "";
        int carry = 0;
        int pos = 0;
        
        while (pos < charArrA.length || pos < charArrB.length || carry != 0) {
            int A = 0;
            if (pos < charArrA.length) {
                A = charArrA[charArrA.length - 1 - pos] - '0';
            }
            
            int B = 0;
            if (pos < charArrB.length) {
                B = charArrB[charArrB.length - 1 - pos] - '0';
            }
            
            int sum = A + B + carry;
            
            result = (char) ('0' + (sum % 2)) + result;
            
            carry = sum / 2;
            pos++;
        }
        
        return result;

    }
}
