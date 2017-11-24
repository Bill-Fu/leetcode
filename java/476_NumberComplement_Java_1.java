class Solution {
    public int findComplement(int num) {
        return (int) (Math.pow(2, (int) (Math.log(num) / Math.log(2)) + 1) - 1 - num);
    }
}
