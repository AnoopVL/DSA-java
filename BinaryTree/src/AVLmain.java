public class AVLmain {
    public static void main(String[] args) {
        AVL avl = new AVL();
        for(int i = 0 ; i <8; i++){
            avl.insert(i);
        }
        System.out.println(avl.getHeight());
        avl.prettyDisplay();
    }
}
