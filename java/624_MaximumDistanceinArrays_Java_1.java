class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1, min2, max1, max2;
        int min1Idx, min2Idx, max1Idx, max2Idx;
        min1 = Integer.MAX_VALUE;
        min2 = Integer.MAX_VALUE;
        max1 = Integer.MIN_VALUE;
        max2 = Integer.MIN_VALUE;
        min1Idx = min2Idx = max1Idx = max2Idx = -1;
        
        for (int i = 0; i < arrays.size(); ++i) {
            if (arrays.get(i).get(0) < min1) {
                min2 = min1;
                min2Idx = min1Idx;
                min1 = arrays.get(i).get(0);
                min1Idx = i;
            }
            else if (arrays.get(i).get(0) < min2) {
                min2 = arrays.get(i).get(0);
                min2Idx = i;
            }
            
            if (arrays.get(i).get(arrays.get(i).size() - 1) > max1) {
                max2 = max1;
                max2Idx = max1Idx;
                max1 = arrays.get(i).get(arrays.get(i).size() - 1);
                max1Idx = i;
            }
            else if (arrays.get(i).get(arrays.get(i).size() - 1) > max2) {
                max2 = arrays.get(i).get(arrays.get(i).size() - 1);
                max2Idx = i;
            }
        }
        
        if (min1Idx != max1Idx) {
            return max1 - min1;
        }
        else {
            return Math.max(max2 - min1, max1 - min2);
        }
    }
}
