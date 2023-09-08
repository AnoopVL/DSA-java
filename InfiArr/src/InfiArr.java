public class InfiArr{
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9,10};
        int target = 4;
        int ans = bs(arr, target);
    }
    static int ans(int[] arr,int target){
        int start = 0;
        int end = 0;
    }
    static int bs(int[] arr, int target, int start, int end){
        while(start <=end){
            int mid = (start + end) / 2;
        if (target>arr[mid]){
            start = mid +1;
        }
        else if (target<arr[mid]){
            end = mid -1;
        }
        else{
            return mid;
        }
    }
    return -1;
}
}