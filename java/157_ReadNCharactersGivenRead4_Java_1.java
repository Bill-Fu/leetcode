/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int cnt = 0;
        int readNum = 0;
        char[] tmp = new char[4];
        boolean eof = false;
        
        while (!eof && cnt < n) {
            readNum = read4(tmp);
            
            eof = readNum < 4;
            
            readNum = Math.min(readNum, n - cnt);
            
            for (int i = 0; i < readNum; ++i) {
                buf[cnt++] = tmp[i];
            }
        }
        
        return cnt;
        
    }
}
