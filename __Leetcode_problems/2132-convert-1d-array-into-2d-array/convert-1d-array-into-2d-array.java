class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] ans = new int[m][n];
        if(m*n != original.length){
            // int[][] mt = new int[0][0];
            return new int[0][0];
        }
        int row = 0;
        int orgPtr= 0;
        while (row < m && orgPtr < original.length){
            int col = 0;
            while(col < n){
                ans[row][col] = original[orgPtr];
                col++;
                orgPtr++;
            }
            row++;
        }
        return ans;
    }
}