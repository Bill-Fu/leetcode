class Solution {
    public double largestTriangleArea(int[][] points) {
        double result = 0;
        
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                for (int k = j + 1; k < points.length; ++k) {
                    double a = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                    double b = Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2);
                    double c = Math.pow(points[k][0] - points[j][0], 2) + Math.pow(points[k][1] - points[j][1], 2);
                    
                    result = Math.max(result, Math.sqrt(2 * a * b + 2 * a * c + 2 * b * c - a * a - b * b - c * c) / 4);
                }
            }
        }
        
        return result;
    }
}
