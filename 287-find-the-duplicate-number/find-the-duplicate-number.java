class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while (i<nums.length) {
            int correctPos = nums[i]-1;
            if(nums[i]!=nums[correctPos]){
                swap(nums, i, correctPos);
            }
            else{
                i++;
            }
        }
        int missing =-1;
        for (int index = 0; index < nums.length; index++) {
            int correct=nums[index]-1;
            if (index!=correct) {
                missing=nums[index];
            }
        }
        return missing;
}
public void swap(int[]nums, int i, int correctPos){
    int temp=nums[i];
    nums[i]=nums[correctPos];
    nums[correctPos]=temp;
}
}