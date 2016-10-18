//dir:0-left,1-down
//recursive
class Solution {
public:
    void countBattleships(vector<vector<char>> board,vector<vector<bool>>& used,int dir,int X,int Y){
        if(dir==0){
            for(;Y<board[X].size() and board[X][Y]=='X';++Y){
                used[X][Y]=true;
            }
        }
        else{
            for(;X<board.size() and board[X][Y]=='X';++X){
                used[X][Y]=true;
            }
        }
    }
    int countBattleships(vector<vector<char>>& board) {
        int result,i,j;
        vector<bool> tmp(board[0].size(),false);
        vector<vector<bool>> used(board.size(),tmp);
        
        result=0;
        
        for(i=0;i<board.size();++i){
            for(j=0;j<board[i].size();++j){
                if(used[i][j]==false){
                    if(board[i][j]=='X'){
                        if(j+1<board[i].size() and board[i][j+1]=='X'){
                            result++;
                            countBattleships(board,used,0,i,j+1);
                        }
                        else if(i+1<board.size() and board[i+1][j]=='X'){
                            result++;
                            countBattleships(board,used,1,i+1,j);
                        }
                        else{
                            result++;
                        }
                    }
                    used[i][j]=true;
                }
            }
        }
        
        return result;
    }
};
