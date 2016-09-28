class Solution {
public:
    vector<pair<int, int>> reconstructQueue(vector<pair<int, int>>& people) {
        vector<pair<int,int>> Stack,result;
        pair<int,int> tmp;
        
        //first sort the vector in ascending order, better use user-defined comparison function
        sort(people.begin(),people.end());
        
        
        while(people.size()!=0){
            //take one element from the bottom of the vector and push it into Stack
            Stack.clear();
            tmp=people[people.size()-1];
            people.pop_back();
            Stack.push_back(tmp);
            //take all the elements with the same height from the vector and push them into Stack
            while(people.size()!=0 and people[people.size()-1].first==Stack[0].first){
                tmp=people[people.size()-1];
                people.pop_back();
                Stack.push_back(tmp);
            }
            //put each element in the Stack to its proper position by their 'k'
            while(Stack.size()!=0){
                tmp=Stack[Stack.size()-1];
                Stack.pop_back();
                result.insert(result.begin()+tmp.second,tmp);
            }
        }
        return result;
    }
};
