class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int pos;
        while(ransomNote.length())
        {
            pos=magazine.find(ransomNote[0]);
            if(pos==-1)
            {
                return false;
            }
            else
            {
                ransomNote=ransomNote.erase(0,1);
                magazine=magazine.erase(pos,1);
            }
        }
        return true;
    }
};
