class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        map<int,int> Dict;
        vector<int> result;
        int i;
        
        for(i=0;i<numbers.size();++i)
        {
            if(Dict.find(target-numbers[i])==Dict.end())
            {
                Dict[numbers[i]]=i;
            }
            else
            {
                result.push_back(1+Dict[target-numbers[i]]);
                result.push_back(1+i);
            }
        }
        return result;
    }
};
