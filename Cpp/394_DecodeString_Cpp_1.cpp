class Solution {
public:
    int string2int(string s){
        int i,result=0;
        for(i=0;i<s.size();++i){
            result=result*10+s[i]-'0';
        }
        return result;
    }
    string decodeString(string s) {
        string result;
        int i,num=0,sign=0,pos,j;
        
        for(i=0;i<s.size();++i){
            if(s[i]<='9' and s[i]>='0'){
                num=num*10+s[i]-'0';
            }
            else if(s[i]=='['){
                sign=1;
                i++;
                pos=i;
                while(sign!=0){
                    if(s[i]=='['){
                        sign++;
                    }
                    else if(s[i]==']'){
                        sign--;
                    }
                    i++;
                }
                for(j=0;j<num;++j){
                    result+=decodeString(s.substr(pos,i-pos-1));
                }
                i--;
                num=0;
            }
            else{
                result+=s[i];
            }
        }
        return result;
    }
};
