class Solution {
    public void rotate(int[][] matrix) {
        // Transpose the matrix
        for(int i=0; i < matrix.length; i++){
            for(int j=i; j< matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // flip the matrix vertically
        for(int i=0; i< matrix.length; i++){
            for(int j =0; j< matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}