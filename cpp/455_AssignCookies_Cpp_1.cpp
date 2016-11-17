class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        //difine int variable:result,i,j
        int result=0,i=0,j=0;
        
        //sort separately vector g and vector s
        sort(g.begin(),g.end(),greater<int>());
        sort(s.begin(),s.end(),greater<int>());
        
        //assign the cookies now
        while(i!=g.size() and j!=s.size()){
            //if the current gi and sj are matched, then result++, s and g move to next
            if(g[i]<=s[j]){
                result++;
                i++;
                j++;
            }
            //if the current gi and sj are not matched, then the g move to next
            else{
                i++;
            }
        }
        
        //return the result
        return result;
    }
};
