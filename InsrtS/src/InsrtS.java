import java.util.Arrays;

public class InsrtS {
    public static void main(String[] args) {
        int[] arr = {4,3,0,9,-1,-2};
        insrtS(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insrtS(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            // int j = i+1;
            // while (j>0) {
            //     if (arr[j]<arr[j-1]) {
            //         int temp = arr[j];
            //         arr[j]=arr[j-1];
            //         arr[j-1]=temp;
            //         j--;
            //     } else {
            //         break;   
            //         }
            // }
                // The above code is using while loop 
                // and the below code is using for loop 
           for (int j = i+1; j >0; j--) {
                if (arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                } else {
                    break;   
                }
           } 
        }
    }
}