//Dynamic Programming 
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        vector<int> diff;
        int i,record,tmp,result=0;
        
        if(A.size()<3)return 0;
        else{
            for(i=1;i<A.size();++i){
                diff.push_back(A[i]-A[i-1]);
            }
            tmp=diff[0];
            record=1;
            for(i=1;i<diff.size();++i){
                if(diff[i]==tmp){
                    result+=record;
                    record++;
                }
                else{
                    tmp=diff[i];
                    record=1;
                }
            }
            return result;
        }
    }
};
