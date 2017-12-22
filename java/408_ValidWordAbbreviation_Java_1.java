class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] charArrWord = word.toCharArray();
        char[] charArrAbbr = abbr.toCharArray();
        int posWord = 0;
        int posAbbr = 0;
        int count = 0;
        
        while (posAbbr < charArrAbbr.length && posWord < charArrWord.length) {
            if (charArrAbbr[posAbbr] - '0' >= 0 && charArrAbbr[posAbbr] - '0' <= 9) {
                if (charArrAbbr[posAbbr] == '0') {
                    return false;
                }
                else {
                    while (posAbbr < charArrAbbr.length && charArrAbbr[posAbbr] - '0' >= 0 && charArrAbbr[posAbbr] - '0' <= 9) {
                        count = 10 * count + charArrAbbr[posAbbr] - '0';
                        posAbbr++;
                    }
                    posWord += count;                    
                }
            }
            else {
                count = 0;
                if (charArrAbbr[posAbbr++] != charArrWord[posWord++]) {
                    return false;
                }
            }
        }
        
        return posAbbr == charArrAbbr.length && posWord == charArrWord.length;
    }
}
