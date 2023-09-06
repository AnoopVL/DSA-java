public class InfiArr{
    public static void main(String[] args) {
        
    }
    static int bs(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while(start <=end){
            int mid = (start + end) / 2;
        if (arr[mid] == target){
            return mid;
        }
        else if (target>arr[mid]){
            start = mid +1;
        }
        else if (target<arr[mid]){
            end = mid -1;
        }
    }
    return -1;
}
}