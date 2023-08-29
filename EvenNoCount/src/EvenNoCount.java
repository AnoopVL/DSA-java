// 1295. Find Numbers with Even Number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class EvenNoCount{
    public static void main(String[] args) {
        int digit = even(23434);
        System.out.println(digit);
    }
    static int even(int num){
        int count = 0;
        while (num > 0){      //num = 21        // num = 2
            count++;          // count = 1      //count = 2
            num = num /10;     // num = 2       //num = 0
        }
        return count;
    }

}