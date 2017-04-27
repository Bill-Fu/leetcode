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
    void pathSumNode(TreeNode* root, int sum, int curr, int& res) {
        if(root!=NULL) {
            curr+=root->val;
            if(curr==sum) {
                res++;
            }
            pathSumNode(root->left, sum, curr, res);
            pathSumNode(root->right, sum, curr, res);
        }
    }

    void pathSumPack(TreeNode* root, int sum, int& res) {
        if(root!=NULL) {
            pathSumNode(root, sum, 0, res);
            pathSumPack(root->left, sum, res);
            pathSumPack(root->right, sum, res);
        }
    }

    int pathSum(TreeNode* root, int sum) {
        int result=0;
        
        pathSumPack(root, sum, result);
        
        return result;
    }
};
