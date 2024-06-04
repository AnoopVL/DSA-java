import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subset
 */
public class Subset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsetIteration(arr));
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
}