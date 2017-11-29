class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        else {
            char[] charArr = word.toCharArray();
            int option;
            
            if (charArr[0] - 'A' >= 0 && charArr[0] - 'A' < 26 && charArr[1] - 'A' >= 0 && charArr[1] - 'A' < 26) {
                option = 1;
            }
            else if (charArr[0] - 'a' >= 0 && charArr[0] - 'a' < 26 && charArr[1] - 'a' >= 0 && charArr[1] - 'a' < 26) {
                option = 2;
            }
            else if (charArr[0] - 'A' >= 0 && charArr[0] - 'A' < 26 && charArr[1] - 'a' >= 0 && charArr[1] - 'a' < 26) {
                option = 3;
            }
            else {
                option = 0;
            }
            
            if (option == 0) {
                return false;
            }
            else {
                for (int i = 2; i < charArr.length; ++i) {
                    if (charArr[i] - 'A' >= 0 && charArr[i] - 'A' < 26) {
                        if (option == 2 || option == 3) {
                            return false;
                        }
                    }
                    else {
                        if (option == 1) {
                            return false;
                        }
                    }
                }
                
                return true;
            }   
        }
    }
}
