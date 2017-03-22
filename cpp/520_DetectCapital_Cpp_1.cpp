/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/
class Solution {
public:
    bool detectCapitalUse(string word) {
        int i;
        
        if((word[0]-'a')>=0 and (word[0]-'a')<=25){
            for(i=1;i<word.length();++i){
                if((word[i]-'a')<0 or (word[i]-'a')>25){
                    return false;
                }
            }
        }
        else{
            if(word.length()<2){
                return true;
            }
            else{
                if((word[1]-'a')>=0 and (word[1]-'a')<=25){
                    for(i=2;i<word.length();++i){
                        if((word[i]-'a')<0 or (word[i]-'a')>25){
                            return false;
                        }
                    }
                }
                else{
                    for(i=2;i<word.length();++i){
                        if((word[i]-'a')>=0 and (word[i]-'a')<=25){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};
