class Solution {
public:
    int findLUSlength(string a, string b) {
        int result;
        
        if(a.length()>b.length()){
            result=a.length();
        }
        else if(b.length()>a.length()){
            result=b.length();
        }
        else{
            if(a==b){
                result=-1;
            }
            else{
                result=a.length();
            }
        }
        
        return result;
    }
};
