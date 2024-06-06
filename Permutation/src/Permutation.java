import java.util.ArrayList;

/**
 * Permutation
 */
public class Permutation {

    public static void main(String[] args) {
        String upProString = "abc";
        // permutation("", upProString);
        System.out.println(permutationArrayList("", upProString));
        System.out.println(permutationCount("", upProString));
        
    }
    public static void permutation(String proString, String unproString ){
        if (unproString.isEmpty()) {
            System.out.println(proString);
            return;
        }
        char ch = unproString.charAt(0);
        for(int i = 0; i<= proString.length(); i++){
            String firstString = proString.substring(0, i);
            String secondString = proString.substring(i, proString.length());
            permutation(firstString + ch + secondString, unproString.substring(1));
        }
    }
    public static ArrayList<String> permutationArrayList(String proString, String unproString ){
        if (unproString.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(proString);
            return list;
        }
        char ch = unproString.charAt(0);
        ArrayList<String> finalAns = new ArrayList<>();
        for(int i = 0; i<= proString.length(); i++){
            String firstString = proString.substring(0, i);
            String secondString = proString.substring(i, proString.length());
            finalAns.addAll(permutationArrayList(firstString + ch + secondString, unproString.substring(1)));
        }
        return finalAns;
    }
    public static int permutationCount(String proString, String unproString ){
        if (unproString.isEmpty()) {
            // System.out.println(proString);
            return 1;
        }
        char ch = unproString.charAt(0);
        int count = 0;
        for(int i = 0; i<= proString.length(); i++){
            String firstString = proString.substring(0, i);
            String secondString = proString.substring(i, proString.length());
            count = count + permutationCount(firstString + ch + secondString, unproString.substring(1));
        }
        return count;
    }
}