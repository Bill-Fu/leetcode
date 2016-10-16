//Backtracking
class Solution {
public:
    vector<int> lexicalOrder(int n) {
        int current,i;
        vector<int> result;
        
        current=1;
        
        for(i=0;i<n;++i){
            result.push_back(current);
            if(current*10<=n){
                current=current*10;
            }
            else if(current+1<=n){
                current++;
                while(current%10==0){
                    current=current/10;
                }
            }
            else{
                current=current/10+1;
                while(current%10==0){
                    current=current/10;
                }
            }
        }
        
        return result;
    }
};
