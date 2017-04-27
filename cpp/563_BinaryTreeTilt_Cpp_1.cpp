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
    int sumNode(TreeNode* root) {
        int result=0;
        if(root==NULL) {
            return result;
        }
        else{
            result+=root->val;
            result+=sumNode(root->left);
            result+=sumNode(root->right);
            return result;
        }
    }
    
    void findTiltPack(TreeNode* root, int& result){
        int leftVal,rightVal;
        
        if(root==NULL){
            return;
        }
        else{
            leftVal=sumNode(root->left);
            rightVal=sumNode(root->right);
            if(leftVal>rightVal){
                result+=(leftVal-rightVal);
            }
            else{
                result+=(rightVal-leftVal);
            }
            findTiltPack(root->left,result);
            findTiltPack(root->right,result);
        }
    }
    
    int findTilt(TreeNode* root) {
        int result=0;
        
        findTiltPack(root,result);
        
        return result;
    }
};
