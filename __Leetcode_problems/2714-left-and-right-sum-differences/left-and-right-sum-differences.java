class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum =0;
        int rightSum =0;
        for(int num: nums){
            rightSum+= num;
        }
        for(int i=0; i < nums.length; i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            nums[i] = Math.abs((leftSum-nums[i]) - rightSum);
        }
        return nums;
    }
}