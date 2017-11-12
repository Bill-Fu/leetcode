class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            else if (map.containsKey(nums[i] + 1) == false && map.containsKey(nums[i] - 1) == false) {
                map.put(nums[i], nums[i]);
            }
            else if (map.containsKey(nums[i] + 1) == true && map.get(nums[i] + 1) == nums[i] + 1 && map.containsKey(nums[i] - 1) == false) {
                map.put(nums[i], nums[i] + 1);
                map.put(nums[i] + 1, nums[i]);
            }
            else if (map.containsKey(nums[i] + 1) == true && map.get(nums[i] + 1) > nums[i] + 1 && map.containsKey(nums[i] - 1) == false) {
                map.put(map.get(nums[i] + 1), nums[i]);
                map.put(nums[i], map.get(nums[i] + 1));
                map.remove(nums[i] + 1);
            }
            else if (map.containsKey(nums[i] + 1) == false && map.containsKey(nums[i] - 1) == true && map.get(nums[i] - 1) == nums[i] - 1) {
                map.put(nums[i], nums[i] - 1);
                map.put(nums[i] - 1, nums[i]);
            }
            else if (map.containsKey(nums[i] + 1) == false && map.containsKey(nums[i] - 1) == true && map.get(nums[i] - 1) < nums[i] - 1) {
                map.put(map.get(nums[i] - 1), nums[i]);
                map.put(nums[i], map.get(nums[i] - 1));
                map.remove(nums[i] - 1);
            }
            else if (map.containsKey(nums[i] + 1) == true && map.get(nums[i] + 1) == nums[i] + 1 && map.containsKey(nums[i] - 1) == true && map.get(nums[i] - 1) == nums[i] - 1) {
                map.put(nums[i] + 1, nums[i] - 1);
                map.put(nums[i] - 1, nums[i] + 1);
            }
            else if (map.containsKey(nums[i] + 1) == true && map.get(nums[i] + 1) > nums[i] + 1 && map.containsKey(nums[i] - 1) == true && map.get(nums[i] - 1) == nums[i] - 1) {
                map.put(nums[i] - 1, map.get(nums[i] + 1));
                map.put(map.get(nums[i] + 1), nums[i] - 1);
                map.remove(nums[i] + 1);
            }
            else if (map.containsKey(nums[i] + 1) == true && map.get(nums[i] + 1) == nums[i] + 1 && map.containsKey(nums[i] - 1) == true && map.get(nums[i] - 1) < nums[i] - 1) {
                map.put(nums[i] + 1, map.get(nums[i] - 1));
                map.put(map.get(nums[i] - 1), nums[i] + 1);
                map.remove(nums[i] - 1);
            }
            else if (map.containsKey(nums[i] + 1) == true && map.get(nums[i] + 1) > nums[i] + 1 && map.containsKey(nums[i] - 1) == true && map.get(nums[i] - 1) < nums[i] - 1) {
                map.put(map.get(nums[i] + 1), map.get(nums[i] - 1));
                map.put(map.get(nums[i] - 1), map.get(nums[i] + 1));
                map.remove(nums[i] + 1);
                map.remove(nums[i] - 1);
            }
        }
        
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() - entry.getKey() + 1 > result) {
                result = entry.getValue() - entry.getKey() + 1;
            }
        }
        
        return result;
    }
}
