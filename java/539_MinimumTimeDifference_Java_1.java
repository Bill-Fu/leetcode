class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] tps = new int[timePoints.size()];
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < tps.length; ++i) {
            tps[i] = time2int(timePoints.get(i));
        }
        
        Arrays.sort(tps);
        
        for (int i = 0; i < tps.length; ++i) {
            result = Math.min(result, (tps[i] - tps[(i + tps.length - 1) % tps.length] + 1440) % 1440);
        }
        
        return result;
    }
    
    public int time2int(String timePoints) {
        return Integer.parseInt(timePoints.split(":")[0]) * 60 + Integer.parseInt(timePoints.split(":")[1]);
    }
}
