const string Three="Fizz";
const string Five="Buzz";
const string Three_Five="FizzBuzz";
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> result;
        int i;
        
        for(i=1;i<=n;i++){
            if(i%3==0 and i%5==0){
                result.push_back(Three_Five);
            }
            else if(i%3==0){
                result.push_back(Three);
            }
            else if(i%5==0){
                result.push_back(Five);
            }
            else{
                result.push_back(to_string(i));
            }
        }
        
        return result;
    }
};
