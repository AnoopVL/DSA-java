class Solution {
    public int minOperations(int[] nums) {
        int i=0;
        int j= i+2;
        int ans = 0;
        while(j < nums.length){
            if(nums[i] == 0){
                for(int index = i; index <= j; index++){
                    nums[index] = (nums[index] == 0) ? 1 : 0;
                }
                ans++;
            }
            i++;
            j++;
        }
        for(int index =0; index < nums.length; index++){
            if(nums[index] == 0) return -1;
        }
        return ans;
    }
}