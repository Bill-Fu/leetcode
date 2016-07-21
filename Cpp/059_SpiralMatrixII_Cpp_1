class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> result;
        vector<int> tmp;
        int i,j,x=0,y=0;
        
        for(i=0;i<n;++i){
            result.push_back(tmp);
        }
        
        for(i=0;i<n;++i){
            for(j=0;j<n;++j){
                result[i].push_back(0);
            }
        }
        
        i=0;
        
        while(i<n*n){
            while(y<n and result[x][y]==0){
                i++;
                result[x][y]=i;
                y++;
            }
            x++;
            y--;
            while(x<n and result[x][y]==0){
                i++;
                result[x][y]=i;
                x++;
            }
            x--;
            y--;
            while(y>=0 and result[x][y]==0){
                i++;
                result[x][y]=i;
                y--;
            }
            x--;
            y++;
            while(x>=0 and result[x][y]==0){
                i++;
                result[x][y]=i;
                x--;
            }
            x++;
            y++;
        }
        
        return result;
    }
};
