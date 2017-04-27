class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        int result=0;
        int i;
        
        sort(nums.begin(),nums.end(),greater<int>());
        
        for(i=0;i<nums.size();++i){
            if(i%2){
                result+=nums[i];
            }
        }
        
        return result;
    }
};
