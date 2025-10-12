class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(rec(0, cost, n, dp), rec(1, cost, n, dp));
    }

    private int rec(int i, int[] cost, int n, int[] dp){
        if(i >= n) return 0;    
        if(dp[i] != -1) return dp[i];
        int oneStep = rec(i+1, cost, n, dp);
        int twoStep = rec(i+2, cost, n, dp);
        dp[i] = cost[i] + Math.min(oneStep, twoStep);
        return dp[i];
    }
}