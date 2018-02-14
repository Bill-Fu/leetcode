class Solution {
    int result;
    
    public int pathSum(int[] nums) {
        int[] tree = new int[32];
        
        Arrays.fill(tree, -1);
        
        for (int num: nums) {
            int val = num % 10;
            int pos = (num / 10) % 10;
            int dep = (num / 100) % 10;
            
            tree[pos + ((int) Math.pow(2, dep - 1)) - 1] = val;
        }
        
        result = 0;
        
        pathSum(tree, 1, 0);
        
        return result;
    }
    
    public void pathSum(int[] tree, int pos, int path) {
        if (tree[pos] != -1) {
            path += tree[pos];
            
            if (tree[2 * pos] == -1 && tree[2 * pos + 1] == -1) {
                result += path;
            }
            else {
                pathSum(tree, 2 * pos, path);
                pathSum(tree, 2 * pos + 1, path);
            }
        }
    }
}
