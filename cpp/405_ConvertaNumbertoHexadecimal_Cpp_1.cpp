class Solution {
public:
    string toHex(int num) {
        string result="";
        long tmp=num;
        if(tmp==0)return "0";
        if(tmp<0)tmp=tmp+2+INT_MAX+INT_MAX;
        while(tmp!=0){
                switch(tmp%16){
                    case 0:result="0"+result;break;
                    case 1:result="1"+result;break;
                    case 2:result="2"+result;break;
                    case 3:result="3"+result;break;
                    case 4:result="4"+result;break;
                    case 5:result="5"+result;break;
                    case 6:result="6"+result;break;
                    case 7:result="7"+result;break;
                    case 8:result="8"+result;break;
                    case 9:result="9"+result;break;
                    case 10:result="a"+result;break;
                    case 11:result="b"+result;break;
                    case 12:result="c"+result;break;
                    case 13:result="d"+result;break;
                    case 14:result="e"+result;break;
                    case 15:result="f"+result;break;
                }
                tmp=tmp/16;
            }
        return result;
    }
};

