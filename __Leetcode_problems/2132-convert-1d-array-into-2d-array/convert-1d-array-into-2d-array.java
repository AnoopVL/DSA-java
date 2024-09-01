class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        int [][] ans = new int[m][n];
        int k=0;

        for(int i =0; i< m; i++){
            for(int j=0; j< n; j++){
                ans[i][j] = original[k];
                k++;
            }
        }

        return ans;
    }
}

// int row = 0;
        // int orgPtr= 0;
        // while (row < m && orgPtr < original.length){
        //     int col = 0;
        //     while(col < n){
        //         ans[row][col] = original[orgPtr];
        //         col++;
        //         orgPtr++;
        //     }
        //     row++;
        // }
        // System.gc();