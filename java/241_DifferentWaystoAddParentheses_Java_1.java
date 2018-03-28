class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        String[] nums = input.split("\\+|-|\\*");
        String[] ops = input.split("\\d+");
        
        return diffWaysToCompute(nums, ops, 0, nums.length);
    }
    
    public List<Integer> diffWaysToCompute(String[] nums, String[] ops, int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        if (left == right - 1) {
            result.add(Integer.parseInt(nums[left]));
        }
        else {
            for (int i = left + 1; i < right; ++i) {
                List<Integer> lefts = diffWaysToCompute(nums, ops, left, i);
                List<Integer> rights = diffWaysToCompute(nums, ops, i, right);
                
                for (int l: lefts) {
                    for (int r: rights) {
                        if (ops[i].equals("+")) {
                            result.add(l + r);
                        }
                        else if (ops[i].equals("-")) {
                            result.add(l - r);
                        }
                        else {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
