class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        else {
            str = str.trim();
            boolean sign = true;
            int result = 0;
            
            for (int i = 0; i < str.length(); ++i) {
                switch(str.charAt(i)) {
                    case '+':
                        if (i != 0) {
                            if (result > 0 && sign == true || result < 0 && sign == false) {
                                return result;
                            }
                            else if (result < 0 && sign == true) {
                                return Integer.MAX_VALUE;
                            }
                            else if (result > 0 && sign == false) {
                                return Integer.MIN_VALUE;
                            }
                            else {
                                return 0;
                            }
                        }
                        break;
                    case '-':
                        if (i != 0) {
                            if (result > 0 && sign == true || result < 0 && sign == false) {
                                return result;
                            }
                            else if (result < 0 && sign == true) {
                                return Integer.MAX_VALUE;
                            }
                            else if (result > 0 && sign == false) {
                                return Integer.MIN_VALUE;
                            }
                            else {
                                return 0;
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
                            if (result > Integer.MAX_VALUE / 5) {
                                return Integer.MAX_VALUE;
                            }
                            result = result * 10 + (str.charAt(i) - '0');
                            if (result < 0) {
                                return Integer.MAX_VALUE;
                            }
                            
                        }
                        else {
                            if (result < Integer.MIN_VALUE / 5) {
                                return Integer.MIN_VALUE;
                            }
                            result = result * 10 - (str.charAt(i) - '0');
                            if (result > 0) {
                                return Integer.MIN_VALUE;
                            }
                        }
                        break;
                    default:
                        if (result > 0 && sign == true || result < 0 && sign == false) {
                            return result;
                        }
                        else if (result < 0 && sign == true) {
                            return Integer.MAX_VALUE;
                        }
                        else if (result > 0 && sign == false) {
                            return Integer.MIN_VALUE;
                        }
                        else {
                            return 0;
                        }
                }
            }
            
            if (result > 0 && sign == true || result < 0 && sign == false) {
                return result;
            }
            else if (result < 0 && sign == true) {
                return Integer.MAX_VALUE;
            }
            else if (result > 0 && sign == false) {
                return Integer.MIN_VALUE;
            }
            else {
                return 0;
            }
        }
    }
}
