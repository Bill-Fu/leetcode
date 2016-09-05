class Solution {
public:
    int longestSubstring(string s, int k) {
        int length=0;
        int i,tmplen;
        
        vector<int> used;
        vector<int> pos;
        
        for(i=0;i<26;++i){
            used.push_back(0);
        }
        
        for(i=0;i<s.size();++i){
            used[s[i]-'a']++;
        }
        
        pos.push_back(-1);
        for(i=0;i<s.size();++i){
            if(used[s[i]-'a']<k){
                pos.push_back(i);
            }
        }
        
        if(pos.size()==1){
            return s.size();
        }
        else if(pos.size()==s.size()+1){
            return 0;
        }
        else{
            for(i=0;i<pos.size()-1;++i){
                tmplen=longestSubstring(s.substr(pos[i]+1,pos[i+1]-pos[i]-1),k);
                if(tmplen>length){
                    length=tmplen;
                }
            }
            return length;
        }
    }
};
