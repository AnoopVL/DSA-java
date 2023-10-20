import java.util.Arrays;

public class RowColMat{
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30 , 40},
            {11, 24, 35 , 43},
            {13, 26, 37 , 45},
            {17, 28, 39 , 50},
        };
        System.out.println(Arrays.toString(search(arr, 50)));
    }
    static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length -1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row, col};
            }
            if(matrix[row][col] < target){
                row++;
            }
            if(matrix[row][col] > target){
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}