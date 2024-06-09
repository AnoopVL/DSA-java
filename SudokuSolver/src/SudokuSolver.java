/**
 * SudokuSolver
 */
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        if (sudoku(board)) {
            display(board);
        }
        else{
            System.out.println("Cannot solve the sudoku !!");
        }
        // sudoku(board);
        // display(board);
    }

    public static boolean sudoku(int [][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }
        if (emptyLeft) { // i.e. sudoku is solved
            return true;
        }
        for (int num = 0; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (sudoku(board)) {
                    return true; // i.e. answer found
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }


    // public static void sudoku(int[][] board){
    //     // if (row == board.length) {
    //     //     display(board);
    //     //     System.out.println();
    //     //     return;
    //     // }
    //     for (int num = 1; num <= board.length; num++) {
    //         for (int row = 0; row < board.length; row++) {
    //             for( int col = 0; col <= row; col++){
    //                 if (isSafe(board, row, col, num) && board[row][col] == 0) {
    //                     board[row][col] = num;
    //                 }
    //             }
    //         }
    //     }   
    // }

    public static boolean isSafe(int[][] board, int row, int col, int num){
        // This is for checking row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // This is for checking column
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        // This is for the block check
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for(int r = rowStart; r < rowStart + sqrt; r++ ){
            for(int c = colStart; c < colStart + sqrt; c++){
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void display(int[][] board){
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board.length; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}