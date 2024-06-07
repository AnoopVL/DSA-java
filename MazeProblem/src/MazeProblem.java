// This is a maze probem, like calulate the total number of ways a person can reach a point in a matrix/ maze

import java.util.Arrays;

/**
 * MazeProblem
 */
public class MazeProblem {

    public static void main(String[] args) {
        // System.out.println(mazePathCount(3, 3));
        // mazePathReturn("", 3, 3);
        // mazePathDiagonal("", 3, 3);
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        // mazePathAllDirection("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        mazePathPrint("", maze, 0, 0, path, 1);

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
    public static void mazePathReturn(String proString, int row, int col){
        if (row == 1 && col == 1) {
            System.out.println(proString);
            return;
        }
        if (row > 1 && col > 1) {
            mazePathReturn(proString + "D", row -1, col); 
            mazePathReturn(proString + "R", row, col -1 ); 
        }
        if (row == 1 && col > 1) {
            mazePathReturn(proString + "R", row, col -1 ); 
        }
        if (row > 1 && col == 1) {
            mazePathReturn(proString + "D", row-1, col);
        }
    }
    public static void mazePathDiagonal(String proString, int row, int col){
        if (row == 1 && col == 1) {
            System.out.println(proString);
            return;
        }
        if (row > 1 && col > 1) {
            mazePathDiagonal(proString + "daigonal ", row-1, col-1 ); 
        }
        if (col > 1) {
            mazePathDiagonal(proString + "R ", row, col -1 ); 
        }
        if (row > 1) {
            mazePathDiagonal(proString + "D ", row-1, col);
        }
    }
    public static void mazePathAllDirection(String path, boolean[][] maze, int row, int col){
        if (row == maze.length-1 && col == maze[0].length-1) {
            System.out.println(path);
            return;
        }
        //This is for obstacle or we don't visit the blocks that are marked as false
        if (!maze[row][col]) {
            return;
        }
        //This is the current block we are visiting, so we set it as false
        maze[row][col] =false;

        if(row < maze.length-1){
            mazePathAllDirection( path + "D ", maze, row+1, col);
        }
        if (col < maze[0].length-1) {
            mazePathAllDirection(path+ "R " , maze, row, col+1);
        }
        if (row > 0) {
            mazePathAllDirection(path+ "U ", maze, row-1, col);
        }
        if (col > 0) {
            mazePathAllDirection(path+ "L ", maze, row, col-1);
        }
        //This is backtracking, 
        // This is also where the method ends
        // we restore the state of the visited block to true; 
        maze[row][col] = true;
    }

    public static void mazePathPrint(String p, boolean[][] maze, int row, int col, int[][] path, int step){
        if (row == maze.length-1 && col == maze[0].length-1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }

            System.out.println(p);
            System.out.println();
            return;
        }
        //This is for obstacle or we don't visit the blocks that are marked as false
        if (!maze[row][col]) {
            return;
        }
        //This is the current block we are visiting, so we set it as false
        maze[row][col] =false;
        path[row][col] = step;

        if(row < maze.length-1){
            mazePathPrint( p + "D ", maze, row+1, col, path, step+1);
        }
        if (col < maze[0].length-1) {
            mazePathPrint(p+ "R " , maze, row, col+1, path, step+1);
        }
        if (row > 0) {
            mazePathPrint(p+ "U ", maze, row-1, col, path, step+1);
        }
        if (col > 0) {
            mazePathPrint(p+ "L ", maze, row, col-1, path, step+1);
        }
        //This is backtracking, 
        // This is also where the method ends
        // we restore the state of the visited block to true; 
        maze[row][col] = true;
        path[row][col] = 0;
    }

}