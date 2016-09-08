class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.size()==0)return 0;
        if(grid[0].size()==0)return 0;
        
        vector<vector<int>> result;
        vector<int> emptyVec;
        int i,j;
        
        for(i=0;i<grid[0].size();++i){
            emptyVec.push_back(0);
        }
        for(i=0;i<grid.size();++i){
            result.push_back(emptyVec);
        }
        
        result[0][0]=grid[0][0];
        for(i=1;i<result[0].size();++i){
            result[0][i]=result[0][i-1]+grid[0][i];
        }
        for(i=1;i<result.size();++i){
            result[i][0]=result[i-1][0]+grid[i][0];
        }
        
        for(i=1;i<result.size();++i){
            for(j=1;j<result[i].size();++j){
                if(result[i-1][j]<result[i][j-1]){
                    result[i][j]=result[i-1][j]+grid[i][j];
                }
                else{
                    result[i][j]=result[i][j-1]+grid[i][j];
                }
            }
        }
        return result[result.size()-1][result[0].size()-1];
    }
};
