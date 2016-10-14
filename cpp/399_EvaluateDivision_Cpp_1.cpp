//BFS
class Solution {
public:
    vector<double> calcEquation(vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries) {
        map<string,map<string,double>> dict;
        map<string,double> tmpMap,MAP;
        map<string,map<string,double>>::iterator iter1;
        map<string,double>::iterator iter2,iter3;
        vector<double> result;
        int i,SIZE;
        
        for(i=0;i<equations.size();++i){
            if(dict.find(equations[i].first)==dict.end()){
                tmpMap.clear();
                tmpMap[equations[i].second]=values[i];
                dict[equations[i].first]=tmpMap;
            }
            else{
                tmpMap=dict[equations[i].first];
                tmpMap[equations[i].second]=values[i];
                dict[equations[i].first]=tmpMap;
            }
            
            if(dict.find(equations[i].second)==dict.end()){
                tmpMap.clear();
                tmpMap[equations[i].first]=1/values[i];
                dict[equations[i].second]=tmpMap;
            }
            else{
                tmpMap=dict[equations[i].second];
                tmpMap[equations[i].first]=1/values[i];
                dict[equations[i].second]=tmpMap;
            }            
            
        }     
        for(i=0;i<queries.size();++i){
            if(dict.find(queries[i].first)==dict.end() or dict.find(queries[i].second)==dict.end()){
                result.push_back(-1);
            }
            else{
                MAP.clear();
                for(iter2=dict[queries[i].first].begin();iter2!=dict[queries[i].first].end();iter2++){
                    MAP[iter2->first]=iter2->second;
                }
                if(MAP.find(queries[i].second)!=MAP.end()){
                    result.push_back(MAP[queries[i].second]);
                }
                else{
                    do{
                        SIZE=MAP.size();
                        for(iter2=MAP.begin();iter2!=MAP.end();iter2++){
                            for(iter3=dict[iter2->first].begin();iter3!=dict[iter2->first].end();iter3++){
                                if(MAP.find(iter3->first)==MAP.end()){
                                    MAP[iter3->first]=iter2->second*iter3->second;
                                }
                            }
                        }
                    }while(MAP.size()!=SIZE and MAP.find(queries[i].second)==MAP.end());
                    if(MAP.size()==SIZE){
                        result.push_back(-1);
                    }
                    else{
                        result.push_back(MAP[queries[i].second]);
                    }
                }
            }
        }
        
        return result;
    }
};
