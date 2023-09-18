public class Bsearch{
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,12,45,90,105};
        int target = 120;
        int ans = bs(arr, target);
        System.out.println(ans);
    }
    static int bs(int[] arr, int target, int start, int end){
        // int start = 0;
        // int end = arr.length -1;
        while(start <=end){
            int mid =start+(end-start) / 2;
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