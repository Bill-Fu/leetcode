class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        
        int width = (int) Math.sqrt(area);
        
        while (area % width != 0) {
            width--;
        }
        
        result[0] = area / width;
        result[1] = width;
        
        return result;
    }
}
