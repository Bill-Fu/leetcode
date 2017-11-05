class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'M':
                    result += 1000;
                    break;
                case 'D' :
                    result += 500;
                    break;
                case 'C' :
                    if (i != s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        if (s.charAt(i + 1) == 'D') {
                            result += 400;
                        }
                        else {
                            result += 900;
                        }
                        i++;
                    }
                    else {
                        result += 100;
                    }
                    break;
                case 'L' :
                    result += 50;
                    break;
                case 'X' :
                    if (i != s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        if (s.charAt(i + 1) == 'L') {
                            result += 40;
                        }
                        else {
                            result += 90;
                        }
                        i++;
                    }
                    else {
                        result += 10;
                    }
                    break;
                case 'V' :
                    result += 5;
                    break;
                case 'I' :
                    if (i != s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        if (s.charAt(i + 1) == 'V') {
                            result += 4;
                        }
                        else {
                            result += 9;
                        }
                        i++;
                    }
                    else {
                        result += 1;
                    }
                    break;
            }
        }
        
        return result;
    }
}
