class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        int windowSum = 0;

        while (j < nums.length) {
            windowSum += nums[j];
            while (windowSum >= target) {
                ans = Math.min(ans, j - i + 1);
                windowSum -= nums[i];
                i++;
            }
            j++;
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}
