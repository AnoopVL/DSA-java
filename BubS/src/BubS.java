import java.util.Arrays;

public class BubS {
    public static void main(String[] args) {
        int arr[] = {12,32,54,21,9,8};
        bubS(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubS(int[] arr){
        for(int i=0; i<arr.length;i++){
            for(int j=1; j<arr.length-i; j++){
                if (arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
}