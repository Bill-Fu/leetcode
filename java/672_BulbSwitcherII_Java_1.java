class Solution {
    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) return 1;
        else if (m == 1) return n == 1 ? 2: n == 2 ? 3 : 4;
        else if (m == 2) return n == 1 ? 2: n == 2 ? 4 : 7;
        else return n == 1 ? 2 : n == 2 ? 4 : 8;
    }
}
