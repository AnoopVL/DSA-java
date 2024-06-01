public class RecursionProblems {

    public static void main(String[] args) {
        String a = "anoop";
        System.out.println(skipChar(a));
    }
    public static String skipChar(String str){
        if (str.isEmpty()) {
            return "";
        }
         char ch = str.charAt(0);
         if (ch == 'o') {
            return skipChar(str.substring(1));
         }
         else{
            return ch + skipChar(str.substring(1));
         }
    }

}