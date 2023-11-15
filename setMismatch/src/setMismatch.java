// 645. Set Mismatch
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
// You are given an integer array nums representing the data status of this set after the error.
// Find the number that occurs twice and the number that is missing and return them in the form of an array.

import java.util.Arrays;

public class setMismatch {
    public static void main(String[] args) {
        int[]nums={4,5,3,1,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    public static int[] findErrorNums(int[] nums) {
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
        int[]ans={-1,-1};
        for (int index = 0; index < nums.length; index++) {
            int correctPos=nums[index]-1;
            if (index!=correctPos) {
                ans[0]=index+1;
                ans[1]=nums[index];
            }
        }
        return ans;
    }
    public static void swap(int[]nums, int i, int correctPos){
        int temp=nums[i];
        nums[i]=nums[correctPos];
        nums[correctPos]=temp;
    }
}
