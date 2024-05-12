/**
 * RecursionArray
 */
public class RecursionArray {

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7};
        System.out.println(checkArrSort(arr, 0));
    }
    public static boolean checkArrSort(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && checkArrSort(arr, index+1);
    }
}