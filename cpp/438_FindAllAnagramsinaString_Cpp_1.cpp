class Solution {
public:
    int sumString(string s) {
        int result=0;
        
        for(int i = 0; i < s.length(); i++) {
            result += s[i] - 'a';
        }
        
        return result;
    }

    bool cmpAnagrams(string s, string p) {
        vector<int> s_cal, p_cal;
        
        for(int i = 0; i < 26; ++i) {
            s_cal.push_back(0);
            p_cal.push_back(0);
        }
        
        for(int i = 0; i < s.length(); ++i) {
            s_cal[s[i] - 'a']++;
        }
        
        for(int i = 0; i < p.length(); ++i) {
            p_cal[p[i] - 'a']++;
        }
        
        for(int i = 0; i < s_cal.size(); ++i) {
            if(s_cal[i] != p_cal[i]) {
                return false;
            }
        }
        
        return true;
    }

    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        
        if(s.length() < p.length()) {
            return result;
        }
        
        for(int i = 0; i <= s.length() - p.length(); ++i) {
            string tmp = s.substr(i, p.length());
            if(sumString(tmp) == sumString(p)) {
                if(cmpAnagrams(tmp, p)) {
                    result.push_back(i);
                }
            }
        }
        
        return result;
    }
};
