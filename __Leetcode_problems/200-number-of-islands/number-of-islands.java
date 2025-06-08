class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        for(int i=0; i< m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    helper(i, j, grid, visited, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void helper(int i, int j, char[][] grid, boolean[][] visited, int m, int n){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(i,j));
        while(!queue.isEmpty()){
            List<Integer> currentLoc = queue.poll();
            int row = currentLoc.get(0);
            int col = currentLoc.get(1);
            // search top
            if(row-1 >= 0 && grid[row-1][col] == '1' && visited[row-1][col] == false){
                visited[row-1][col] = true;
                queue.offer(Arrays.asList(row-1, col));
            }
            // search bottom
            if(row+1 < m && grid[row+1][col] == '1' && visited[row+1][col] == false){
                visited[row+1][col] = true;
                queue.offer(Arrays.asList(row+1, col));
            }
            // search left
            if(col-1 >= 0 && grid[row][col-1] == '1' && visited[row][col-1] == false){
                visited[row][col-1] = true;
                queue.offer(Arrays.asList(row, col-1));
            }
            // search right
            if(col+1 < n && grid[row][col+1] == '1' && visited[row][col+1] == false){
                visited[row][col+1] = true;
                queue.offer(Arrays.asList(row, col+1));
            }
        }
    }
}