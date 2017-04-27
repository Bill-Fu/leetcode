class Solution {
public:
    bool checkRecord(string s) {
        int A_num=0,L_num=0;
        int i;
        
        for(i=0;i<s.length();++i){
            switch(s[i]){
                case 'A':
                    A_num++;
                    L_num=0;
                    if(A_num>1){
                        return false;
                    }
                    break;
                case 'L':
                    L_num++;
                    if(L_num>2){
                        return false;
                    }
                    break;
                case 'P':
                    L_num=0;
                    break;
            }
        }
        
        return true;
    }
};
