/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
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
    int height(TreeNode* root){
        if(root==NULL){
            return 0;
        }
        else{
            int lf,rt;
            lf=height(root->left);
            rt=height(root->right);
            if(lf>rt){
                return lf+1;
            }
            else{
                return rt+1;
            }
        }
    }

    int diameterOfBinaryTree(TreeNode* root) {
        int result=0;
        list<TreeNode*> lst;
        TreeNode* tmp;
        int tmptmp;
        
        if(root==NULL){
            return 0;
        }
        else{
            lst.push_back(root);
            while(lst.size()!=0){
                tmp=lst.front();
                lst.pop_front();
                tmptmp=height(tmp->left)+height(tmp->right);
                if(tmptmp>result){
                    result=tmptmp;
                }
                if(tmp->left!=NULL){
                    lst.push_back(tmp->left);
                }
                if(tmp->right!=NULL){
                    lst.push_back(tmp->right);
                }
            }
        }
        
        return result;
        
    }
};
