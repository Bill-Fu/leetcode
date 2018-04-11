class Solution {
    public void wallsAndGates(int[][] rooms) {
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[i].length; ++j) {
                if (rooms[i][j] == 0) {
                    int[] tmp = new int[2];
                    
                    tmp[0] = i;
                    tmp[1] = j;
                    
                    list.add(tmp);
                }
            }
        }
        
        int dist = 1;
        
        while (list.size() != 0) {
            List<int[]> tmpList = new ArrayList<>();
            
            for (int[] xy: list) {
                if (xy[0] != 0 && rooms[xy[0] - 1][xy[1]] == Integer.MAX_VALUE) {
                    rooms[xy[0] - 1][xy[1]] = dist;
                    int[] tmp = new int[2];
                    tmp[0] = xy[0] - 1;
                    tmp[1] = xy[1];
                    
                    tmpList.add(tmp);
                }
                
                if (xy[0] != rooms.length - 1 && rooms[xy[0] + 1][xy[1]] == Integer.MAX_VALUE) {
                    rooms[xy[0] + 1][xy[1]] = dist;
                    int[] tmp = new int[2];
                    tmp[0] = xy[0] + 1;
                    tmp[1] = xy[1];
                    
                    tmpList.add(tmp);                  
                }
                
                if (xy[1] != 0 && rooms[xy[0]][xy[1] - 1] == Integer.MAX_VALUE) {
                    rooms[xy[0]][xy[1] - 1] = dist;
                    int[] tmp = new int[2];
                    tmp[0] = xy[0];
                    tmp[1] = xy[1] - 1;
                    
                    tmpList.add(tmp);
                }
                
                if (xy[1] != rooms[0].length - 1 && rooms[xy[0]][xy[1] + 1] == Integer.MAX_VALUE) {
                    rooms[xy[0]][xy[1] + 1] = dist;
                    int[] tmp = new int[2];
                    tmp[0] = xy[0];
                    tmp[1] = xy[1] + 1;
                    
                    tmpList.add(tmp);
                }
            }
            
            dist++;
            
            list = tmpList;
        }
    }
}
