class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> result;
        int i,j;
        
        for(i=0;i<=target;++i)
        {
            result.push_back(0);
        }
        result[0]++;
        
        for(i=1;i<=target;++i)
        {
            for(j=0;j<nums.size();++j)
            {
                if(nums[j]<=i)
                {
                    result[i]+=result[i-nums[j]];
                }
            }
        }
        return result[target];
    }
};
