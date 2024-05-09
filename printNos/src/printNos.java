
public class printNos {

    public static void main(String[] args) {
        // printReverseNos(5);
        // printNos(5);
        // factorial(5);
        // System.out.println(sumOfNos(5));
        // System.out.println(sumOfDigits(53652356));
        // System.out.println(totalZeros(20104));
        // System.out.println(countZeros(10390));
        System.out.println(numberOfSteps(12013));
    }
    static void printReverseNos(int n){
        if (n<0) {
            return;
        }
        System.out.println(n);
        printReverseNos(n-1);
    }
    static void printNos(int n){
        if (n<0) {
            return;
        }
        printNos(n-1);
        System.out.println(n);
    }
    static int factorial(int n){
        if (n==0) {
            return 1;
        }
        int fact = n * factorial(n-1);
        System.out.println(fact);
        return fact;
    }
    static int sumOfNos(int n){
        if(n==0){
            return n;
        }
        int sum = n + sumOfNos(n-1);
        return sum;
    }
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        int sum = (n%10) + sumOfDigits(n/10);
        return sum;
    }
    static int countZeros(int n){
        return helper(n, 0);
    }
    static int helper(int n, int c){
       if(n==0){
        return c;
       }
       int rem = n%10;
       if(rem==0){
        return helper(n/10, c+1);
       }
       return helper(n/10,c);
    }
    
    static int numberOfSteps(int n){
        return helperNOS(n, 0);
    }
    static int helperNOS(int n, int steps){
        if(n==0){
            return steps;
        }
        if(n%2==0){
            return helperNOS(n/2, steps+1);
        }
        return helperNOS(n-1, steps+1);
    }
}