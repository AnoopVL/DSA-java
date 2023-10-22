public class SortMatBS{
    public static void main(String[] args) {
        
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
        if(row == 1 ){
            bSearch(matrix, 0, 0, col-1, target);
        }
        int rstart = 0;
        int rend = col -1;
        int cmid = col/2;
        //We run the following loop until only 2 rows are remaining
        while(rstart < (rend -1)){
            
        }
    }
}