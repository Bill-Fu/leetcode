/*
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
*/
class Solution {
public:
    string convertToBase7(int num) {
        string result;
        bool sign=false;
        
        if(num==0){
            return "0";
        }
        
        if(num<0){
            sign=true;
            num=-num;
        }
        
        while(num!=0){
            result=to_string(num%7)+result;
            num=num/7;
        }
        
        if(sign){
            result="-"+result;
        }
        
        return result;
        
    }
};
