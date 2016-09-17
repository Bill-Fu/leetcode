class Solution {
public:
    int integerReplacement(int n) {
        vector<long> Q1,Q2;
        int i,j;
        
        Q1.push_back(n);
        for(i=0;i<100;++i){
            for(j=0;j<Q1.size();++j){
                if(Q1[j]==1)return i;
                if(Q1[j]%2==0){
                    Q2.push_back(Q1[j]/2);
                }
                else{
                    Q2.push_back(Q1[j]+1);
                    Q2.push_back(Q1[j]-1);
                }
            }
            Q1=Q2;
            Q2.clear();
        }
        return 0;
    }
};
