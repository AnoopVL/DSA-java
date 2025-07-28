class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num: nums){
            maxOr = maxOr | num;
        }
        return helper(nums, maxOr, 0, 0);
    }
    private int helper(int[] nums, int target, int index, int temp){
        if(index == nums.length) return (target == temp) ? 1 : 0; 
        int include = helper(nums, target, index + 1, temp | nums[index]);
        int exclude = helper(nums, target, index + 1, temp);
        return include + exclude;
    }
}