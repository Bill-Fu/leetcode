class Solution {
public:
    int longestPalindrome(string s) {
        vector<int> array(58,0);
        int i,result=0,max_odd=0;
        
        for(i=0;i<s.length();++i){
            array[s[i]-'A']++;
        }
        
        for(i=0;i<array.size();++i){
            if(array[i]%2==0){
                result+=array[i];
            }
            else{
                result+=array[i]-1;
                max_odd=1;
            }
        }
        result+=max_odd;
        return result;
    }
};
