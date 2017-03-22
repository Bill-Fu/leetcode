/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/
class Solution {
public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        priority_queue<int> stack;
        vector<vector<int>> map;
        vector<int> tmp;
        int i,j,result=0,dist,cnt;
        bool flag;
        
        for(i=0;i<points.size();++i){
            for(j=0;j<points.size();++j){
                dist=(points[i].first-points[j].first)*(points[i].first-points[j].first)+(points[i].second-points[j].second)*(points[i].second-points[j].second);
                stack.push(dist);
            }
            
            tmp.clear();
            
            for(j=0;j<points.size();++j){
                tmp.push_back(stack.top());
                stack.pop();
            }
            
            map.push_back(tmp);
        }
        
        for(i=0;i<map.size();++i){
            flag=false;
            cnt=0;
            for(j=1;j<map[i].size();++j){
                if(flag){
                    if(map[i][j]==map[i][j-1]){
                        flag=true;
                        cnt++;
                    }
                    else{
                        flag=false;
                        result+=cnt*(cnt+1);
                        cnt=0;
                    }
                }
                else{
                    if(map[i][j]==map[i][j-1]){
                        flag=true;
                        cnt++;
                    }
                    else{
                        flag=false;
                        cnt=0;
                    }
                }
            }
            
            if(flag){
                result+=cnt*(cnt+1);
            }
        }
        
        return result;
    }
};
