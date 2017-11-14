class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        
        if (nums.length != 0) {
            result[result.length - 1] = 0;
            
            TreeNode root = new TreeNode(nums[nums.length - 1]);
            
            for (int i = result.length - 2; i >= 0; --i) {
                result[i] = insertNode(root, nums[i]);
            }
        }
        
        
        return Arrays.asList(result);
    }
    
    private int insertNode(TreeNode root, int val) {
        int smallerNum = 0;
        
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                smallerNum += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        
        return smallerNum;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int count = 1;
    public TreeNode(int val) {
        this.val = val;
    }
}
