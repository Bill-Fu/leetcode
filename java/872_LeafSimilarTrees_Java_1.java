/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = leafValSeq(root1);
        List<Integer> seq2 = leafValSeq(root2);
        
        return compare(seq1, seq2);
    }
    
    public List<Integer> leafValSeq(TreeNode root) {
        List<Integer> seq = new ArrayList<>();
        
        leafValSeq(root, seq);
        
        return seq;
    }
    
    public void leafValSeq(TreeNode root, List<Integer> seq) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                seq.add(root.val);
            }
            else {
                leafValSeq(root.left, seq);
                leafValSeq(root.right, seq);
            }
        }
    }
    
    public boolean compare(List<Integer> seq1, List<Integer> seq2) {
        if (seq1 != null && seq2 != null && seq1.size() == seq2.size()) {
            for (int i = 0; i < seq1.size(); ++i) {
                if (seq1.get(i) != seq2.get(i)) {
                    return false;
                }
            }
            
            return true;
        }
        else {
            return false;
        }
    }
}
