class Solution {
    public int calculate(String s) {
        List<Integer> num = new ArrayList<>();
        List<Character> operator = new ArrayList<>();
        int tmp = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            switch(s.charAt(i)) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    num.add(tmp);
                    operator.add(s.charAt(i));
                    tmp = 0;
                    break;
                case ' ' :
                    break;
                default:
                    tmp = tmp * 10 + s.charAt(i) - '0';
                    break; 
            }
        }
        num.add(tmp);
        
        int count = 0;
        
        while (count < operator.size()) {
            switch (operator.get(count)) {
                case '+':
                case '-':
                    count++;
                    break;
                case '*':
                    operator.remove(count);
                    num.set(count, num.get(count) * num.get(count + 1));
                    num.remove(count + 1);
                    break;
                case '/':
                    operator.remove(count);
                    num.set(count, num.get(count) / num.get(count + 1));
                    num.remove(count + 1);
                    break;
            }
        }
        
        count = 0;
        
        int result = num.get(0);
        
        while (count < operator.size()) {
            switch (operator.get(count)) {
                case '+':
                    result = result + num.get(count + 1);
                    count++;
                    break;
                case '-':
                    result = result - num.get(count + 1);
                    count++;
                    break;
                case '*':
                    break;
                case '/':
                    break;
            }
        }        
        
        return result;
    }
}
