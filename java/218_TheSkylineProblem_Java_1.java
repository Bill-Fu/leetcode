class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        
        if (buildings.length == 0) {
            return result;
        }
        else {
            int[][] builds = new int[buildings.length * 2][3];
            
            for (int i = 0; i < buildings.length; ++i) {
                builds[2 * i][0] = buildings[i][0];
                builds[2 * i][1] = buildings[i][1];
                builds[2 * i][2] = buildings[i][2];
                builds[2 * i + 1][0] = buildings[i][1];
                builds[2 * i + 1][1] = buildings[i][0];
                builds[2 * i + 1][2] = buildings[i][2];
            }
            
            Arrays.sort(builds, Comparator.comparing((int[] arr) -> arr[0]));
            
            TreeMap<Integer, Integer> tree = new TreeMap<>();
            
            tree.put(0, 1);
            
            int prev = Integer.MIN_VALUE;
            int cur = Integer.MIN_VALUE;
            
            for (int i = 0; i < builds.length; ++i) {
                if (builds[i][0] < builds[i][1]) {
                    if (tree.containsKey(builds[i][2]) == true) {
                        tree.put(builds[i][2], tree.get(builds[i][2]) + 1);
                    }
                    else {
                        tree.put(builds[i][2], 1);
                    }
                }
                else {
                    if (tree.get(builds[i][2]) == 1) {
                        tree.remove(builds[i][2]);
                    }
                    else {
                        tree.put(builds[i][2], tree.get(builds[i][2]) - 1);
                    }
                }
                if (i == builds.length - 1 || builds[i][0] != builds[i + 1][0]) {
                    cur = tree.lastKey();
                    
                    if (cur != prev) {
                        result.add(new int[] {builds[i][0], cur});
                    }
                    
                    prev = cur;
                }
            }
            
            return result;
        }
    }
}
