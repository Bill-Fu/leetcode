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
        List<Interval> result = new ArrayList<>();

        Comparator<Interval> comp = (Interval a, Interval b) -> {
            if (a.start == b.start) {
                return 0;
            }
            else if (a.start < b.start) {
                return -1;
            }
            else {
                return 1;
            }
        };
        
        Collections.sort(intervals, comp);
        
        if (intervals.size() == 0) {
            return result;
        }
        
        Interval tmp = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); ++i) {
            if (tmp.end < intervals.get(i).start) {
                result.add(tmp);
                tmp = intervals.get(i);
            }
            else if (tmp.end < intervals.get(i).end){
                tmp.end = intervals.get(i).end;
            }
        }
        
        result.add(tmp);
        
        return result;
    }
}
