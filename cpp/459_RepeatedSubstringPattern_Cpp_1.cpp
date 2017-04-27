class Solution {
public:
    bool repeatedSubstringPatternPack(string sub, string res) {
        int i;
        
        if(sub.length() > res.length()) {
            return false;
        }
        
        if(sub.length()!=1 and res.length()%sub.length()!=0) {
            return false;
        }
        
        if(sub==res) {
            return true;
        }
        else {
            for(i=0;i<res.length()/sub.length();++i) {
                if(sub!=res.substr(i*sub.length(), sub.length())) {
                    return false;
                }
            }
            
            return true;
        }
    }

    bool repeatedSubstringPattern(string s) {
        string tmp;
        int i;
        
        if(s.length()<2) {
            return false;
        }
        else {
            for(i=1;i<s.length();++i) {
                tmp=s.substr(0, i);
                if(repeatedSubstringPatternPack(tmp, s)){
                    return true;
                }
            }
        }
        
        return false;
    }
};
