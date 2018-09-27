class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int diff = 0;
        int[] res = new int[2];
        Set<Integer> barsBob = new HashSet<>();
        
        for (int size: B) {
            diff += size;
            barsBob.add(size);
        }
        
        for (int size: A) {
            diff -= size;
        }
        
        for (int size: A) {
            if (barsBob.contains(size + diff / 2)) {
                res[0] = size;
                res[1] = size + diff / 2;
                break;
            }
        }
        
        return res;
    }
}
