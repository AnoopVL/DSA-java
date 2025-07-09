class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    // bfs
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    int area = bfs(i, j, visited, grid);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }

    private int bfs(int row, int col, int[][] visited, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        int area = 0;
        int[] findRow = {0, 0, -1, 1};
        int[] findCol = {-1, 1, 0, 0};
        while(!queue.isEmpty()){
            // int[] pos = queue.poll();
            int row0 = queue.peek()[0];
            int col0 = queue.peek()[1];
            // visited[row0][col0] = 1;
            queue.poll();
            area++;
            for(int i = 0; i < 4; i++){
                int newRow = row0 + findRow[i];
                int newCol = col0 + findCol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]==0 && grid[newRow][newCol]==1){
                    visited[newRow][newCol] = 1;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
        return area;
    }
}