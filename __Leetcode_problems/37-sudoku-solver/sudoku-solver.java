class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) { 
                        if (isValid(board, i, j, d)) {
                            board[i][j] = d;
                            if (solve(board)) return true;
                            board[i][j] = '.'; 
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == d) return false; 
            if (board[i][col] == d) return false; 
        }
        int start_i = (row / 3) * 3;
        int start_j = (col / 3) * 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[start_i + k][start_j + l] == d) return false; 
            }
        }
        return true;
    }
}
