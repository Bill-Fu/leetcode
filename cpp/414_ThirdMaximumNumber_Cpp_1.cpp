class Solution {
public:
    int thirdMax(vector<int>& nums) {
        vector<int> result;
        int i,j,tmp_max;
        
        tmp_max=nums[0];
        for(i=0;i<nums.size();++i){
            if(nums[i]>tmp_max){
                tmp_max=nums[i];
            }
        }
        result.push_back(tmp_max);
        
        for(i=0;i<2;++i){
            for(j=0;j<nums.size();++j){
                if(nums[j]<result[i]){
                    tmp_max=nums[j];
                    break;
                }
            }
            
            if(j==nums.size()){
                return result[0];
            }
            
            for(;j<nums.size();++j){
                if(nums[j]>tmp_max and nums[j]<result[i]){
                    tmp_max=nums[j];
                }
            }
            result.push_back(tmp_max);
        }
        
        return result[2];
    }
};
