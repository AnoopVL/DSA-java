/**
 * Recursion_Nqueens
 */
public class Recursion_Nqueens {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nqueens(board, 0));
    }

    public static int nqueens(boolean[][]board, int row){
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        // Here we will place queen and check for every row and column
        for (int col = 0; col < board.length; col++) {
            // Here we traverse through the array and place the queen if it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nqueens(board,row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board,int row, int col){
        // This for vertical check
        for(int i = 0; i < row; i++){
            if (board[i][col] == true) {
                return false;
            }
        }

        // This is for left diagonal check
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }

        // This is for diagonal right check
        int maxRight = Math.min(row, board.length-1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print(" Q ");
                }
                else{
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
    
}