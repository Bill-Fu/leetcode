class Solution {
public:
    string reverseWords(string s) {
        int i;
        string result="",tmp="";
        
        for(i=0;i<s.length();++i){
            if(s[i]==' '){
                result+=tmp;
                tmp="";
                result+=s[i];
            }
            else{
                tmp=s[i]+tmp;
            }
        }
        
        result+=tmp;
        
        return result;
    }
};
