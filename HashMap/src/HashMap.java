import java.util.*;

public class HashMap {
    public static void main(String[] args) {
        // HashMap<String, Integer> map = new HashMap<>();
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        map.put("Anoop", 12);
        map.put("Kallappa", 21);
        map.put("AVL", 34);

        System.out.println(map.get("Anoop"));

    }
}
