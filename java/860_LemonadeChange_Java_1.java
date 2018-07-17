class Solution {
    public boolean lemonadeChange(int[] bills) {
        int buck_5 = 0, buck_10 = 0;
        
        for (int bill: bills) {
            if (bill == 5) {
                buck_5++;
            }
            else if (bill == 10) {
                if (buck_5 == 0) {
                    return false;
                }
                else {
                    buck_5--;
                    buck_10++;
                }
            }
            else {
                if (buck_10 != 0 && buck_5 != 0) {
                    buck_10--;
                    buck_5--;
                }
                else if (buck_5 > 2) {
                    buck_5 -= 3;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
