/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

Note:
	1.You may use one character in the keyboard more than once.
	2.You may assume the input string will only contain letters of alphabet.
*/
class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        vector<string> result;
        map<string,int> keyboardMap;
        int count,rowIndex;
        
        // Keyboard Map Define
        string row1[]={"Q","W","E","R","T","Y","U","I","O","P","q","w","e","r","t","y","u","i","o","p"};
        string row2[]={"A","S","D","F","G","H","J","K","L","a","s","d","f","g","h","j","k","l"};
        string row3[]={"Z","X","C","V","B","N","M","z","x","c","v","b","n","m"};
        
        vector<string> row_vector1(row1,row1+20);
        vector<string> row_vector2(row2,row2+18);
        vector<string> row_vector3(row3,row3+14);
        
        for(count=0;count<row_vector1.size();count++){
            keyboardMap[row_vector1[count]]=1;
        }
        
        for(count=0;count<row_vector2.size();count++){
            keyboardMap[row_vector2[count]]=2;
        }
        
        for(count=0;count<row_vector3.size();count++){
            keyboardMap[row_vector3[count]]=3;
        }
        
        for(int i=0;i<words.size();i++){
            if(words[i].size()==0){
                result.push_back(words[i]);
            }
            else{
                rowIndex=keyboardMap[words[i].substr(0,1)];
                for(count=0;count<words[i].size();count++){
                    if(keyboardMap[words[i].substr(count,1)]!=rowIndex){
                        break;
                    }
                }
                if(count==words[i].size()){
                    result.push_back(words[i]);
                }
            }
        }
        
        return result;
    }
};
