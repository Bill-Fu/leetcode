class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nuts.length; ++i) {
            result += 2 * (Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]));
            min = Math.min(min, (Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]) - Math.abs(tree[0] - nuts[i][0]) - Math.abs(tree[1] - nuts[i][1])));
        }
        
        return result + min;
    }
}
