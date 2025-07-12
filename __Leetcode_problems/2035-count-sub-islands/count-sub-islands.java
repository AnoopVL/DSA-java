class Solution {
    int ans = 0;
    List<List<List<Integer>>> islandList1 = new ArrayList<>();
    List<List<List<Integer>>> islandList2 = new ArrayList<>();
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        int[][] visited1 = new int[n][m]; 
        int[][] visited2 = new int[n][m]; 

        // iterate over grid1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited1[i][j] == 0 && grid1[i][j] == 1){
                    List<List<Integer>> islandLoc = new ArrayList<>();
                    dfs(i , j, grid1, visited1, islandLoc);
                }
            }
        }
        //iterate over grid2
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited2[i][j] == 0 && grid2[i][j] == 1){
                    List<List<Integer>> islandLoc = new ArrayList<>();
                    boolean isSubIsland = true;
                    dfs(i , j, grid2, visited2, islandLoc);
                    for(List<Integer> cell : islandLoc){
                        int row = cell.get(0);
                        int col = cell.get(1);
                        if(grid1[row][col] != 1){
                            isSubIsland = false;
                            break;
                        }
                    }
                    if(isSubIsland) ans++;
                }
            }
        }
        return ans;
    }

    private void dfs (int row, int col, int[][] grid, int[][] visited, List<List<Integer>> islandLoc){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        islandLoc.add(Arrays.asList(row,col));
        int[] findRow = {0,0,-1,1};
        int[] findCol = {-1,1,0,0};
        for(int i = 0; i < 4; i++){
            int newRow = row + findRow[i];
            int newCol = col + findCol[i];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                dfs(newRow, newCol, grid, visited, islandLoc);
            }
        }
    }
}