class Solution {
    public int maxSum(int[] nums) {
        int sum = 0;
        int max = -100;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            max = Math.max(max, nums[i]);
            if(nums[i] >= 0) sum += nums[i];
            set.add(nums[i]);
        }
        return (max < 0)? max : sum;
    }
}