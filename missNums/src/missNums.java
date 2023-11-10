// 448. Find All Numbers Disappeared in an Array
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

import java.util.ArrayList;
import java.util.Arrays;

public class missNums {
    public static void main(String[] args) {
        int[]arr={4,2,5,7,1,2,1};
        //missNums(arr);
        System.out.println(Arrays.toString(missNums(arr)));
    }
    static int[] missNums(int[]arr){
        int i=0;
        while (i<arr.length) {
            int correct=arr[i]-1;
            if (arr[i]!=arr[correct]) {
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
        int[] missing = {-1,-1};
        int missArrIndex=0;
        // ArrayList<Integer> missingList = new ArrayList<>();

        for (int index = 0; index < arr.length; index++) {
            int correct=arr[index]-1;
            if (index!=correct) {
                missing[missArrIndex]=index+1;
                missArrIndex++;
                // missingList.add(index + 1);
            }
        }
        // int[] missingArray = new int[missingList.size()];
        // for (int j = 0; j < missingList.size(); j++) {
        //     missingArray[i] = missingList.get(i);
        // }
        return missing;
    }
    static void swap(int[]arr, int i, int correct ){
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
    
}