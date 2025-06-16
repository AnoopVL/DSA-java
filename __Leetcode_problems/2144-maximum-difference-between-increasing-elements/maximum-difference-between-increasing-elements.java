class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int prefixMin = nums[0];
        for(int i=1; i< nums.length; i++){
            if(prefixMin >= nums[i]){
                prefixMin = nums[i];
            }else{
                ans = Math.max(ans, nums[i]- prefixMin);
            }
        }
        return ans;
    }
}