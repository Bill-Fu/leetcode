class Solution {
public:
    void combinePack(int start,int n,int k,vector<int> tmp,vector<vector<int>>& result){
        vector<int> nxt;
        if(n+1-start<k)return;
        else if(k==0){
            result.push_back(tmp);
        }
        else{
            for(;start<=n;++start){
                nxt=tmp;
                nxt.push_back(start);
                combinePack(start+1,n,k-1,nxt,result);
            }
        }
    }
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        vector<int> tmp;
        combinePack(1,n,k,tmp,result);
        return result;
    }
};
