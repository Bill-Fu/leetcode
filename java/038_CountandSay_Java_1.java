class Solution {
    public String countAndSay(int n) {
        String result = "1";
        String next = "";
        char[] table;
        
        for (int i = 1; i < n; ++i) {
            table = result.toCharArray();
            char tmp = table[0];
            int count = 0;
            next = "";
            for (int j = 0; j < table.length; ++j) {
                if (table[j] == tmp) {
                    count++;
                }
                else {
                    next += Integer.toString(count);
                    next += tmp;
                    tmp = table[j];
                    count = 1;
                }
            }
            next += Integer.toString(count);
            next += tmp;
            result = next;
        }
        
        return result;
    }
}
