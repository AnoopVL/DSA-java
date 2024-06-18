class Solution {
    // run time 1ms
    
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                nums[pos++] = nums[i];
            
        }
        for(int i = pos; i < nums.length; i++)
            nums[i] = 0;
            
    }
}
// run time 3ms
 // int snowball = 0;
            // for(int i = 0; i < nums.length; i++){
            //     if(nums[i]==0){
            //         snowball++;
            //     }
            //     else if(snowball > 0){
            //         nums[i-snowball] += nums[i];
            //         nums[i]=0;
            //     }
            // } 