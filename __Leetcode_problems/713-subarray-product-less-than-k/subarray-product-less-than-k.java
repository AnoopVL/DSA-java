class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int i=0, j=0;
        int ans =0;
        int windowProduct =1;
        while(j < nums.length){
            windowProduct*= nums[j];
            while(windowProduct >= k && i <= j){
                windowProduct/=nums[i];
                i++;
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
}
// this one was giving wrong answer
            // windowProduct = (windowProduct == 1) ? nums[j] : windowProduct*nums[j]; 
            // if(windowProduct < k){
            //     ans+= j-i+1;
            //     // continue;
            // }
            // else{
            // // // if(windowProduct >= k){
            //     while(windowProduct >= k && i <= j){
            //         windowProduct/=nums[i];
            //         i++;
            //     }
            //     if(windowProduct < k){
            //         ans++;
            //     }
            // }