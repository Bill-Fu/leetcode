/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
*/
class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& nums) {
        vector<string> result;
        vector<int> sorted;
        map<int,int> map_rank;
        int i;
        
        // Copy all the numbers in the nums vector to sorted vector
        for(i=0;i<nums.size();++i){
            sorted.push_back(nums[i]);
        }
        
        sort(sorted.begin(),sorted.end(),greater<int>());
        
        for(i=0;i<sorted.size();++i){
            map_rank[sorted[i]]=i+1;
        }
        
        for(i=0;i<nums.size();++i){
            switch(map_rank[nums[i]]){
                case 1:
                    result.push_back("Gold Medal");
                    break;
                case 2:
                    result.push_back("Silver Medal");
                    break;
                case 3:
                    result.push_back("Bronze Medal");
                    break;
                default:
                    result.push_back(to_string(map_rank[nums[i]]));
                    break;
            }
        }
        
        return result;
    }
};
