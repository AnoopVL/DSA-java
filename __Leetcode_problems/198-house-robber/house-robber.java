class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < n; i++){
            int rob = nums[i];
            if(i > 1) rob += prev2;
            int dont_rob = 0 + prev;
            int curr_i = Math.max(rob, dont_rob);
            prev2 = prev;
            prev = curr_i;
        }
        return prev;
    }

}