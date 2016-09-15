class Solution {
public:
    int maxRotateFunction(vector<int>& A) {
        int i,Sum=0,initSum=0,max;
        for(i=0;i<A.size();++i){
            initSum+=A[i];
            Sum+=i*A[i];
        }
        
        max=Sum;
        for(i=A.size()-1;i>=0;--i){
            Sum=Sum+initSum-A.size()*A[i];
            if(Sum>max)max=Sum;
        }

        return max;
    }
};
