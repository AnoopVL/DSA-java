import java.util.ArrayList;
import java.util.Arrays;

public class RecursionProblems {

    public static void main(String[] args) {
        String a = "anoop";
        // System.out.println(skipChar(a));
        System.out.println(subset("", a));
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
    public static ArrayList<String> subset(String processed, String unprocessed){
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subset(processed + ch, unprocessed.substring(1));
        ArrayList<String> right = subset(processed, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }

}