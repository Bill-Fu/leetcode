class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        int result = 0;
        
        for (int i = 0; i < prerequisites.length; ++i) {
            indegree[prerequisites[i][1]]++;
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                indegree[i]--;
                list.add(i);
                result++;
            }
        }
        
        while (list.size() != 0) {
            for (int i = 0; i < list.size(); ++i) {
                for (int j = 0; j < prerequisites.length; ++j) {
                    if (prerequisites[j][0] == list.get(i)) {
                        indegree[prerequisites[j][1]]--;
                    }
                }
            }
            list.clear();
            for (int i = 0; i < numCourses; ++i) {
                if (indegree[i] == 0) {
                    list.add(i);
                    indegree[i]--;
                    result++;
                }
            }
        }
        
        return result == numCourses;
    }
}
