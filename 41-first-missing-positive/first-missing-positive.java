class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctPos=nums[i]-1;
            if(nums[i]>0 && nums[i] <=nums.length && nums[i]!=nums[correctPos]){
                swap(nums, i, correctPos);
            }
            else{
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if(nums[index]!=index+1){
                return index+1;
            }
        }
        return nums.length+1;   
    }
    public void swap(int[]nums, int i, int correctPos){
        int temp=nums[i];
        nums[i]=nums[correctPos];
        nums[correctPos]=temp;
    }
}