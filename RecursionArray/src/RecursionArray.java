import java.util.ArrayList;

/**
 * RecursionArray
 */
public class RecursionArray {

    public static void main(String[] args) {
        // int[] arr = {1,2,4,6,4,7,9};
        int[] arr = {5,6,7,8,9,1,2,3};
        // System.out.println(checkArrSort(arr, 0));
        // System.out.println(searchArr(arr, 9, 0));
        // findAllIndexes(arr, 8, 0);
        // System.out.println(list);
        // System.out.println(findAllIndexes(arr, 4, 0));
        System.out.println(rotatedArrBinSearch(arr, 2, 0, arr.length-1));
    }
    public static boolean checkArrSort(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && checkArrSort(arr, index+1);
    }
    public static boolean searchArr(int[]arr, int target, int index){
        if(index == arr.length-1){
            return false;
        }
        return arr[index] == target || searchArr(arr, target, index+1);
    }
    // static ArrayList<Integer> list = new ArrayList<>();
    // public static void findAllIndexes(int[]arr, int target, int index){
    //     if(index == arr.length-1){
    //         return;
    //     } 
    //     if(arr[index]==target){
    //         list.add(index);
    //     }
    //     findAllIndexes(arr, target, index+1);
    // }
    public static ArrayList<Integer> findAllIndexes(int[]arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length-1) {
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> listFromBelowCalls = findAllIndexes(arr, target, index+1);
        list.addAll(listFromBelowCalls);
        return list;
    }
    public static int rotatedArrBinSearch(int[]arr, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int mid = s + (e-s)/2;
        if (arr[mid]==target) {
            return mid;
        }
        if (arr[s]<=arr[mid]) {
            if (target >= arr[s] && target <=arr[mid]) {
                return rotatedArrBinSearch(arr, target, s, mid-1);
            }
            else{
                return rotatedArrBinSearch(arr, target, mid+1, e);
            }
        }
        if (target >= arr[mid] && target <= arr[e]) {
            return rotatedArrBinSearch(arr, target, mid+1, e);
        }
        return rotatedArrBinSearch(arr, target, s,mid-1);    
    }
}