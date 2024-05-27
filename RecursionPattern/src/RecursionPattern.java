import java.util.Arrays;

public class RecursionPattern {

    public static void main(String[] args) {
        int arr[] = {3,5,1,2,9};
        bubbleSort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
        // reverseLeftTriangle(5, 0);
        // leftTriangle(5, 0);
    }
    // public static void reverseLeftTriangle(int row, int col){
    //     if(row == 0){
    //         return;
    //     }
    //     if(col<row){
    //         System.out.print("* \t" );
    //         reverseLeftTriangle(row, col+1);
    //     }
    //     else{
    //         System.out.println();
    //         reverseLeftTriangle(row-1, 0);
    //     }
    // }
    // public static void leftTriangle(int row, int col){
    //     if(row == 0){
    //         return;
    //     }
    //     if(col<row){
    //         leftTriangle(row, col+1);
    //         System.out.print("* \t");
    //     }
    //     else{
    //         leftTriangle(row-1, 0);
    //         System.out.println();
    //     }
    // }
        public static void bubbleSort(int[]arr, int length, int start){
            if (length == 0 ) {
                return;
            }
            if(start < length){
                if (arr[start]>arr[start+1]) {
                    int temp = 0;
                    temp = arr[start];
                    arr[start] = arr[start+1];
                    arr[start+1] = temp;
                }
                bubbleSort(arr, length, start+1);
            }
            else{
                bubbleSort(arr, length-1, 0);
            }
        }
}