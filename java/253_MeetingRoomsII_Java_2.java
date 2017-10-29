/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int result = 0, cur = 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int p = 0, q = 0;
        
        for (int i = 0; i < intervals.length; ++i) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        while (p < starts.length) {
            if (starts[p] < ends[q]) {
                cur++;
                if (cur > result) {
                    result = cur;
                }
                p++;
            }
            else {
                cur--;
                q++;
            }
        }
        
        return result;
    }
}
