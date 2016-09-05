/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    vector<TreeNode*> Stack;
    BSTIterator(TreeNode *root) {
        if(root==NULL)return;
        else{
            Stack.push_back(root);
            while(Stack[Stack.size()-1]->left!=NULL)
            {
                Stack.push_back(Stack[Stack.size()-1]->left);
            }
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return Stack.size();
    }

    /** @return the next smallest number */
    int next() {
        int result;
        TreeNode* tmp;
        
        result=Stack[Stack.size()-1]->val;
        tmp=Stack[Stack.size()-1];
        if(tmp->right!=NULL)
        {
            Stack.push_back(tmp->right);
            tmp=tmp->right;
            while(tmp->left!=NULL)
            {
                Stack.push_back(tmp->left);
                tmp=tmp->left;
            }
            return result;
        }
        else
        {
            while(Stack.size()>1 and Stack[Stack.size()-1]->val>Stack[Stack.size()-2]->val)
            {
                Stack.pop_back();
            }
            Stack.pop_back();
            return result;
        }
        
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
