class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=1; i< n; i++){
            if(nums[i] == nums[i-1]){
                nums[i-1] = nums[i]*2;
                nums[i] = 0;
            }
        }
        return shiftZerosToRight(nums);
    }

    private int[] shiftZerosToRight(int[] nums){
        int n = nums.length;
        int index =0;
        for(int num: nums){
            if(num != 0){
                nums[index++] = num;
            }
        }
        while(index < n){
            nums[index++] = 0;
        }
        return nums;
    }
}