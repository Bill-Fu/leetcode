class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '(' :
                case '{' :
                case '[' :
                    stack.push(s.charAt(i));
                    break;
                case ')' :
                    if (stack.empty() == true || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}' :
                    if (stack.empty() == true || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']' :
                    if (stack.empty() == true || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        
        if (stack.empty() == true) {
            return true;
        }
        else {
            return false;
        }
    }
}
