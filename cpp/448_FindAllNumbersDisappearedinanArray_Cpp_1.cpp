class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        int tmp;
        
        for(int i=0;i<nums.size();++i){
            while(nums[i]!=nums[nums[i]-1]){
                tmp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=tmp;
            }
        }
        
        for(int i=0;i<nums.size();++i){
            if(nums[i]!=i+1){
                result.push_back(i+1);
            }
        }
        
        return result;
    }
};
