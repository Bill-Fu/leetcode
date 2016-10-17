//really ugly, cannot find the bug in the first solution
class Solution {
public:
    string originalDigits(string s) {
        vector<int> table(10,0);
        vector<int> count(26,0);
        string result,tmp;
        result.clear();
        int i,j;
        
        for(i=0;i<s.length();++i){
            count[s[i]-'a']++;
        }
        
        table[0]=count['z'-'a'];
        table[2]=count['w'-'a'];
        table[4]=count['u'-'a'];
        table[6]=count['x'-'a'];
        table[8]=count['g'-'a'];
        table[1]=count['o'-'a']-table[0]-table[2]-table[4];
        table[3]=count['r'-'a']-table[0]-table[4];
        table[5]=count['f'-'a']-table[4];
        table[7]=count['s'-'a']-table[6];
        table[9]=count['i'-'a']-table[5]-table[6]-table[8];
        
        
        
        for(i=0;i<10;++i){
            for(j=0;j<table[i];++j){
                tmp='0'+i;
                result+=tmp;
            }
        }
        
        return result;
        
    }
};
