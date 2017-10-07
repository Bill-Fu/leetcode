class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int first = 0, second = numbers.length - 1;
        
        while (numbers[first] + numbers[second] != target) {
            if (numbers[first] + numbers[second] < target) {
                first++;
            }
            else {
                second--;
            }
        }
        
        result[0] = first + 1;
        result[1] = second + 1;
        
        return result;
    }
}
