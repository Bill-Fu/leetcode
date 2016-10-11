class Solution {
public:

    static bool myfunction (int i,int j) { 
        return (i>j);
    }
    
    bool canPartition(vector<int>& nums,vector<int> partition,int index,int Sum,int target){
        int i;
        vector<int> tmp;
        
        if(Sum==target)return true;
        else if(Sum>target)return false;
        else{
            for(i=index+1;i<nums.size();++i){
                tmp=partition;
                tmp.push_back(nums[i]);
                if(canPartition(nums,tmp,i,Sum+nums[i],target)){
                    return true;
                }
                tmp.clear();
            }
            return false;
        }
    }
    
    bool canPartition(vector<int>& nums) {
        int Sum=0,i;
        vector<int> tmp;
        
        for(i=0;i<nums.size();++i){
            Sum+=nums[i];
        }
        
        if(Sum%2)return false;
        
        sort(nums.begin(),nums.end(),myfunction);
        
        if(nums[0]>Sum/2)return false;
        else{
            for(i=0;i<nums.size()/2+1;++i){
                tmp.push_back(nums[i]);
                if(canPartition(nums,tmp,i,nums[i],Sum/2)){
                    return true;
                }
                tmp.clear();
            }
            return false;
        }
    }
};
