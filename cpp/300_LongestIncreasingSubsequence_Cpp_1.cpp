class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> tmp;
        int i,j,k,p;
        int MIN_Seq,MAX_len=0;
        
        if(nums.size()==0)return 0;
        tmp.push_back(nums[0]);
        result.push_back(tmp);
        MIN_Seq=nums[0];
        
        for(i=1;i<nums.size();++i){
            if(nums[i]<MIN_Seq){
                tmp.clear();
                tmp.push_back(nums[i]);
                result.push_back(tmp);
                MIN_Seq=nums[i];
            }
            else{
                for(j=0;j<result.size();++j){
                    if(nums[i]>result[j][result[j].size()-1]){
                        result[j].push_back(nums[i]);
                    }
                    else if(nums[i]<=result[j][0]){
                        continue;
                    }
                    else if(nums[i]>result[j][result[j].size()-2]){
                        result[j][result[j].size()-1]=nums[i];
                    }
                    else{
                        for(k=result[j].size()-2;k>=0;--k){
                            if(result[j][k]<nums[i]){
                                break;
                            }
                        }
                        tmp.clear();
                        for(p=0;p<=k;++p){
                            tmp.push_back(result[j][p]);
                        }
                        tmp.push_back(nums[i]);
                        result.push_back(tmp);
                    }
                }
            }
        }
        
        for(i=0;i<result.size();++i){
            if(result[i].size()>MAX_len){
                MAX_len=result[i].size();
            }
        }
        
        return MAX_len;
    }
};
