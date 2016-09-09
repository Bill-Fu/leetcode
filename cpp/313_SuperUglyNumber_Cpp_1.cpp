class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        if(n==1)return 1;
        priority_queue<int,vector<int>,greater<int>> Queue;
        int i,j,tmp=1;
        long int tmptmp;
        
        for(i=0;i<primes.size();++i){
            Queue.push(primes[i]);
        }
        
        for(i=1;i<n;++i){
            if(Queue.top()==tmp){
                Queue.pop();
                i--;
                continue;
            }
            tmp=Queue.top();
            for(j=0;j<primes.size();++j){
                tmptmp=tmp;
                tmptmp=tmptmp*primes[j];
                if(tmptmp<INT_MAX){
                    Queue.push(tmptmp);
                }
            }
            Queue.pop();
        }
        
        return tmp;
    }
};

//Oh my god, it's really tough to understand this solution!

/*
int nthSuperUglyNumber(int n, vector<int>& primes) {
        vector<int> index(primes.size(), 0), ugly(n, INT_MAX);
        ugly[0]=1;
        for(int i=1; i<n; i++){
            for(int j=0; j<primes.size(); j++) ugly[i]=min(ugly[i],ugly[index[j]]*primes[j]);
            for(int j=0; j<primes.size(); j++) index[j]+=(ugly[i]==ugly[index[j]]*primes[j]);
        }
        return ugly[n-1];
}
*/
