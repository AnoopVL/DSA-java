class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;
        int n= nums.length;
        for(int i=1; i< n; i++){
            if(nums[i] % 2 == nums[i-1] % 2 ) return false;
        }
        return true;
    }
}