// 41. First Missing Positive 
// Given an unsorted integer array nums, return the smallest missing positive integer.
// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

import java.util.Arrays;

public class missPositive {
    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        System.out.println(Integer.toString(firstMissingPositive(nums)));
    }
    public static int firstMissingPositive(int[] nums) {
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
    public static void swap(int[]nums, int i, int correctPos){
        int temp=nums[i];
        nums[i]=nums[correctPos];
        nums[correctPos]=temp;
    }
}
