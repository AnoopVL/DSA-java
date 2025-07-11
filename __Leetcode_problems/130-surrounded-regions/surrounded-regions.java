class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;

        // Step 1: Mark border-connected 'O's
        for (int i = 0; i < n; i++) {
            // First and last column
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board);
            }
        }

        for (int j = 0; j < m; j++) {
            // First and last row
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }
            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board);
            }
        }

        // Step 2: Flip surrounded regions and revert the marks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Temporary mark to indicate safe region

        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
