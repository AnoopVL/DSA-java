class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    int area = dfs(i,j,grid,visited);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }

    private int dfs(int row, int col, int[][] grid, int[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        int area = 1;
        int[] findRow = {0,0,-1,1};
        int[] findCol = {-1,1,0,0};
        for(int i=0; i < 4; i++){
            int newRow = row + findRow[i];
            int newCol = col + findCol[i];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]==0 && grid[newRow][newCol]==1){
               area += dfs(newRow, newCol, grid, visited);
            }
        }
        return area;
    }
}