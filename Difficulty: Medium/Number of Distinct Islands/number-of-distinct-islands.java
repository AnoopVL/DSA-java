// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0; i< n; i++){
            for(int j=0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> island = new ArrayList<>();
                    dfs(i, j, visited, grid, island, i, j);
                    set.add(island);
                }
            }
        }
        return set.size();
    }
    
    private void dfs(int row, int col, int[][] visited, int[][] grid, ArrayList<String> island, int row0, int col0){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        island.add(stringHelper(row - row0, col - col0));
        int[] findRow = {-1, 0, 1, 0};
        int[] findCol = {0, -1, 0, 1};
        for(int i=0; i < 4; i++){
            int newRow = row + findRow[i];
            int newCol = col + findCol[i];
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                dfs(newRow, newCol, visited, grid, island, row0, col0);
            }
        }
    }
    
    private String stringHelper(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
