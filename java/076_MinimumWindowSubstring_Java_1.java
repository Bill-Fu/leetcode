class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (t.length() == 0 || s.length() < t.length()) {
            return result;
        }
        else {
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            
            for (int i = 0; i < charT.length; ++i) {
                if (map.containsKey(charT[i])) {
                    map.put(charT[i], map.get(charT[i]) + 1);
                }
                else {
                    map.put(charT[i], 1);
                }
                set.add(charT[i]);
            }
            
            for (int i = 0; i < charS.length; ++i) {
                if (map.containsKey(charS[i])) {
                    queue.add(i);
                    map.put(charS[i], map.get(charS[i]) - 1);
                    if (map.get(charS[i]) <= 0) {
                        set.remove(charS[i]);
                    }
                    if (set.isEmpty()) {
                        break;
                    }
                }
            }
            
            if (set.isEmpty() == false) {
                return result;
            }
            else {
                result = s.substring(queue.getFirst(), queue.getLast() + 1);
            }
            
            while (true) {
                int tmp = queue.getLast();
                map.put(charS[queue.peek()], map.get(charS[queue.peek()]) + 1);
                if (map.get(charS[queue.peek()]) > 0) {
                    set.add(charS[queue.peek()]);
                }
                queue.pop();
                
                if (set.isEmpty()) {
                    if (s.substring(queue.getFirst(), queue.getLast() + 1).length() < result.length()) {
                        result = s.substring(queue.getFirst(), queue.getLast() + 1);
                    }
                }
                else {
                    
                    for (int i = tmp + 1; i < s.length(); ++i) {
                        if (map.containsKey(charS[i])) {
                            queue.add(i);
                            map.put(charS[i], map.get(charS[i]) - 1);
                            if (map.get(charS[i]) == 0) {
                                set.remove(charS[i]);
                            }
                            if (set.isEmpty()) {
                                break;
                            }
                        }
                    }
                    
                    if (set.isEmpty()) {
                        if (s.substring(queue.getFirst(), queue.getLast() + 1).length() < result.length()) {
                            result = s.substring(queue.getFirst(), queue.getLast() + 1);
                        }
                    }
                    else {
                        return result;
                    }
                }
            }
        }
    }
}
