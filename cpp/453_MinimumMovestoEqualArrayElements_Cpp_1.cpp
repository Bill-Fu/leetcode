class Solution {
public:
    int minMoves(vector<int>& nums) {
        int min,result,i;
        //min - minimum number in the nums
        //result - the result of the solution
        //i - counter
        
        min=nums[0];
        for(i=1;i<nums.size();++i){
            if(nums[i]<min)min=nums[i];
        }
        //find the minimum number in the nums
        
        result=0;
        for(i=0;i<nums.size();++i){
            result+=nums[i]-min;
        }
        //calculate the result
        
        return result;
        
    }
};
