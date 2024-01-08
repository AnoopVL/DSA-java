public class stringBuilder {
    public static void main(String[] args) {
        int[] arr = {21,23,45,656,45};
        int num = 68;
        String name = "Anoop Lanjekar";
        System.out.println(name); //Anoop Lanjekar
        String a = "anoop";
        System.out.println(a); //anoop
        a = "avl";
        System.out.println(a); //avl
        String a1 = "anoop";
        String a2 = "anoop";
        System.out.println(a1==a2); //true
        String a3 = new String("anoop");
        String a4 = new String("anoop");
        System.out.println(a3==a4); //false
        System.out.println(new int[] {1,2,3,4,5}); //[I@d716361
        
    }
}
