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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparing((Interval) -> Interval.start));
        
        for (int i = 0; i < intervals.length - 1; ++i) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        
        return true;
    }
}
