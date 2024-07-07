public class AVLmain {
    public static void main(String[] args) {
        AVL avl = new AVL();
        for(int i = 0 ; i <100; i++){
            avl.insert(i);
        }
        System.out.println(avl.getHeight());
    }
}
