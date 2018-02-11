class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        Character[] s_arr = new Character[map.size()];
        int pos = 0;
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            s_arr[pos++] = entry.getKey();
        }
        
        Arrays.sort(s_arr, (a, b) -> map.get(b) - map.get(a));
        
        char[] result = new char[s.length()];
        pos = 0;
        
        for (int i = 0; i < s_arr.length; ++i) {
            Arrays.fill(result, pos, pos + map.get(s_arr[i]), s_arr[i]);
            pos += map.get(s_arr[i]);
        }
        
        return new String(result);
    }
}
