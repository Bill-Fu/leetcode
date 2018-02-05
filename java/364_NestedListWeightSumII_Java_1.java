/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int depth;
    int result;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0) {
            return 0;
        }
        else {
            depth = 1;

            findDepth(nestedList, 1);

            result = 0;
            
            findResult(nestedList, depth);
            
            return result;
        }
    }
    
    public void findResult(List<NestedInteger> nestedList, int curDep) {
        for (int i = 0; i < nestedList.size(); ++i) {
            if (nestedList.get(i).isInteger()) {
                result += curDep * nestedList.get(i).getInteger();
            }
            else {
                findResult(nestedList.get(i).getList(), curDep - 1);
            }
        }
    }
    
    public void findDepth(List<NestedInteger> nestedList, int curDep) {
        depth = Math.max(depth, curDep);
        
        for (int i = 0; i < nestedList.size(); ++i) {
            if (nestedList.get(i).isInteger() == false) {
                findDepth(nestedList.get(i).getList(), curDep + 1);
            }
        }
    }
}
