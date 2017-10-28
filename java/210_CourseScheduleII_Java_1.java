class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        else {
            boolean[] visited = new boolean[numCourses];
            boolean[] finished = new boolean[numCourses];
            ArrayList<Integer> result = new ArrayList<>();
            int[] res = new int[numCourses];
            
            for (int i = 0; i < numCourses; ++i) {
                if (finished[i] == false) {
                    Arrays.fill(visited, false);
                    if (findOrder(i, prerequisites, finished, visited, result) == false) {
                        return new int[0];
                    }
                }
            }
            
            for (int i = 0; i < numCourses; ++i) {
                res[i] = result.get(i);
            }
            
            return res;
        }
    }
    
    private boolean findOrder(int numIdx, int[][] prerequisites, boolean[] finished, boolean[] visited, List<Integer> result) {
        if (finished[numIdx] == false) {        
            visited[numIdx] = true;
            for (int i = 0; i < prerequisites.length; ++i) {
                if (prerequisites[i][0] == numIdx && finished[prerequisites[i][1]] == false) {
                    if (visited[prerequisites[i][1]] == true || findOrder(prerequisites[i][1], prerequisites, finished, visited, result) == false) {
                        return false;
                    }
                }

            }

            finished[numIdx] = true;
            result.add(numIdx);
            
            return true;            
        }
        else {
            return true;
        }
    }
}
