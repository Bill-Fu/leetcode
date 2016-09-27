class Solution {
public:
    void readBinaryWatch(int num,vector<int> current, vector<string>& result){
        int h=0,min=0;
        int i;
        string tmp,res;
        stringstream tmptmp;
        vector<int> cur;
        
        if(num==0){
            for(i=0;i<current.size();++i){
                switch(current[i]){
                    case 0:
                    case 1:
                    case 2:
                    case 3:h+=pow(2,current[i]);break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:min+=pow(2,current[i]-4);break;
                }
            }
            if(h<12 and min<60){
                tmptmp<<h;
                tmptmp>>tmp;
                res+=tmp;
                res+=":";
                if(min<10)res+="0";
                tmptmp.clear();
                tmp.clear();
                tmptmp<<min;
                tmptmp>>tmp;
                res+=tmp;
                result.push_back(res);
            }
        }
        else{
            if(current.size()==0){
                for(i=0;i<10;++i){
                    cur=current;
                    cur.push_back(i);
                    readBinaryWatch(num-1,cur,result);
                }
            }
            else if(current[current.size()-1]+num<10){
                for(i=current[current.size()-1]+1;i<10;++i){
                    cur=current;
                    cur.push_back(i);
                    readBinaryWatch(num-1,cur,result);
                }
            }
        }
    }
    vector<string> readBinaryWatch(int num) {
        vector<int> current;
        vector<string> result;
        readBinaryWatch(num,current,result);
        return result;
    }
};
