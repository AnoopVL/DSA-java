import java.util.Arrays;

public class SlctS {
    public static void main(String[] args) {
        int arr[] = {12,32,54,21,9,8};
        selectionS(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionS(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length -i -1;
            int maxNum = maxN(arr, 0, last);
            swap(arr, maxNum, last);
        }
    }
    static int maxN(int[]arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max]< arr[i]){
                max = i;
            }
        }
        return max;
    }
    static void swap(int[]arr, int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}