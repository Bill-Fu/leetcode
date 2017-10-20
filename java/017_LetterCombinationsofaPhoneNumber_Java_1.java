class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits.length() == 0) {
            return result;
        }
        
        letterCombinations(digits, result, "");
        
        return result;
    }
    
    private void letterCombinations(String digits, List<String> result, String current) {
        if (digits.length() == 0) {
            result.add(current);
        }
        else {
            switch(digits.charAt(0) - '0') {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("a"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("b"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("c"));
                    break;
                case 3:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("d"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("e"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("f"));
                    break;
                case 4:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("g"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("h"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("i"));                    
                    break;
                case 5:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("j"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("k"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("l"));
                    break;
                case 6:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("m"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("n"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("o"));
                    break;
                case 7:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("p"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("q"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("r"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("s"));
                    break;
                case 8:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("t"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("u"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("v"));
                    break;
                case 9:
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("w"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("x"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("y"));
                    letterCombinations(digits.substring(1, digits.length()), result, current.concat("z"));
                    break;
            }
        }
    }
}
