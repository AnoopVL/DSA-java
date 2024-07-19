class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> min = new ArrayList<>();
        // List<Integer> max = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< matrix.length; i++){
            int minInRow= matrix[i][0];
            for(int j=1; j< matrix[i].length; j++){
                minInRow= Math.min(matrix[i][j], minInRow);
            }
            min.add(minInRow);
        }
        for(int j=0; j<matrix[0].length;j++){
            int maxInColumn= matrix[0][j];
            for(int i=1; i<matrix.length;i++){
                maxInColumn= Math.max(matrix[i][j], maxInColumn);
            }
            if(min.contains(maxInColumn)){
                ans.add(maxInColumn);                
            }
        }
        return ans;
    }
}