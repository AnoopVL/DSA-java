class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'X'){
                    dfs(i, j, visited, board);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, int[][] visited, char[][] board){
        visited[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        int[] findRow = {-1, 1, 0, 0};
        int[] findCol = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            int newRow = row + findRow[i];
            int newCol = col + findCol[i];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]==0 && board[newRow][newCol]=='X'){
                dfs(newRow, newCol, visited, board);
            }
        }
    }
}