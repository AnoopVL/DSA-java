import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subset
 */
public class Subset {
    public static void main(String[] args) {
        // int[] arr = {1,2,3};
        // System.out.println(subsetIteration(arr));
        int[] arr = {1,2,2};
        System.out.println(subsetIterationDuplicated(arr));

    }
    public static List<List<Integer>> subsetIteration(int[]arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    } 

    public static List<List<Integer>> subsetIterationDuplicated(int[]arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0; 
        int end = 0;

        for(int i = 0; i< arr.length-1; i++){
            start =0;
            if ( i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() -1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    } 

}