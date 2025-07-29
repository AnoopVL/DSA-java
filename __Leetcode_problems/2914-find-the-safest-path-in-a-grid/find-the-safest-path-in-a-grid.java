class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        boolean[][] visited = new boolean[n][n];
        int[][] safeness = new int[n][n];
        // 1. finding the safeness all over the grid
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    visited[i][j] = true;
                    q.offer(new int[] { i, j });
                }
            }
        }
        int level = 0;
        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int r = q.peek()[0];
                int c = q.poll()[1];
                safeness[r][c] = level;
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[] { nr, nc });
                    }
                }
                size--;
            }
            level++;
        }
        // 2. dijkstra over the grid
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (y[0] - x[0]));
        boolean[][] seen = new boolean[n][n];
        pq.offer(new int[] { safeness[0][0], 0, 0 });
        seen[0][0] = true;
        while (!pq.isEmpty()) {
            int minSafe = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.poll()[2];
            if (r == n - 1 && c == n - 1)
                return minSafe;
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !seen[nr][nc]) {
                    seen[nr][nc] = true;
                    int newSafe = Math.min(minSafe, safeness[nr][nc]);
                    pq.offer(new int[] { newSafe, nr, nc });
                }
            }
        }
        return 0;
    }

}