class Solution {
public:
    int firstUniqChar(string s) {
        map<char,int> Map;
        int i,min;
        map<char,int>::iterator l_it;
        
        for(i=0;i<s.length();++i)
        {
            l_it=Map.find(s[i]);
            if(l_it==Map.end())
            {
                Map[s[i]]=i;
            }
            else
            {
                Map[s[i]]=s.length();
            }
        }
        min=s.length();
        for(l_it=Map.begin();l_it!=Map.end();++l_it)
        {
            if(l_it->second<min)
            {
                min=l_it->second;
            }
        }
        if(min==s.length())
        {
            min=-1;
        }
        return min;
    }
};
