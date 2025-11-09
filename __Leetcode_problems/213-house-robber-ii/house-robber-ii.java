class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        if(n == 1){
            return nums[0]; 
        }
        for(int i = 0; i < n; i++){
            if(i == 0){
                nums1[0] = nums[i];
            }else if(i == n-1){
                nums2[i-1] = nums[i]; 
            }else{
                nums1[i] = nums[i];
                nums2[i-1] = nums[i];
            }
        }
        return Math.max(helper(nums1), helper(nums2));
    }

    private int helper(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i = 0; i < n; i++){
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