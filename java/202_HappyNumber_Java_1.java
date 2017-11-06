class Solution {
    public boolean isHappy(int n) {
        int ptr1 = n;
        int ptr2 = n;
        int tmp = 0;
        
        do {
            tmp = 0;
            while (ptr1 != 0) {
                tmp += (ptr1 % 10) * (ptr1 % 10);
                ptr1 = ptr1 / 10;
            }
            ptr1 = tmp;
            
            tmp = 0;
            while (ptr2 != 0) {
                tmp += (ptr2 % 10) * (ptr2 % 10);
                ptr2 = ptr2 / 10;
            }
            ptr2 = tmp;
            
            tmp = 0;
            while (ptr2 != 0) {
                tmp += (ptr2 % 10) * (ptr2 % 10);
                ptr2 = ptr2 / 10;
            }
            ptr2 = tmp; 
        } while (ptr2 != 1 && ptr2 != ptr1);
        
        if (ptr2 == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
