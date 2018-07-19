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
        return construct(grid, 0, 0, grid.length, grid.length);
    }
    
    public Node construct(int[][] grid, int minX, int minY, int maxX, int maxY) {
        if (minX == maxX) {
            return null;
        }
        else if (minX + 1 == maxX) {
            return new Node(grid[minX][minY] == 1? true: false, true, null, null, null, null);
        }
        else {
            Node topLeft = construct(grid, minX, minY, (minX + maxX) / 2, (minY + maxY) / 2);
            Node topRight = construct(grid, minX, (minY + maxY) / 2, (minX + maxX) / 2, maxY);
            Node bottomLeft = construct(grid, (minX + maxX) / 2, minY, maxX, (minY + maxY) / 2);
            Node bottomRight = construct(grid, (minX + maxX) / 2, (minY + maxY) / 2, maxX, maxY);
            
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topRight.val == topLeft.val && bottomLeft.val == topLeft.val && bottomRight.val == topLeft.val) {
                return new Node(bottomLeft.val, true, null, null, null, null);
            }
            else {
                return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
    }
}
