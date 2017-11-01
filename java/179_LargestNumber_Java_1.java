class Solution {
    public String largestNumber(int[] nums) {
        String result = "";
        Integer[] nums_obj = new Integer[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            nums_obj[i] = nums[i];
        }
        
        Arrays.sort(nums_obj, new Comparator<Integer>() {
            public int compare (Integer o1, Integer o2) {
                String s1 = Integer.toString(o1);
                String s2 = Integer.toString(o2);
                
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        for (int i = 0; i < nums_obj.length; ++i) {
            result += Integer.toString(nums_obj[i]);
        }
        
        while (result.charAt(0) == '0' && result.length() > 1) {
            result = result.substring(1, result.length());
        }
        
        return result;
    }
}
