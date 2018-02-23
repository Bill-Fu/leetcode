class Solution {
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        Tier root = new Tier();
        
        for (int num: nums) {
            int[] bits = conv2bits(num);
            Tier tmp = root;
            
            for (int i = 0; i < bits.length; ++i) {
                if (bits[i] == 0) {
                    if (tmp.bits[0] == null) {
                        tmp.bits[0] = new Tier();
                    }
                    
                    tmp = tmp.bits[0];
                }
                else {
                    if (tmp.bits[1] == null) {
                        tmp.bits[1] = new Tier();
                    }
                    
                    tmp = tmp.bits[1];
                }
            }
            
            tmp.num = num;
            
            tmp = root;
            
            for (int i = 0; i < bits.length; ++i) {
                if (bits[i] == 0) {
                    if (tmp.bits[1] == null) {
                        tmp = tmp.bits[0];
                    }
                    else {
                        tmp = tmp.bits[1];
                    }
                }
                else {
                    if (tmp.bits[0] == null) {
                        tmp = tmp.bits[1];
                    }
                    else {
                        tmp = tmp.bits[0];
                    }
                }
            }
            
            result = Math.max(result, tmp.num ^ num);
        }
        
        return result;
    }
    
    public int[] conv2bits(int num) {
        int[] bits = new int[31];
        
        for (int i = bits.length - 1; i >= 0; --i) {
            bits[i] = (num % 2);
            num = num / 2;
        }
        
        return bits;
    }
}

class Tier {
    Tier[] bits;
    int num = -1;
    
    public Tier() {
        bits = new Tier[2];
    }
}
