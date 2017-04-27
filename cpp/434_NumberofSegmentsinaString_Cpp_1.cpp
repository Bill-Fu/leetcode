class Solution {
public:
    int countSegments(string s) {
        int result=0;
        int i;
        bool flag=false;
        
        for(i=0;i<s.length();++i) {
            if(s[i]==' ') {
                if(flag) {
                    result++;
                    flag=false;
                }
            }
            else {
                flag=true;
            }
        }
        
        if(flag) {
            result++;
        }
        
        return result;
    }
};
