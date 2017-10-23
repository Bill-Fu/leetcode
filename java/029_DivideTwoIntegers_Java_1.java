class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        else if (divisor == 1) {
            return dividend;
        }
        else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            else {
                return -dividend;
            }
        }
        else {
            if (dividend == 0) {
                return 0;
            }
            else {
                boolean sign = true;
                long divid = dividend;
                long divis = divisor;
                long result = 0;
                
                if (divid > 0 && divis < 0 || divid < 0 && divis > 0) {
                    sign = false;
                }
                
                divid = Math.abs(divid);
                divis = Math.abs(divis);
                
                List<Long> table = new ArrayList<>();
                
                long tmp = divis;
                while (tmp <= divid) {
                    table.add(tmp);
                    tmp = tmp + tmp;
                }
                
                for (int i = table.size() - 1; i >= 0; --i) {
                    if (divid >= table.get(i)) {
                        result = result + result + 1;
                        divid = divid - table.get(i);
                    }
                    else {
                        result = result + result;
                    }
                }
                
                if (sign == false) {
                    result = - result;
                }
                
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return (int) result;
                }
            }
        }
    }
}
