class Solution {
    public boolean checkRecord(String s) {
        char[] charArr = s.toCharArray();
        boolean absent = false;
        int late = 0;
        
        for (int i = 0; i < charArr.length; ++i) {
            switch (charArr[i]) {
                case 'A':
                    if (absent) {
                        return false;
                    }
                    else {
                        absent = true;
                    }
                    late = 0;
                    break;
                case 'L':
                    late++;
                    if (late > 2) {
                        return false;
                    }
                    break;
                case 'P':
                    late = 0;
                    break;
            }
        }
        
        return true;
    }
}
