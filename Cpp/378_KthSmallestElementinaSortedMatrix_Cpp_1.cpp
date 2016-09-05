class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int result,j,i,num;
        vector<int> tmp;
        for(i=0;i<matrix.size();++i)
        {
            tmp.push_back(0);
        }
        for(i=0;i<k;++i)
        {
            for(j=0;j<matrix.size();++j)
            {
                if(tmp[j]<matrix.size())
                {
                    num=j;
                    break;
                }
            }
            for(j=0;j<matrix.size();++j)
            {
                if(tmp[j]<matrix.size() and matrix[j][tmp[j]]<matrix[num][tmp[num]])
                {
                    num=j;
                }
            }
            result=matrix[num][tmp[num]];
            tmp[num]++;
        }
        return result;
    }
};
