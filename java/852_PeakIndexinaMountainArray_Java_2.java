class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 1, right = A.length - 2;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                left = mid + 1;
            }
            else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        
        return -1;
    }
}
