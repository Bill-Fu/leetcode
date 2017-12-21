class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        
        Arrays.sort(heaters);
        
        for (int i = 0; i < houses.length; ++i) {
            int nearest = findNearest(houses[i], heaters);
            result = Math.max(result, Math.abs(nearest - houses[i]));
        }
        
        return result;
    }
    
    public int findNearest(int pos, int[] heaters) {
        return findNearest(pos, heaters, 0, heaters.length - 1);
    }
    
    public int findNearest(int pos, int[] heaters, int start, int end) {
        if (start > end) {
            return -1;
        }
        else if (start == end) {
            return heaters[start];
        }
        else if (pos <= heaters[start]) {
            return heaters[start];
        }
        else if (pos >= heaters[end]) {
            return heaters[end];
        }
        else if (start == end - 1) {
            return Math.abs(pos - heaters[start]) < Math.abs(pos - heaters[end])? heaters[start]: heaters[end];
        }
        else {
            int mid = start + (end - start) / 2;
            if (pos == heaters[mid]) {
                return pos;
            }
            else if (pos < heaters[mid]) {
                return findNearest(pos, heaters, start, mid);
            }
            else {
                return findNearest(pos, heaters, mid, end);
            }
        }
    }
}
