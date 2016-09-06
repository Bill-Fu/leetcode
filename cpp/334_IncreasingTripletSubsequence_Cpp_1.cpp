class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> tmp;
        int i;
        int position=1;
        
        result.push_back(tmp);
        result.push_back(tmp);
        
        if(nums.size()==0)return false;
        else{
            result[0].push_back(nums[0]);
            for(i=1;i<nums.size();++i){
                switch(position){
                    case 1:{
                        if(nums[i]>result[0][0]){
                            result[0].push_back(nums[i]);
                            position++;
                        }
                        else{
                            result[0][0]=nums[i];
                        }
                        break;
                    }
                    case 2:{
                        if(nums[i]<result[0][0]){
                            result[1].push_back(nums[i]);
                            position++;
                        }
                        else if(result[0][0]<nums[i] and nums[i]<result[0][1]){
                            result[0][1]=nums[i];
                        }
                        else if(result[0][1]<nums[i]){
                            return true;
                        }
                        break;
                    }
                    case 3:{
                        if(result[0][1]<nums[i]){
                            return true;
                        }
                        else if(result[1][0]<nums[i]<result[0][1]){
                            result[0][0]=result[1][0];
                            result[0][1]=nums[i];
                            result[1].pop_back();
                            position--;
                        }
                        else if(nums[i]<result[1][0]){
                            result[1][0]=nums[i];
                        }
                        break;
                    }
                }
            }
            return false;
        }
    }
};
