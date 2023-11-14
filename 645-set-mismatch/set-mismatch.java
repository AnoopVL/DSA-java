class Solution {
    public int[] findErrorNums(int[] nums) {
        int i=0;
        while (i<nums.length) {
            int correctPos=nums[i]-1;
            if (nums[i]!=nums[correctPos]) {
                swap(nums, i, correctPos);
            }
            else{
                i++;
            }
        }
        // int[]ans={-1,-1};
        for (int index = 0; index < nums.length; index++) {
            int correctPos=nums[index]-1;
            if (index!=correctPos) {
                // ans[0]=nums[index];
                // ans[1]=index+1;
                return new int[] {nums[index], index+1};
            }
        }
        return new int[] {-1,-1};
    }
    public void swap(int[]nums, int i, int correctPos){
        int temp=nums[i];
        nums[i]=nums[correctPos];
        nums[correctPos]=temp;
    }
}