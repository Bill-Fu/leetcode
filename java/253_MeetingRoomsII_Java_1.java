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
        int result = 0;
        int cur = 0;
        Tuple[] array = new Tuple[intervals.length * 2];
        
        for (int i = 0; i < intervals.length; ++i) {
            array[i * 2] = new Tuple(intervals[i].start, i, 1);
            array[i * 2 + 1] = new Tuple(intervals[i].end, i, 0);
        }
        
        Arrays.sort(array);
        
        for (int i = 0; i < array.length; ++i) {
            if (array[i].val == intervals[array[i].idx].start) {
                cur++;
                if (cur > result) {
                    result = cur;
                }
            }
            else {
                cur--;
            }
        }
        
        return result;
    }
}

class Tuple implements Comparable<Tuple> {
    int val, idx, point;
    public Tuple (int val, int idx, int point) {
        this.val = val;
        this.idx = idx;
        this.point = point;
    }
    
    @Override
    public int compareTo (Tuple that) {
        if (this.val != that.val) {
            return this.val - that.val;
        }
        else {
            return this.point - that.point;
        }
    }
}
