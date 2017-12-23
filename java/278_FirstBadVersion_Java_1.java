/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        else {
            return firstBadVersion(1, n);
        }
    }
    
    public int firstBadVersion(int left, int right) {
        if (left > right) {
            return 0;
        }
        else if (left == right) {
            return right;
        }
        else if (left == right - 1) {
            return right;
        }
        else {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                return firstBadVersion(left, mid);
            }
            else {
                return firstBadVersion(mid, right);
            }
        }
    }
}
