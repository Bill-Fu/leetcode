class StringIterator {
    char[] charArr;
    char c;
    int count;
    int pos;
    
    public StringIterator(String compressedString) {
        charArr = compressedString.toCharArray();
        pos = 0;
        count = 0;
    }
    
    public char next() {
        if (hasNext() == false) {
            return ' ';
        }
        else {
            if (count == 0) {
                c = charArr[pos++];
                while (pos < charArr.length && charArr[pos] - '0' >= 0 && charArr[pos] - '0' <= 9) {
                    count = 10 * count + charArr[pos++] - '0';
                }
                count--;
                return c;
            }
            else {
                count--;
                return c;
            }            
        }
    }
    
    public boolean hasNext() {
        return (count != 0 || pos < charArr.length);
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
