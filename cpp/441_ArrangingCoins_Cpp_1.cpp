class Solution {
public:
    int arrangeCoins(int n) {
        long result=n;
        result=long(sqrt(2*result));
        if(result*(result+1)/2<=n){
            return result;
        }
        else{
            return result-1;
        }
    }
};
