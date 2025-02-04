class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int i = 0; 
        int j = 1;
        int subMax = nums[0];
        while(j< nums.length){
            subMax += nums[j];
            if(nums[j-1] >= nums[j]){
                while(i < j){
                    subMax -= nums[i];
                    i++;
                }
            }
            ans = Math.max(ans, subMax);
            j++;
        }
        return ans;
    }
}