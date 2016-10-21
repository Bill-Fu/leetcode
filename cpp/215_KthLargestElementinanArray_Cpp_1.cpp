//Max_Heap
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int>> result;
        int i;
        
        for(i=0;i<k;++i){
            result.push(nums[i]);
        }
        
        for(;i<nums.size();++i){
            if(nums[i]>result.top()){
                result.push(nums[i]);
                result.pop();
            }
        }
        
        return result.top();
    }
};
