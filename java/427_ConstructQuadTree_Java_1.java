/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        
        return construct(grid, 0, 0, grid.length, grid.length);
    }
    
    public Node construct(int[][] grid, int minX, int minY, int maxX, int maxY) {
        boolean isLeaf = true;
        for (int i = minX; i < maxX; ++i) {
            for (int j = minY; j < maxY; ++j) {
                if (isLeaf && grid[i][j] != grid[minX][minY]) {
                    isLeaf = false;
                }
            }
        }
        
        Node rtn = new Node(isLeaf? (grid[minX][minY] == 1? true: false): true, isLeaf, null, null, null, null);
        
        if (isLeaf == false) {
            rtn.topLeft = construct(grid, minX, minY, (minX + maxX) / 2, (minY + maxY) / 2);
            rtn.topRight = construct(grid, minX, (minY + maxY) / 2, (minX + maxX) / 2, maxY);
            rtn.bottomLeft = construct(grid, (minX + maxX) / 2, minY, maxX, (minY + maxY) / 2);
            rtn.bottomRight = construct(grid, (minX + maxX) / 2, (minY + maxY) / 2, maxX, maxY);
        }
        
        return rtn;
    }
}
