class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        else {
            String result = "";
            long numer = numerator, denom = denominator;
            
            if (numer > 0 && denom < 0 || numer < 0 && denom > 0) {
                result = result.concat("-");
                if (numer < 0) {
                    numer = -numer;
                }
                else {
                    denom = -denom;
                }
            }
            if (numer < 0 && denom < 0) {
                numer = -numer;
                denom = -denom;
            }
            
            result = result.concat(Long.toString(numer / denom));
            
            if (numer % denom == 0) {
                return result;
            }
            else {
                result = result.concat(".");
                
                numer = numer % denom;
                
                int loopLen = 0;
                long ptr1 = numer, ptr2 = numer;
                do {
                    ptr1 = (10 * ptr1) % denom;
                    ptr2 = (10 * ptr2) % denom;
                    ptr2 = (10 * ptr2) % denom;
                } while (ptr2 != 0 && ptr1 != ptr2);
                
                if (ptr2 == 0) {
                    while (numer != 0) {
                        result = result.concat(Long.toString((10 * numer) / denom));
                        numer = (10 * numer) % denom;
                    }
                }
                else {
                    do {
                        ptr1 = (10 * ptr1) % denom;
                        ptr2 = (10 * ptr2) % denom;
                        ptr2 = (10 * ptr2) % denom;
                        loopLen++;
                    } while ( ptr1 != ptr2);
                    
                    ptr1 = numer;
                    ptr2 = numer;
                    
                    for (int i = 0; i < loopLen; ++i) {
                        ptr2 = (10 * ptr2) % denom;
                    }
                        
                    while (ptr1 != ptr2) {
                        result = result.concat(Long.toString((10 * ptr1) / denom));
                        ptr1 = (10 * ptr1) % denom;
                        ptr2 = (10 * ptr2) % denom;
                    }
                    
                    result = result.concat("(");
                    
                    for (int i = 0; i < loopLen; ++i) {
                        result = result.concat(Long.toString((10 * ptr1) / denom));
                        ptr1 = (10 * ptr1) % denom;
                    }
                    
                    result = result.concat(")");
                }
                
                return result;
            }
        }
        
    }
}

