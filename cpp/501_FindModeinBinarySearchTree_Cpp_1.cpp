/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
    void Traverse(TreeNode* root, map<int,int>& MMM){
        if(root!=NULL){
            if(MMM.count(root->val)==0){
                MMM[root->val]=1;
            }
            else{
                MMM[root->val]++;
            }
            Traverse(root->left, MMM);
            Traverse(root->right, MMM);
        }
    }

    vector<int> findMode(TreeNode* root) {
        map<int, int> MMM;
        int result_time=0;
        map<int, int>::iterator iter;
        vector<int> result;
        
        Traverse(root, MMM);
        
        for(iter=MMM.begin();iter!=MMM.end();iter++){
            if(iter->second>result_time){
                result_time=iter->second;
            }
        }
        
        for(iter=MMM.begin();iter!=MMM.end();iter++){
            if(iter->second==result_time){
                result.push_back(iter->first);
            }
        }
        
        return result;
    }
};
