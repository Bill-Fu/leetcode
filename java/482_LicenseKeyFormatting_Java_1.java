class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] charArr = S.toCharArray();
        int count = 0;
        
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] != '-') {
                count++;
                if (charArr[i] - 'a' >= 0 && charArr[i] - 'a' < 26) {
                    charArr[i] = (char)(charArr[i] - 'a' + 'A');
                }
            }
        }
        
        count = (count % K == 0)? (count + (count / K) - 1): (count + (count / K));
        
        if (count <= 0) {
            return "";
        }
        else {
            char[] result = new char[count];
            int pos = charArr.length - 1;

            for (int i = result.length - 1; i >= 0; --i) {
                if ((result.length -1 - i) % (K + 1) == K) {
                    result[i] = '-';
                }
                else {
                    while (charArr[pos] == '-') {
                        pos--;
                    }
                    result[i] = charArr[pos];
                    pos--;
                }
            }

            return new String(result);            
        }
    }
}
