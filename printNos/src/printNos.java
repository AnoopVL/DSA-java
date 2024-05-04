
public class printNos {

    public static void main(String[] args) {
        // printReverseNos(5);
        // printNos(5);
        factorial(5);
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
        
        return 0;
    }
}