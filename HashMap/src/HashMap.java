import java.util.*;

public class HashMap {
    public static void main(String[] args) {
        // HashMap<String, Integer> map = new HashMap<>();
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        map.put("Anoop", 12);
        map.put("Kallappa", 21);
        map.put("AVL", 34);

        System.out.println(map.get("Anoop"));
        System.out.println(map.getOrDefault("Zeno", 07));

        HashSet<Integer> hset = new HashSet<>();
        hset.add(23);
        hset.add(2);
        hset.add(23);
        hset.add(24);
        hset.add(13);
        hset.add(2);
        hset.add(76);

        System.out.println(hset);
        System.out.println(hset.size());
    }
}
