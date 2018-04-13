class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    StringBuffer tmp = new StringBuffer();
                    searchIslands(i, j, grid, visited, tmp);
                    islands.add(new String(tmp));
                }
            }
        }
        
        return islands.size();
    }
    
    public boolean searchIslands(int x, int y, int[][] grid, boolean[][] visited, StringBuffer shape) {
        if (0 <= x && x < visited.length && 0 <= y && y < visited[0].length) {
            if (grid[x][y] == 1 && visited[x][y] == false) {
                visited[x][y] = true;
                
                shape.append("(");
                
                if (searchIslands(x - 1, y, grid, visited, shape)) {
                    shape.append("u");
                }
                if (searchIslands(x, y - 1, grid, visited, shape)) {
                    shape.append("l");
                }
                if (searchIslands(x, y + 1, grid, visited, shape)) {
                    shape.append("r");
                }
                if (searchIslands(x + 1, y, grid, visited, shape)) {
                    shape.append("d");
                }
                
                shape.append(")");
                
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
