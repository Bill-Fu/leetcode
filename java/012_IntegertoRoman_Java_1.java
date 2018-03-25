class Solution {
    public String intToRoman(int num) {
        String result = "";
        int digit = 0;
        
        while (num != 0) {
            switch (digit++) {
                case 0:
                    switch (num % 10) {
                        case 0:
                            break;
                        case 1:
                            result = "I" + result;
                            break;
                        case 2:
                            result = "II" + result;
                            break;
                        case 3:
                            result = "III" + result;
                            break;
                        case 4:
                            result = "IV" + result;
                            break;
                        case 5:
                            result = "V" + result;
                            break;
                        case 6:
                            result = "VI" + result;
                            break;
                        case 7:
                            result = "VII" + result;
                            break;
                        case 8:
                            result = "VIII" + result;
                            break;
                        case 9:
                            result = "IX" + result;
                            break;                            
                            
                    }
                    break;
                case 1:
                    switch (num % 10) {
                        case 0:
                            break;
                        case 1:
                            result = "X" + result;
                            break;
                        case 2:
                            result = "XX" + result;
                            break;
                        case 3:
                            result = "XXX" + result;
                            break;
                        case 4:
                            result = "XL" + result;
                            break;
                        case 5:
                            result = "L" + result;
                            break;
                        case 6:
                            result = "LX" + result;
                            break;
                        case 7:
                            result = "LXX" + result;
                            break;
                        case 8:
                            result = "LXXX" + result;
                            break;
                        case 9:
                            result = "XC" + result;
                            break;                            
                            
                    }
                    break;
                case 2:
                    switch (num % 10) {
                        case 0:
                            break;
                        case 1:
                            result = "C" + result;
                            break;
                        case 2:
                            result = "CC" + result;
                            break;
                        case 3:
                            result = "CCC" + result;
                            break;
                        case 4:
                            result = "CD" + result;
                            break;
                        case 5:
                            result = "D" + result;
                            break;
                        case 6:
                            result = "DC" + result;
                            break;
                        case 7:
                            result = "DCC" + result;
                            break;
                        case 8:
                            result = "DCCC" + result;
                            break;
                        case 9:
                            result = "CM" + result;
                            break;                            
                            
                    }                    
                    break;
                case 3:
                    for (int i = 0; i < num % 10; ++i) {
                        result = "M" + result;
                    }
                    break;
                default:
                    break;
            }
            
            num /= 10;
        }
        
        return result;
    }
}
