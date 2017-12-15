/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        int gss = guess(mid);
        
        while (gss != 0) {
            if (gss > 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            
            mid = left + (right - left) / 2;
            gss = guess(mid);
        }
        
        return mid;
    }
}
