/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void middle_order(TreeNode* root, vector<int>& vec){
        if(root!=NULL){
            middle_order(root->left,vec);
            vec.push_back(root->val);
            middle_order(root->right,vec);
        }
    }
    
    int getMinimumDifference(TreeNode* root) {
        vector<int> sorted;
        int i,result;
        
        middle_order(root,sorted);
    
        result=sorted[1]-sorted[0];
        for(i=2;i<sorted.size();++i){
            if((sorted[i]-sorted[i-1])<result){
                result=sorted[i]-sorted[i-1];
            }
        }
        
        return result;
    }
};
