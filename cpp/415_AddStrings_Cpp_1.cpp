class Solution {
public:
    string addStrings(string num1, string num2) {
        string result,tmp;
        int i,sum=0,carry=0,times;
        int digit1,digit2;
        for(i=0;i<num1.length() or i<num2.length();++i){
            if(i<num1.length()){
                digit1=num1[num1.length()-1-i]-'0';
            }
            else{
                digit1=0;
            }
            if(i<num2.length()){
                digit2=num2[num2.length()-1-i]-'0';
            }
            else{
                digit2=0;
            }
            sum=(digit1+digit2+carry)%10;
            carry=(digit1+digit2+carry)/10;
            tmp=sum+'0';
            result=tmp+result;
        }
        if(carry!=0){
            result='1'+result;
        }
        return result;
    }
};
