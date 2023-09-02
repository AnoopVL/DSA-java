public class Bsearch{
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,12,45,90,105};
        int start = 0;
        int end = arr.length -1;
        int target = 120;
        while(start <=end){
            int mid = (start + end) / 2;
            if (arr[mid] == target){
                System.out.println("Element found");
                break;
            }
            else if (target>arr[mid]){
                start = mid +1;
            }
            else if (target<arr[mid]){
                start = mid +1;
            }
            else{
                System.out.println("No such element exists in the given array!!");
                break;
            }
        }
    }
}