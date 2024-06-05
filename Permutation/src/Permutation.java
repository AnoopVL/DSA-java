/**
 * Permutation
 */
public class Permutation {

    public static void main(String[] args) {
        String upProString = "abc";
        permutation("", upProString);
        
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
}