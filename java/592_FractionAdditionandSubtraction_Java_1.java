class Solution {
    public String fractionAddition(String expression) {
        String[] nums = expression.split("\\+|-");
        String[] ops = expression.split("\\d*/\\d*");
        
        int[] numerator = new int[nums.length];
        int[] denominator = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i].equals("")) {
                numerator[i] = 0;
                denominator[i] = 1;
            }
            else {
                numerator[i] = Integer.parseInt(nums[i].split("/")[0]);
                denominator[i] = Integer.parseInt(nums[i].split("/")[1]);                
            }
        }
        
        int numRes = 0;
        int denoRes = 1;
        
        if (ops.length == 0) {
            numRes = numerator[0];
            denoRes = denominator[0];
        }
        else if (nums.length == ops.length) {
            numRes = numerator[0];
            denoRes = denominator[0];
            
            for (int i = 1; i < numerator.length; ++i) {
                if (ops[i].equals("+")) {
                    int tmpDeno = denoRes * denominator[i];
                    int tmpNum = numRes * denominator[i] + numerator[i] * denoRes;

                    numRes = tmpNum;
                    denoRes = tmpDeno;
                }
                else {
                    int tmpDeno = denoRes * denominator[i];
                    int tmpNum = numRes * denominator[i] - numerator[i] * denoRes;

                    numRes = tmpNum;
                    denoRes = tmpDeno;                
                }                
            }
        }
        else {
            for (int i = 1; i < numerator.length; ++i) {
                if (ops[i - 1].equals("+")) {
                    int tmpDeno = denoRes * denominator[i];
                    int tmpNum = numRes * denominator[i] + numerator[i] * denoRes;

                    numRes = tmpNum;
                    denoRes = tmpDeno;
                }
                else {
                    int tmpDeno = denoRes * denominator[i];
                    int tmpNum = numRes * denominator[i] - numerator[i] * denoRes;

                    numRes = tmpNum;
                    denoRes = tmpDeno;                
                }
            }            
        }
        
        // return Integer.toString(ops.length) + Integer.toString(nums.length);
        
        if (numRes == 0) {
            return "0/1";
        }
        else {
            int max = Math.max(Math.abs(numRes), denoRes);
            int min = Math.min(Math.abs(numRes), denoRes);

            while (max % min != 0) {
                int tmp = max % min;
                max = min;
                min = tmp;
            }

            return Integer.toString(numRes / min) + "/" + Integer.toString(denoRes / min);            
        }
        
    }
}
