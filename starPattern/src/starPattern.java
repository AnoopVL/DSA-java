import java.util.Scanner;

public class starPattern {
    public static void main(String[] args) {
        int row = 4;
        int col = 4;
        strPtrn(row, col);
    }
    public static void strPtrn(int row, int col){
            for (int i = row; i >0 ; i--) {
                // inner loop to print spaces.
            for (int j = 1; j < i; j++) {
                System.out.print("\t");
                // System.out.print("\t");
            }
 
            // inner loop to print stars.
            for (int j = 0; j <= row - i; j++) {
                System.out.print("*");
                System.out.print("\t");
            }
                System.out.println("\n");
            }
        }
    // inverted left star pyramid
    public static void strPtrnPyd(int row, int col){
        for (int i = row; i >=0; i--) {
            for (int j = i; j >=0; j--) {
                System.out.print("*");
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }
    // left pyramid
    // public static void strPtrn(int row, int col){
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j <=i; j++) {
    //             System.out.print("*");
    //         }
    //         System.out.println("\n");
    //     }
    // }
    // 4x4 star pattern
    // public static void strPtrn(int row, int col){
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j <col; j++) {
    //             System.out.print("*");
    //         }
    //         System.out.println("\n");
    //     }
    // }
}