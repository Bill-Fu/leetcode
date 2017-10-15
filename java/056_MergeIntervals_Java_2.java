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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        
        int [] starts = new int[intervals.size()];
        int [] ends = new int[intervals.size()];
        
        for (int i = 0; i < intervals.size(); ++i) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        List<Interval> result = new ArrayList<>();
        
        for (int i = 0, j = 0; i < starts.length; ++i) {
            if (i == starts.length - 1 || starts[i + 1] > ends[i]) {
                Interval tmp = new Interval(starts[j], ends[i]);
                result.add(tmp);
                j = i + 1;
            }
        }
        
        return result;
    }
}
