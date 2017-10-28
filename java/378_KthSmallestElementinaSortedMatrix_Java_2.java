ass Solution {
    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        
        used[0][0] = true;
        queue.offer(new Tuple(matrix[0][0], 0, 0));
        
        for (int i = 0; i < k - 1; ++i) {
            Tuple tmp = queue.poll();
            if (tmp.x + 1 < matrix.length && used[tmp.x + 1][tmp.y] == false) {
                queue.add(new Tuple(matrix[tmp.x + 1][tmp.y], tmp.x + 1, tmp.y));
                used[tmp.x + 1][tmp.y] = true;
            }
            if (tmp.y + 1 < matrix[0].length && used[tmp.x][tmp.y + 1] == false) {
                queue.add(new Tuple(matrix[tmp.x][tmp.y + 1], tmp.x, tmp.y + 1));
                used[tmp.x][tmp.y + 1] = true;
            }
        }
        
        return queue.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int val, int x, int y) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
