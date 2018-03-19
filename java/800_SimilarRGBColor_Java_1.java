class Solution {
    public String similarRGB(String color) {
        String result = "#";
        String[] hexs = new String[3];
        
        for (int i = 0; i < 3; ++i) {
            hexs[i] = color.substring(1 + 2 * i, 3 + 2 * i);
        }
        
        for (int i = 0; i < 3; ++i) {
            result += findMostSimilar(hexs[i]);
        }
        
        return result;
    }
    
    public String findMostSimilar(String color) {
        String[] table = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};
        int min = Integer.MAX_VALUE;
        String result = "";
        
        for (String str: table) {
            if (Math.pow(hex2int(str) - hex2int(color) , 2) < min) {
                min = (int) Math.pow(hex2int(str) - hex2int(color) , 2);
                result = str;
            }
        }
        
        return result;
    }
    
    public int hex2int(String hex) {
        int result = 0;
        
        for (char c: hex.toCharArray()) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                result = 16 * result + (c - '0');
            }
            else {
                result = 16 * result + 10 + (c - 'a');
            }
        }
        
        return result;
    }
}
