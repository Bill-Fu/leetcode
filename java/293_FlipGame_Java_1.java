class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        
        for (int i = 1; i < charArray.length; ++i) {
            if (charArray[i] == '+' && charArray[i - 1] == '+') {
                charArray[i] = '-';
                charArray[i - 1] = '-';
                result.add(new String(charArray));
                charArray[i] = '+';
                charArray[i - 1] = '+';
            }
        }
        
        return result;
    }
}
