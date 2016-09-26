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
    void sumOfLeftLeaves(TreeNode* root,int& Sum){
        if(root==NULL)return;
        if(root->left!=NULL){
            if(root->left->left==NULL and root->left->right==NULL)Sum+=root->left->val;
            else{
                sumOfLeftLeaves(root->left,Sum);
            }
        }
        sumOfLeftLeaves(root->right,Sum);
    }
    int sumOfLeftLeaves(TreeNode* root) {
        int Sum=0;
        sumOfLeftLeaves(root,Sum);
        return Sum;
    }
};
