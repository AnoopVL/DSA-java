class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int[] rowArray = new int[rowLength];
        int[] colArray = new int[colLength];

        for(int i=0; i< rowLength; i++){
            for(int j=0; j < colLength; j++){
                if(matrix[i][j] == 0){
                    rowArray[i] = -1;
                    colArray[j] = -1;
                }
            }
        }

        for(int i=0; i< rowLength; i++){
            for(int j=0; j < colLength; j++){
                if(rowArray[i] == -1 || colArray[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}