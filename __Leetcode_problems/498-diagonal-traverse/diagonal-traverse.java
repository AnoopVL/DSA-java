class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = 0;
        int col = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n*m];
        for(int i = 0; i < ans.length; i++){
            ans[i] = mat[row][col];
            if((row + col) % 2 == 0){
                if(col == m-1){
                    row++;
                }else if(row == 0){
                    col++;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row == n-1){
                    col++;
                }else if(col == 0){
                    row++;
                }else{
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}