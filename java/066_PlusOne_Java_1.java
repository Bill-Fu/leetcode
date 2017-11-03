class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        else {
            digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;
            for (int i = digits.length - 2; i >= 0; --i) {
                if (digits[i + 1] == 0) {
                    digits[i] = (digits[i] + 1) % 10;
                }
                else {
                    break;
                }
            }
            
            if (digits[0] == 0) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int i = 1; i < result.length; ++i) {
                    result[i] = digits[i - 1];
                }
                return result;
            }
            else {
                return digits;
            }
        }
    }
}
