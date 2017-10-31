class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }
        else {
            int start, end;
            int accum = 0;
            
            start = end = 0;
            do {
                if (accum < 0) {
                    start = (start - 1 + gas.length) % gas.length;
                    accum += gas[start] - cost[start];
                }
                else {
                    accum += gas[end] - cost[end];
                    end = (end + 1) % gas.length;
                }
            } while (start != end);
            
            if (accum >= 0) {
                return start;
            }
            else {
                return -1;
            }
        }
    }
}
