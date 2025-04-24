class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int totalCount = 0;
        int n = nums.length;
        Set<Integer> distinctSet = new HashSet<>();
        for (int num : nums) {
            distinctSet.add(num);
        }
        int totalDistinct = distinctSet.size();
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalDistinct) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
}