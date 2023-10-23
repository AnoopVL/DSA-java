import java.util.Arrays;

public class SortMatBS{
    public static void main(String[] args) {
        int arr[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        System.out.println(Arrays.toString(search(arr, 9)));
    }
    static int[] bSearch(int[][] matrix, int row, int cstart, int cend, int target){
        int mid = cstart + (cend - cstart)/2;
        if(matrix[row][mid] == target){
            return new int[]{row, mid};
        }
        if(matrix[row][mid] > target){
            cend = mid -1;
        }
        else{
            cstart = mid +1;
        }
        return new int[]{-1, -1};
    }
    static int[]search(int[][]matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 1){
            bSearch(matrix, 0, 0, col-1, target);
        }
        int rstart = 0;
        int rend = col -1;
        int cmid = col/2;
        //We run the following loop until only 2 rows are remaining
        while(rstart < (rend -1)){
            int mid = rstart + (rend + rstart)/2;
            if(matrix[mid][cmid] == target){
                return new int[]{mid, cmid};
            }
            if(matrix[mid][cmid] > target){
                rend = mid;
            }
            else{
                rstart = mid;
            }
        }
        // now we have 2 rows left
        // so we check if target is in columns of remaining 2 rows
        if(matrix[rstart][cmid] == target){
            return new int[]{rstart, cmid};
        }
        if(matrix[rstart+1][cmid] == target){
            return new int[]{rstart+1, cmid};
        }
        // search in 1st half
        if(target <= matrix[rstart][cmid-1]){
            return bSearch(matrix, rstart, 0, cmid -1, target);
        }
        // search in 2nd half
        if(target >= matrix[rstart][cmid+1] && target <= matrix[rstart][cmid-1]){
            return bSearch(matrix, rstart, cmid +1, col -1, target);
        }
        // search in 3rd half
        if(target <= matrix[rstart+1][cmid-1]){
            return bSearch(matrix, rstart +1 , 0, cmid -1, target);
        }
        // search in 4th half
        else{
            return bSearch(matrix, rstart+1, cmid +1 , col -1, target);
        }
    }
}