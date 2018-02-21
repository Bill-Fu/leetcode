class Solution {
    public int findCircleNum(int[][] M) {
        int result = 0;
        boolean[] used = new boolean[M.length];
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < M.length; ++i) {
            if (used[i] == false) {
                queue.add(i);
                used[i] = true;
                
                while (queue.peek() != null) {
                    for (int j = 0; j < M[0].length; ++j) {
                        if (M[queue.peek()][j] == 1 && used[j] == false) {
                            queue.add(j);
                            used[j] = true;
                        }
                    }
                    
                    queue.poll();
                }
                
                result++;
            }
        }
        
        return result;
    }
}
