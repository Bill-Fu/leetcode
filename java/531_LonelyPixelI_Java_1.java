class Solution {
    public int findLonelyPixel(char[][] picture) {
        Map<Integer, Integer> row = new HashMap<>();
        Set<Integer> col = new HashSet<>();
        
        for (int i = 0; i < picture.length; ++i) {
            for (int j = 0; j < picture[0].length; ++j) {
                if (picture[i][j] == 'B') {
                    if (row.containsKey(i)) {
                        row.remove(i);
                        break;
                    }
                    else {
                        row.put(i, j);
                    }
                }
            }
        }
        
        for (int j = 0; j < picture[0].length; ++j) {
            for (int i = 0; i < picture.length; ++i) {
                if (picture[i][j] == 'B') {
                    if (col.contains(j)) {
                        col.remove(j);
                        break;
                    }
                    else {
                        col.add(j);
                    }
                }
            }
        }
        
        int result = 0;
        
        for (int key: row.keySet()) {
            if (col.contains(row.get(key))) {
                result++;
            }
        }
        
        return result;
    }
}
