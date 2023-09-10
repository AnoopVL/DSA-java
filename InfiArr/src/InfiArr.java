public class InfiArr{
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9,10,32,45,65,87,98,99,100,112,130,150,203,290,360,370,670,780,1200};
        int target = 32;
        System.out.println(ans(arr, target));
    }
    static int ans(int[] arr,int target){
        int start = 0;
        int end = 1;
        while(target>arr[end]){
            int newStart=end+1;
            end=end+(end-start+1)*2;
            start = newStart;
        }
        return bs(arr, target, start, end );

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