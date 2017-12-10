class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] charArr = num.toCharArray();
        if (charArr.length % 2 == 0) {
            for (int i = 0; i < charArr.length / 2; ++i) {
                switch(charArr[i]) {
                    case '0':
                        if (charArr[charArr.length - 1 - i] != '0') {
                            return false;
                        }
                        break;
                    case '1':
                        if (charArr[charArr.length - 1 - i] != '1') {
                            return false;
                        }
                        break;
                    case '8':
                        if (charArr[charArr.length - 1 - i] != '8') {
                            return false;
                        }
                        break;
                    case '6':
                        if (charArr[charArr.length - 1 - i] != '9') {
                            return false;
                        }
                        break;
                    case '9':
                        if (charArr[charArr.length - 1 - i] != '6') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
            
            return true;
        }
        else {
            if (charArr[charArr.length / 2] != '1' && charArr[charArr.length / 2] != '8' && charArr[charArr.length / 2] != '0') {
                return false;
            }
            else {
                for (int i = 0; i < charArr.length / 2; ++i) {
                    switch(charArr[i]) {
                        case '0':
                            if (charArr[charArr.length - 1 - i] != '0') {
                                return false;
                            }
                            break;
                        case '1':
                            if (charArr[charArr.length - 1 - i] != '1') {
                                return false;
                            }
                            break;
                        case '8':
                            if (charArr[charArr.length - 1 - i] != '8') {
                                return false;
                            }
                            break;
                        case '6':
                            if (charArr[charArr.length - 1 - i] != '9') {
                                return false;
                            }
                            break;
                        case '9':
                            if (charArr[charArr.length - 1 - i] != '6') {
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
                
                return true;
            }
        }
    }
}
