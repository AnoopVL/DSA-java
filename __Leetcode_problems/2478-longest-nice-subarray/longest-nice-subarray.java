class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int start = 0;
        int windowAnd = 0;

        for (int end = 0; end < n; end++) {
            while ((windowAnd & nums[end]) != 0) {
                windowAnd ^= nums[start];
                start++;
            }
            windowAnd |= nums[end];
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}