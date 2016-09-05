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
    void rightSideViewPack(TreeNode* root,vector<vector<int>>& result,int level){
        vector<int> tmp;
        if(root==NULL)return;
        if(level>result.size())
        {
            result.push_back(tmp);
        }
        result[level-1].push_back(root->val);
        rightSideViewPack(root->left,result,level+1);
        rightSideViewPack(root->right,result,level+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<vector<int>> result;
        vector<int> res;
        int i;
        if(root==NULL)return res;
        rightSideViewPack(root,result,1);
        
        for(i=0;i<result.size();++i)
        {
            res.push_back(result[i][result[i].size()-1]);
        }
        return res;
    }
};
