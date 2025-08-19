class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                long c = 0;
                while(i < nums.length){
                    if(nums[i] == 0){
                        c++;
                        i++;
                    }else{
                        i++;
                        break;
                    }
                }
                ans += (c * (c+1))/2;
            }else{
                i++;
            }
        }
        return ans;
    }
}