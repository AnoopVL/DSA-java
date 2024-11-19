class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return 0;

        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        long windowSum = 0;

        int i = 0;
        for (int j = 0; j < n; j++) { 
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            windowSum += nums[j];
            if (j - i + 1 > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                windowSum -= nums[i];
                i++;
            }
            if (j - i + 1 == k && map.size() == k) {
                ans = Math.max(ans, windowSum);
            }
        }

        return ans;
    }
}
