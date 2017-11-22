class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;

        if (k == 0) {
            return result;
        }
        else {
            Map<Character, Integer> map = new HashMap<>();
            char[] charArray = s.toCharArray();
            int start = -1;
            int end = 0;
            
            for (; end < charArray.length; ++end) {
                if (map.size() == k && map.containsKey(charArray[end]) == false) {
                    result = end - start - 1;
                    break;
                }
                else {
                    if (map.containsKey(charArray[end])) {
                        map.put(charArray[end], map.get(charArray[end]) + 1);
                    }
                    else {
                        map.put(charArray[end], 1);
                    }
                }
            }

            if (end == charArray.length) {
                return end - start - 1;
            }
            else {
                while (end < charArray.length) {
                    for (start++; start < end; start++) {
                        if (map.get(charArray[start]) == 1) {
                            map.remove(charArray[start]);
                            break;
                        }
                        else {
                            map.put(charArray[start], map.get(charArray[start]) - 1);
                        }
                    }

                    for (; end < charArray.length; ++end) {
                        if (map.size() == k && map.containsKey(charArray[end]) == false) {
                            if (end - start - 1 > result) {
                                result = end - start - 1;
                            }
                            break;
                        }
                        else {
                            if (map.containsKey(charArray[end])) {
                                map.put(charArray[end], map.get(charArray[end]) + 1);
                            }
                            else {
                                map.put(charArray[end], 1);
                            }
                        }
                    }
                }

                if (end - start - 1 > result) {
                    result = end - start - 1;
                }

                return result;
            }            
        }
    }
}
