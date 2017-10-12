class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        int sum;
        
        tmp.add(1);
        sum = 1;
        
        while (true) {
            if (tmp.size() == k) {
                if (tmp.getLast() > 9) {
                    sum -= tmp.removeLast();
                    sum ++;
                    tmp.add(tmp.removeLast() + 1);
                }
                else if (sum == n) {
                    result.add(new ArrayList<Integer>(tmp));
                    sum -= tmp.removeLast();
                    sum ++;
                    tmp.add(tmp.removeLast() + 1);
                }
                else if (sum > n) {
                    sum -= tmp.removeLast();
                    sum ++;
                    tmp.add(tmp.removeLast() + 1);
                }
                else {
                    sum ++;
                    tmp.add(tmp.removeLast() + 1);
                }
            }
            else {
                if (tmp.getLast() > 9) {
                    sum -= tmp.removeLast();
                    if (tmp.size() == 0) {
                        break;
                    }
                    sum ++;
                    tmp.add(tmp.removeLast() + 1);
                }
                else {
                    tmp.add(tmp.getLast() + 1);
                    sum += tmp.getLast();
                }
            }
        }
        
        return result;
    }
}
