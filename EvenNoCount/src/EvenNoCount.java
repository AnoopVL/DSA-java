// 1295. Find Numbers with Even Number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

import java.util.Scanner;

public class EvenNoCount{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter how many elements you want to enter in the array :");
        int element = in.nextInt();
        System.out.println("Enter elements of the array :");
        int[] nums = new int[element];
        for(int i =0; i<element; i++){
            nums[i] = in.nextInt(); 
        }
        
        //int[] nums = {12,345,2,6,7896,123,21,435,23,54,54};
        int EvenCount = totalEven(nums);
        System.out.println("In the array the total number of digits with even number of digits is :" +EvenCount);
    }

    static int totalEven(int[] nums){
        int count = 0;
        for (int num : nums ){
            if(even(num)){
                count++;
            }
        }
        return count;
    }

    static boolean even(int num){
        int totalDigits = digits(num);
        if(totalDigits % 2 == 0){
            return true;
        }
        return false;
    }

    static int digits(int num){
        int count = 0;
        while (num > 0){      //num = 21        // num = 2
            count++;          // count = 1      //count = 2
            num = num /10;     // num = 2       //num = 0
        }
        return count;
    }

}