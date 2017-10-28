class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((x, y) -> x.get(0) - y.get(0));
        List<Integer> tmp = new ArrayList<>();
        List<Integer> tmp1;
        
        used[0][0] = true;
        tmp.add(matrix[0][0]);
        tmp.add(0);
        tmp.add(0);
        queue.add(tmp);
        
        for (int i = 0; i < k - 1; ++i) {
            tmp1 = queue.poll();
            if (tmp1.get(1) + 1 < matrix.length && used[tmp1.get(1) + 1][tmp1.get(2)] == false) {
                tmp = new ArrayList<>();
                tmp.add(matrix[tmp1.get(1) + 1][tmp1.get(2)]);
                tmp.add(tmp1.get(1) + 1);
                tmp.add(tmp1.get(2));
                queue.add(tmp);
                used[tmp1.get(1) + 1][tmp1.get(2)] = true;
            }
            if (tmp1.get(2) + 1 < matrix[0].length && used[tmp1.get(1)][tmp1.get(2) + 1] == false) {
                tmp = new ArrayList<>();
                tmp.add(matrix[tmp1.get(1)][tmp1.get(2) + 1]);
                tmp.add(tmp1.get(1));
                tmp.add(tmp1.get(2) + 1);
                queue.add(tmp);
                used[tmp1.get(1)][tmp1.get(2) + 1] = true;
            }
        }
        
        return queue.poll().get(0);
    }
}
