class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n-1, nums, dp);
    }

    private int helper(int index, int[] nums, int[] dp){
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];

        int rob = nums[index] + helper(index - 2, nums, dp);
        int dont_rob = 0 + helper(index - 1, nums, dp);

        return dp[index] = Math.max(rob, dont_rob);
    }

}