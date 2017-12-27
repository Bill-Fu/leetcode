class Solution {
    public String complexNumberMultiply(String a, String b) {
        int aReal = Integer.parseInt(a.split("\\+|i")[0]);
        int aImag = Integer.parseInt(a.split("\\+|i")[1]);
        int bReal = Integer.parseInt(b.split("\\+|i")[0]);
        int bImag = Integer.parseInt(b.split("\\+|i")[1]);
        
        int resReal = aReal * bReal - aImag * bImag;
        int resImag = aReal * bImag + bReal * aImag;
        
        return String.valueOf(resReal) + "+" + String.valueOf(resImag) + "i";
    }
}
