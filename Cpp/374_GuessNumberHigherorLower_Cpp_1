// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        int min=1;
        int max=n;
        int mid;
        while(min!=max)
        {
            mid=min/2+max/2;
            if(guess(mid)==0)
            {
                return mid;
            }
            else if(guess(mid)==-1)
            {
                max=mid;
            }
            else
            {
                min=mid+1;
            }
        }
        return min;
    }
};
