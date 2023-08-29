import java.util.Arrays;
import java.util.Scanner;

public class LSearch2D{
    public static void main(String[] args) {
        // int[][] arr = {
        //     {12, 7, 10},
        //     {15, 21, 67, 90},
        //     {34, 9, 24, 13}
        // }; 
        // int target = 21;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns you want form the matrix : ");
        int row = in.nextInt();
        int col = in.nextInt();

        System.out.println("Enter Elements in the matrix : ");
        int arr[][] = new int[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("The Matrix is : ");
        for(int i = 0; i<row; i++){
            for(int j = 0; j< col; j++){
                System.out.print(arr[i][j] +"\t");
            }
            System.out.println();
        }

        System.out.println("Enter the element you want to search : ");
        int target = in.nextInt();
        

        int ans[] = search(arr, target);
        System.out.println("The position of "+target+" is "+Arrays.toString(ans));
    }
    static int[] search(int[][] arr, int target){
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col <= row; col++){
                if(arr[row][col] == target){
                    return new int[]{row, col}; 
                }
            }
        }
        return new int[]{-1,-1};
    }
}