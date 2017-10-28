class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        else {
            boolean[] visited = new boolean[numCourses];
            boolean[] finished = new boolean[numCourses];
            
            for (int i = 0; i < numCourses; ++i) {
                if (finished[i] == false) {
                    Arrays.fill(visited, false);
                    if (canFinish(i, prerequisites, finished, visited) == false) {
                        return false;
                    }
                }

            }
            
            return true;
        }
    }
    
    private boolean canFinish(int numIdx, int[][] prerequisites, boolean[] finished, boolean[] visited) {
        if (finished[numIdx] == false) {        
            visited[numIdx] = true;
            for (int i = 0; i < prerequisites.length; ++i) {
                if (prerequisites[i][0] == numIdx && finished[prerequisites[i][1]] == false) {
                    if (visited[prerequisites[i][1]] == true || canFinish(prerequisites[i][1], prerequisites, finished, visited) == false) {
                        return false;
                    }
                }

            }

            finished[numIdx] = true;

            return true;            
        }
        else {
            return true;
        }
    }
}
