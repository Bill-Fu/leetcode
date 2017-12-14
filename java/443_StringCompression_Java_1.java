class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        else {
            char cur = chars[0];
            int ptr1 = 0;
            int count = 1;
            
            for (int i = 1; i < chars.length; ++i) {
                if (chars[i] == cur) {
                    count++;
                }
                else {
                    if (count == 1) {
                        chars[ptr1++] = cur;
                    }
                    else {
                        chars[ptr1++] = cur;
                        char[] tmp = Integer.toString(count).toCharArray();
                        
                        for (int j = 0; j < tmp.length; ++j) {
                            chars[ptr1++] = tmp[j];
                        }
                    }
                    cur = chars[i];
                    count = 1;
                }
            }
            
            if (count == 1) {
                chars[ptr1++] = cur;
            }
            else {
                chars[ptr1++] = cur;
                char[] tmp = Integer.toString(count).toCharArray();

                for (int j = 0; j < tmp.length; ++j) {
                    chars[ptr1++] = tmp[j];
                }
            }
            
            return ptr1;
        }
    }
}
