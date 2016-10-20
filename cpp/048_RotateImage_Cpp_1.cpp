class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int i,j,SIZE=matrix.size();
        vector<int> tmp(SIZE,0);
        vector<vector<int>> tmpResult(SIZE,tmp);
        
        for(i=0;i<SIZE;++i){
            for(j=0;j<SIZE;++j){
                tmpResult[j][SIZE-1-i]=matrix[i][j];
            }
        }
        
        matrix=tmpResult;
    }
};
