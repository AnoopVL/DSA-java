public class RecursionPattern {

    public static void main(String[] args) {
        // reverseLeftTriangle(5, 0);
        leftTriangle(5, 0);
    }
    public static void reverseLeftTriangle(int row, int col){
        if(row == 0){
            return;
        }
        if(col<row){
            System.out.print("* \t" );
            reverseLeftTriangle(row, col+1);
        }
        else{
            System.out.println();
            reverseLeftTriangle(row-1, 0);
        }
    }
    public static void leftTriangle(int row, int col){
        if(row == 0){
            return;
        }
        if(col<row){
            leftTriangle(row, col+1);
            System.out.print("* \t");
        }
        else{
            leftTriangle(row-1, 0);
            System.out.println();
        }
    }
}