class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int firstRow = 0;
        int firstCol = 0;
        int lastRow = matrix.length-1;
        int lastCol = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(true){
            // Move right
            for(int i = firstCol; i <= lastCol; i++){
                ans.add(matrix[firstRow][i]);
            }
            firstRow++;
            if(firstRow > lastRow || firstCol > lastCol) break;
            // Move down
            for(int i =firstRow; i<= lastRow; i++){
                ans.add(matrix[i][lastCol]);
            }
            lastCol--;
            if(firstRow > lastRow || firstCol > lastCol) break;
            // Move left
            for(int i = lastCol; i >= firstCol; i--){
                ans.add(matrix[lastRow][i]);
            }
            lastRow--;
            if(firstRow > lastRow || firstCol > lastCol) break;
            // Move Up
            for(int i = lastRow; i >= firstRow; i--){
                ans.add(matrix[i][firstCol]);
            }
            firstCol++;
            if(firstRow > lastRow || firstCol > lastCol) break;
        }
        return ans;
    }
}