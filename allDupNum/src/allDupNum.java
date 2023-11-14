// 442. Find all the duplicates in an array
// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
// You must write an algorithm that runs in O(n) time and uses only constant extra space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allDupNum {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println((findDuplicates(nums)));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while (i<nums.length) {
            int correctPos=nums[i]-1;
            if (nums[correctPos]!=nums[i]) {
                swap(nums, i, correctPos);
            }
            else{
                i++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            int correctPos=nums[index]-1;
            if (index!=correctPos) {
                ans.add(nums[index]);
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
