class Solution {
public:
    bool checkPerfectNumber(int num) {
        int s = 1;
        
        if(num == 1) {
            return false;
        }
        
        for(int i = 2; i <= sqrt(num); ++i) {
            if(num % i == 0) {
                s += i;
                s += num / i;
            }
        }
        
        if(num == s) {
            return true;
        }
        else {
            return false;
        }
    }
};
