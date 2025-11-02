class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // int guardedCount = guards.length + walls.length;
        int ans = 0;
        int[][] grid = new int[m][n];
        for(int[] cell : guards){
            grid[cell[0]][cell[1]] = 2;
        }
        for(int[] cell : walls){
            grid[cell[0]][cell[1]] = 2;
        }
        int[] dir = {-1, 0, 1, 0, -1};
        for(int[] cell : guards){
            for(int i = 0; i< 4; i++){
                int x = cell[0];
                int y = cell[1];
                int dx = dir[i];
                int dy = dir[i+1];
                
                while(x+dx>=0 && x+dx<m && y+dy>=0 && y+dy<n && grid[x+dx][y+dy]<2){
                    x += dx;
                    y += dy;
                    grid[x][y] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) ans++;
            }
        }
        return ans;
    }
}