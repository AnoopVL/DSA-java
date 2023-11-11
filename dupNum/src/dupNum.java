// 287: Find the duplicate number

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space

public class dupNum {
public static void main(String[] args) {
    int[]arr={1,3,4,2,2};
    System.out.println(findDuplicate(arr));
}
static public int findDuplicate(int[] nums) {
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
static void swap(int[]nums, int i, int correctPos){
    int temp=nums[i];
    nums[i]=nums[correctPos];
    nums[correctPos]=temp;
}
    
}
