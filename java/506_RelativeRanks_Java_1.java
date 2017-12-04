class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        int[][] table = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; ++i) {
            table[i][0] = nums[i];
            table[i][1] = i;
        }
        
        Arrays.sort(table, Comparator.comparing((int[] arr) -> -arr[0]));
        
        for (int i = 0; i < table.length; ++i) {
            switch (i) {
                case 0:
                    result[table[i][1]] = "Gold Medal";
                    break;
                case 1:
                    result[table[i][1]] = "Silver Medal";
                    break;
                case 2:
                    result[table[i][1]] = "Bronze Medal";
                    break;
                default:
                    result[table[i][1]] = Integer.toString(i + 1);
                    break;
            }
        }
        
        return result;
    }
}
