class Solution {
public:
    vector<int> origin;
    Solution(vector<int> nums) {
        origin=nums;
        //origin.resize(nums.size());
        //memcpy(&origin[0],&nums[0],nums.size()*sizeof(int));
        srand(time(NULL));
    }
    
    /** Resets the array to its original configuration and return it. */
    vector<int> reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    vector<int> shuffle() {
        int i,n;
        vector<int> result=origin;
        
        for(i=0;i<result.size();++i)
        {
            n=rand()%(result.size()-i);
            swap(result[i],result[i+n]);
        }
        
        return result;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * vector<int> param_1 = obj.reset();
 * vector<int> param_2 = obj.shuffle();
 */
