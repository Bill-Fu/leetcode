// Use long type for result to solve overflow problem
class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        else {
            str = str.trim();
            boolean sign = true;
            long result = 0;
            
            for (int i = 0; i < str.length(); ++i) {
                switch(str.charAt(i)) {
                    case '+':
                        if (i != 0) {
                            if (result > Integer.MAX_VALUE) {
                                return Integer.MAX_VALUE;
                            }
                            else if (result < Integer.MIN_VALUE) {
                                return Integer.MIN_VALUE;
                            }
                            else {
                                return (int) result;
                            }
                        }
                        break;
                    case '-':
                        if (i != 0) {
                            if (result > Integer.MAX_VALUE) {
                                return Integer.MAX_VALUE;
                            }
                            else if (result < Integer.MIN_VALUE) {
                                return Integer.MIN_VALUE;
                            }
                            else {
                                return (int) result;
                            }
                        }
                        else {
                            sign = false;
                        }
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        if (sign) {
                            result = result * 10 + (str.charAt(i) - '0');
                            if (result > Integer.MAX_VALUE) {
                                return Integer.MAX_VALUE;
                            }
                            
                        }
                        else {
                            result = result * 10 - (str.charAt(i) - '0');
                            if (result < Integer.MIN_VALUE) {
                                return Integer.MIN_VALUE;
                            }
                        }
                        break;
                    default:
                        if (result > Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                        else if (result < Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                        else {
                            return (int) result;
                        }
                }
            }
            
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            else {
                return (int) result;
            }
        }
    }
}
