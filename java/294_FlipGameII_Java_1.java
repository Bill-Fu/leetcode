class Solution {
    Map<String, Integer> map;
    
    public boolean canWin(String s) {
        map = new HashMap<>();
        
        return canWinPack(s) == 1;
    }
    
    public int canWinPack(String s) {
        if (s.equals("") == true) {
            return -1;
        }
        else {
            int win = 0;
            int lose = 0;
            int tie = 0;
            for (int i = 0; i < s.length() - 1; ++i) {
                if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                    String tmp = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                    if (tmp.indexOf("++") != -1) {
                        tmp = tmp.substring(tmp.indexOf("++"), tmp.lastIndexOf("++") + 2);
                        
                        int res;
                        
                        if (map.containsKey(tmp)) {
                            res = map.get(tmp);
                        }
                        else {
                            res = canWinPack(tmp);
                            map.put(tmp, res);
                        }
                        
                        if (res == -1) {
                            win++;
                        }
                        else if (res == 0) {
                            tie++;
                        }
                        else {
                            lose++;
                        }                        
                    }
                    else {
                        win++;
                    }

                }
            }
            
            if (win != 0) {
                return 1;
            }
            else if (tie != 0) {
                return 0;
            }
            else {
                return -1;
            }
            
        }
    }
}
