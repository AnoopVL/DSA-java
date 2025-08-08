class Solution {
    public int[][] operations = {{100,0},{75,25},{50,50},{25,75}};
   
    public double soupServings(int n) {
        if(n > 5000) return 1;
        double[][] memo = new double[n+1][n+1];
        for(double[] mem : memo){
            Arrays.fill(mem, -1.0);
        }
        return solve(n,n, memo);
    }

    private double solve(int a, int b, double[][] memo){
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1.0;
        if(b <= 0) return 0.0;
        if(memo[a][b] != -1.0) return memo[a][b];
        double probablity = 0.0;
        for(int[] opp : operations){
            int aTaken = opp[0];
            int bTaken = opp[1];
            probablity += solve(a - aTaken, b - bTaken, memo);
        }
        return memo[a][b] = 0.25 * probablity;
    }
}