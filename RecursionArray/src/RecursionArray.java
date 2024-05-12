import java.util.ArrayList;

/**
 * RecursionArray
 */
public class RecursionArray {

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,4,7,9};
        // System.out.println(checkArrSort(arr, 0));
        // System.out.println(searchArr(arr, 9, 0));
        // findAllIndexes(arr, 8, 0);
        // System.out.println(list);
        System.out.println(findAllIndexes(arr, 4, 0));
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
}