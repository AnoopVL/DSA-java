class Solution {
    public int singleNumber(int[] nums) {
        return xor(0, nums);
    }
    private int xor(int i, int[] nums){
        if(i == nums.length){
            return 0;
        }
        return nums[i] ^ xor(i+1, nums);
    }
}