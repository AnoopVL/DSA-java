
public class printNos {

    public static void main(String[] args) {
        // printReverseNos(5);
        // printNos(5);
        // factorial(5);
        // System.out.println(sumOfNos(5));
        // System.out.println(sumOfDigits(53652356));
        System.out.println(totalZeros(20104));
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
    static int totalZeros(int n){
        if(n==0){
            return 1;
        }
        int count = 0;
        if((n%10)==0){
            count++;
        }
        totalZeros(n/10);
        
    }
}