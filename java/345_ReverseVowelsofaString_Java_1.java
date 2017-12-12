class Solution {
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int ptr1 = 0;
        int ptr2 = charArr.length - 1;
        
        while (ptr1 < ptr2) {
            if (charArr[ptr1] != 'a' && charArr[ptr1] != 'e' && charArr[ptr1] != 'i' && charArr[ptr1] != 'o' && charArr[ptr1] != 'u' && charArr[ptr1] != 'A' && charArr[ptr1] != 'E' && charArr[ptr1] != 'I' && charArr[ptr1] != 'O' && charArr[ptr1] != 'U') {
                ptr1++;
            }
            else if (charArr[ptr2] != 'a' && charArr[ptr2] != 'e' && charArr[ptr2] != 'i' && charArr[ptr2] != 'o' && charArr[ptr2] != 'u' && charArr[ptr2] != 'A' && charArr[ptr2] != 'E' && charArr[ptr2] != 'I' && charArr[ptr2] != 'O' && charArr[ptr2] != 'U') {
                ptr2--;
            }
            else {
                char tmp = charArr[ptr1];
                charArr[ptr1] = charArr[ptr2];
                charArr[ptr2] = tmp;
                ptr1++;
                ptr2--;
            }
        }
        
        return new String(charArr);
    }
}
