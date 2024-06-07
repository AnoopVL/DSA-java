// This is a maze probem, like calulate the total number of ways a person can reach a point in a matrix/ maze
/**
 * MazeProblem
 */
public class MazeProblem {

    public static void main(String[] args) {
        System.out.println(mazePathCount(3, 3));
    }
    public static int mazePathCount(int row, int col){
        int count = 0;
        if (row == 1 || col == 1 ) {
            return 1;
        }
        int left = mazePathCount(row-1, col);
        int right = mazePathCount(row, col-1);
        count = left + right;
        return count;
    }

}