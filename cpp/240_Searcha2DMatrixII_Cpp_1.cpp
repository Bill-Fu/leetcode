class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size()==0)return false;
        if(matrix[0].size()==0)return false;
        int Xmin,Ymin,Xmax,Ymax;
        int tmp_min,tmp_max,tmp_mid;
        int XX,YY;
        int i,j;
        Xmin=Ymin=0;
        Xmax=matrix.size()-1;
        Ymax=matrix[0].size()-1;
        if(target<matrix[Xmin][Ymin] or target>matrix[Xmax][Ymax]){
            return false;
        }
        else if(matrix[Xmin][Ymin]==target or matrix[Xmin][Ymax]==target or matrix[Xmax][Ymin]==target or matrix[Xmax][Ymax]==target){
            return true;
        }
        else{
            if(matrix[Xmax][Ymin]<target){
                tmp_min=Ymin;
                tmp_max=Ymax;
                while(tmp_max-tmp_min>1){
                    if(matrix[Xmax][(tmp_max+tmp_min)/2]==target)return true;
                    else if(matrix[Xmax][(tmp_max+tmp_min)/2]<target){
                        tmp_min=(tmp_max+tmp_min)/2;
                    }
                    else{
                        tmp_max=(tmp_max+tmp_min)/2;
                    }
                }
                Ymin=tmp_max;
            }
            
            if(matrix[Xmin][Ymax]<target){
                tmp_min=Xmin;
                tmp_max=Xmax;
                while(tmp_max-tmp_min>1){
                    if(matrix[(tmp_max+tmp_min)/2][Ymax]==target)return true;
                    else if(matrix[(tmp_max+tmp_min)/2][Ymax]<target){
                        tmp_min=(tmp_max+tmp_min)/2;
                    }
                    else{
                        tmp_max=(tmp_max+tmp_min)/2;
                    }
                }
                Xmin=tmp_max;
            }
            
            tmp_min=Xmin;
            tmp_max=Xmax;
            while(tmp_max-tmp_min>1){
                if(matrix[(tmp_max+tmp_min)/2][Ymin]==target)return true;
                else if(matrix[(tmp_max+tmp_min)/2][Ymin]<target){
                    tmp_min=(tmp_min+tmp_max)/2;
                }
                else{
                    tmp_max=(tmp_min+tmp_max)/2;
                }
            }
            XX=tmp_min;
            
            tmp_min=Ymin;
            tmp_max=Ymax;
            while(tmp_max-tmp_min>1){
                if(matrix[Xmin][(tmp_min+tmp_max)/2]==target)return true;
                else if(matrix[Xmin][(tmp_min+tmp_max)/2]<target){
                    tmp_min=(tmp_max+tmp_min)/2;
                }
                else{
                    tmp_max=(tmp_max+tmp_min)/2;
                }
            }
            YY=tmp_min;
            if(matrix[XX][YY]==target)return true;
            else if(matrix[XX][YY]<target)return false;
            else{
                for(i=Xmin;i<=XX;++i){
                    for(j=Ymin;j<=YY;++j){
                        if(matrix[i][j]==target)return true;
                    }
                }
                return false;
            }
        }
    }
};

//自己写的代码真垃圾，又慢又长逻辑又乱
//下面是大神的算法

/*
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size();
        int col = matrix[0].size();
        int i = row-1,j =0;
        while(i>=0&&j<=col-1)
        {
            if(target>matrix[i][j])
            {
                j++;
            }
            else if(target<matrix[i][j])
            {
                i--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
};
*/
